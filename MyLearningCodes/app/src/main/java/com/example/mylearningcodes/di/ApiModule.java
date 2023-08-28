package com.example.mylearningcodes.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Provides
    public Retrofit profideRetrofiInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
