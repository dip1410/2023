package com.example.mylearningcodes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mylearningcodes.di.DaggerApiComponent;
import com.example.mylearningcodes.network.model.Request;
import com.example.mylearningcodes.network.model.ResponseUser;
import com.example.mylearningcodes.network.model.UserPost;
import com.example.mylearningcodes.network.services.UserPostAPI;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity2 extends AppCompatActivity {

    private TextView mytextview;
    private Button btnGET, btnGETById;
    private UserPostAPI userpostsApi;

    @Inject
    public Retrofit retrofitInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // this tells this activity will use dagger for di
        DaggerApiComponent.create().inject2(this);

        mytextview = findViewById(R.id.mytextview);
        btnGET = findViewById(R.id.buttonGET);
        btnGETById = findViewById(R.id.buttonGETById);

        // Retrofit instance injected from Dagger
        userpostsApi = retrofitInstance.create(UserPostAPI.class);

        btnGET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytextview.setText("");
                getPosts();
            }
        });

        btnGETById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytextview.setText("");
                getPostMethodCall();
            }
        });
    }

    private void getPosts() {

        Call<List<UserPost>> call = userpostsApi.getUserPosts();
        call.enqueue(new Callback<List<UserPost>>() {
            @Override
            public void onResponse(Call<List<UserPost>> call, Response<List<UserPost>> response) {
                if (!response.isSuccessful()) {
                    mytextview.setText("Code: " + response.code());
                    return;
                }
                List<UserPost> posts = response.body();

                for (UserPost post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    mytextview.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<UserPost>> call, Throwable t) {

            }
        });

    }//post

    private void getPostMethodCall() {

        Request request=new Request();
        request.setName("TestUser");
        request.setJob("Test");

        Call<ResponseUser> call = userpostsApi.getPostResponse(request);
        call.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {

                // server will return new field id only
                String content = "";
                content += "Body : " + response.body().getName() + "\n";
                content += "Title: " + response.body().getJob() + "\n";
                content += "ID FROM SERVER ( Changes On Every Call ): " + response.body().getId() + "\n";

                mytextview.append(content);

            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {

            }
        });

    }//post

}// mainactivity
