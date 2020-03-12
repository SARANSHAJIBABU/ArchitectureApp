package com.example.architectureapplication.di;

import android.app.Application;

import com.example.architectureapplication.NoteDaoKt;
import com.example.architectureapplication.NoteDatabaseKt;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    public NoteDatabaseKt provideDb(Application application){
        return NoteDatabaseKt.Companion.getInstance(application);
    }

    @Singleton
    @Provides
    public NoteDaoKt provideNoteDao(NoteDatabaseKt db){
        return db.noteDao();
    }

}
