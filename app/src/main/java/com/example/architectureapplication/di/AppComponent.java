package com.example.architectureapplication.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, AppSubComponents.class})
public interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


    MainComponent.Builder mainComponent();
    AddNoteComponent.Builder addNoteComponent();
}
