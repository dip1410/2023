package com.example.mylearningcodes.network.services;

import com.example.mylearningcodes.network.model.Request;
import com.example.mylearningcodes.network.model.ResponseUser;
import com.example.mylearningcodes.network.model.UserPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserPostAPI {
    @GET("posts")
    Call<List<UserPost>> getUserPosts();

    @GET("posts")
    Call<List<UserPost>> getPostsById(@Query("userId") Integer userId);

  // BASE URL 2
    @POST("users")
    Call<ResponseUser> getPostResponse(@Body Request request);

}
