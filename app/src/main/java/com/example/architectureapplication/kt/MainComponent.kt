package com.example.architectureapplication.kt

import com.example.architectureapplication.MainActivityKt
import dagger.Subcomponent

@Subcomponent
interface MainComponent {
    fun inject(mainActivityKt: MainActivityKt)

    @Subcomponent.Builder
    interface Builder{
        fun build(): MainComponent
    }
}
