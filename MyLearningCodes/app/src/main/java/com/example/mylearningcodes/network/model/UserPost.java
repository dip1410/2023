package com.example.mylearningcodes.network.model;

import com.google.gson.annotations.SerializedName;

public class UserPost {

    private String title;
    @SerializedName("userId")
    private int id;
    @SerializedName("body")
    private String text;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}