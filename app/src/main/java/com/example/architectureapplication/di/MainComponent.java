package com.example.architectureapplication.di;

import com.example.architectureapplication.MainActivity;

import dagger.Subcomponent;

@Subcomponent()
public interface MainComponent {

    @Subcomponent.Builder
    interface Builder{
        MainComponent build();
    }

    void inject(MainActivity mainActivity);
}
