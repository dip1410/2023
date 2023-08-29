package com.example.mylearningcodes.di;

import com.example.mylearningcodes.MainActivity;
import com.example.mylearningcodes.MainActivity2;

import dagger.Component;

@Component(modules={ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity mainActivity); // this tells the modules will be consumed by this activity named MainAcivity
    void inject2(MainActivity2 mainActivty2);
}
