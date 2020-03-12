package com.example.architectureapplication.kt

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun mainComponent(): MainComponent.Builder
    fun addNoteComponent(): AddNoteComponent.Builder

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(app:Application): Builder

        fun build():AppComponent
    }
}
