package com.example.mylearningcodes.network.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String BASE_URL2="https://reqres.in/api/";
    private static Retrofit retrofit = null;
    private UserPostAPI api;

     public static Retrofit getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
        return retrofit;
    }
}



