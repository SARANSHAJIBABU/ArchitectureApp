package com.example.architectureapplication.di;

import android.app.Application;

import com.example.architectureapplication.AddNoteActivity;
import com.example.architectureapplication.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MainActivity mainActivity);

    void inject(AddNoteActivity addNoteActivity);
}
