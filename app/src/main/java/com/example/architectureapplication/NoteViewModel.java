package com.example.architectureapplication;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

public class NoteViewModel extends ViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<NoteKt>> allNotes;


    @Inject
    public NoteViewModel(NoteRepository repository) {
        Log.d("TEST","Creating NoteViewModel");
        noteRepository = repository;
        allNotes = noteRepository.getAllNotes();
    }

    public void insert(NoteKt note){
        noteRepository.insert(note);
    }

    public void update(NoteKt note){
        noteRepository.update(note);
    }

    public void delete(NoteKt note) {
        noteRepository.delete(note);
    }

    public void deleteAllNotes() {
        noteRepository.deleteAllNotes();
    }

    public LiveData<List<NoteKt>> getAllNotes() {
        return allNotes;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("TEST","Clearing NoteViewModel");
    }

}
