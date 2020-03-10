package com.example.architectureapplication;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class NoteViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;


    @Inject
    public NoteViewModel(NoteRepository repository) {
        Log.d("TEST","Creating NoteViewModel");
        noteRepository = repository;
        allNotes = noteRepository.getAllNotes();
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }

    public void update(Note note){
        noteRepository.update(note);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }

    public void deleteAllNotes() {
        noteRepository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
