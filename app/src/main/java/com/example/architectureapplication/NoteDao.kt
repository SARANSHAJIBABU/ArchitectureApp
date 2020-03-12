package com.example.architectureapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDaoKt {

    @Insert
    fun insert(note: NoteKt)

    @Update
    fun update(note: NoteKt)

    @Delete
    fun delete(note: NoteKt)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY note_priority DESC")
    fun getNotes(): LiveData<List<NoteKt>>
}
