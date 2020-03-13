package com.example.architectureapplication.kt

import android.app.Application
import com.example.architectureapplication.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): NoteDatabase
            = NoteDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideNoteDao(db: NoteDatabase) = db.noteDao()
}
