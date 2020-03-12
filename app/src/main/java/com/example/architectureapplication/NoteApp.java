package com.example.architectureapplication;

import android.app.Application;

import com.example.architectureapplication.kt.AppComponent;
import com.example.architectureapplication.kt.DaggerAppComponent;


public class NoteApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
