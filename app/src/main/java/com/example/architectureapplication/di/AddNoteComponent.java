package com.example.architectureapplication.di;

import com.example.architectureapplication.AddNoteActivity;
import com.example.architectureapplication.AddNoteActivityKt;
import com.example.architectureapplication.MainActivity;

import dagger.Subcomponent;

@Subcomponent()
public interface AddNoteComponent {

    @Subcomponent.Builder
    interface Builder{
        AddNoteComponent build();
    }

    void inject(AddNoteActivity addNoteActivity);
    void inject(AddNoteActivityKt addNoteActivity);
}

