package com.example.architectureapplication;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class AddNoteViewModel extends ViewModel {

    private NoteRepository noteRepository;

    @Inject
    public AddNoteViewModel(NoteRepository repository) {
        noteRepository = repository;
        Log.d("TEST","Creating AddNoteViewModel");
    }

    public void insert(NoteKt note){
        noteRepository.insert(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TEST","Clearing AddNoteViewModel");
    }
}
