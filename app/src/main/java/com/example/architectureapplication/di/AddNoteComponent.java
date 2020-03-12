package com.example.architectureapplication.di;

import com.example.architectureapplication.AddNoteActivityKt;

import dagger.Subcomponent;

@Subcomponent()
public interface AddNoteComponent {

    @Subcomponent.Builder
    interface Builder{
        AddNoteComponent build();
    }

    void inject(AddNoteActivityKt addNoteActivity);
}

