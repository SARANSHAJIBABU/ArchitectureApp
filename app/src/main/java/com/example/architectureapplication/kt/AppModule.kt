package com.example.architectureapplication.kt

import android.app.Application
import com.example.architectureapplication.NoteDatabaseKt
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): NoteDatabaseKt
            = NoteDatabaseKt.getInstance(app)

    @Singleton
    @Provides
    fun provideNoteDao(db: NoteDatabaseKt) = db.noteDao()
}
