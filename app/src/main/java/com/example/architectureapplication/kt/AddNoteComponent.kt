package com.example.architectureapplication.kt

import com.example.architectureapplication.AddNoteActivity
import dagger.Subcomponent

@Subcomponent
interface AddNoteComponent {
    fun inject(activityKt: AddNoteActivity)

    @Subcomponent.Builder
    interface Builder{
        fun build(): AddNoteComponent
    }
}
