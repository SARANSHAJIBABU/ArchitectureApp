package com.example.architectureapplication

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NotesViewModel @Inject constructor(val noteRepository:NoteRepository)
    :ViewModel() {

    fun insert(note:Note) = noteRepository.insert(note)

    fun update(note:Note) = noteRepository.update(note)

    fun delete(note:Note) = noteRepository.delete(note)

    fun deleteAllNotes() = noteRepository.deleteAllNotes()

    fun getAllNotes() = noteRepository.allNotes
}
