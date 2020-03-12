package com.example.architectureapplication.di;

import android.app.Application;

import com.example.architectureapplication.NoteDao;
import com.example.architectureapplication.NoteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    public NoteDatabase provideDb(Application application){
        return NoteDatabase.getInstance(application);
    }

    @Singleton
    @Provides
    public NoteDao provideNoteDao(NoteDatabase db){
        return db.noteDao();
    }

}
