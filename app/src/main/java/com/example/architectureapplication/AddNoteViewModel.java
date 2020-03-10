package com.example.architectureapplication;

import android.util.Log;

import javax.inject.Inject;

public class AddNoteViewModel{

    private NoteRepository noteRepository;

    @Inject
    public AddNoteViewModel(NoteRepository repository) {
        noteRepository = repository;
        Log.d("TEST","Creating AddNoteViewModel");
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }
}
