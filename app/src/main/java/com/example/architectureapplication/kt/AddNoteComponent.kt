package com.example.architectureapplication.kt

import com.example.architectureapplication.AddNoteActivityKt
import dagger.Subcomponent

@Subcomponent
interface AddNoteComponent {
    fun inject(activityKt: AddNoteActivityKt)

    @Subcomponent.Builder
    interface Builder{
        fun build(): AddNoteComponent
    }
}
