package com.example.architectureapplication;

import android.app.Application;

import com.example.architectureapplication.di.AppComponent;
import com.example.architectureapplication.di.DaggerAppComponent;

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
