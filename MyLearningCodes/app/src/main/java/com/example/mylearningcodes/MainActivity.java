package com.example.mylearningcodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mylearningcodes.network.model.UserPost;
import com.example.mylearningcodes.network.services.UserPostAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mytextview;
    private Button btnGET, btnGETById;
    private UserPostAPI userpostsApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytextview = findViewById(R.id.mytextview);
        btnGET = findViewById(R.id.buttonGET);
        btnGETById = findViewById(R.id.buttonGETById);

        // Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userpostsApi = retrofit.create(UserPostAPI.class);

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
                getPostsById();
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
    private void getPostsById() {

        Call<List<UserPost>> call = userpostsApi.getPostsById(4);
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

}// mainactivity
