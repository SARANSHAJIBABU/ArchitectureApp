package com.example.architectureapplication.di;

import com.example.architectureapplication.MainActivityKt;

import dagger.Subcomponent;

@Subcomponent()
public interface MainComponent {

    @Subcomponent.Builder
    interface Builder{
        MainComponent build();
    }

    void inject(MainActivityKt mainActivity);
}
