package com.example.architectureapplication.kt

import com.example.architectureapplication.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainComponent {
    fun inject(MainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder{
        fun build(): MainComponent
    }
}
