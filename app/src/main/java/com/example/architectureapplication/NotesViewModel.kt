package com.example.architectureapplication

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class NotesViewModel @Inject constructor(val noteRepository:NoteRepository)
    :ViewModel() {

    fun insert(note:NoteKt) = noteRepository.insert(note)

    fun update(note:NoteKt) = noteRepository.update(note)

    fun delete(note:NoteKt) = noteRepository.delete(note)

    fun deleteAllNotes() = noteRepository.deleteAllNotes()

    fun getAllNotes() = noteRepository.allNotes
}
