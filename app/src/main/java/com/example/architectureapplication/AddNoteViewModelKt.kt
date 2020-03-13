package com.example.architectureapplication

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AddNoteViewModelKt @Inject constructor(val noteRepository: NoteRepository)
    :ViewModel(){

    fun insert(note:NoteKt) = noteRepository.insert(note)

}
