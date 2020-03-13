package com.example.architectureapplication

import android.app.Application
import com.example.architectureapplication.kt.DaggerAppComponent

class NoteAppKt: Application(){

    val appComponent by lazy {
        DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}
