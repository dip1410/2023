package com.example.mylearningcodes.di;

import com.example.mylearningcodes.MainActivity;

import dagger.Component;

@Component(modules={ApiModule.class})
public interface ApiComponent {
    void injetc(MainActivity mainActivity);
}
