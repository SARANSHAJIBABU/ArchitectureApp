package com.example.architectureapplication

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(val noteRepository: NoteRepository)
    :ViewModel(){

    fun insert(note:Note) = noteRepository.insert(note)

}
