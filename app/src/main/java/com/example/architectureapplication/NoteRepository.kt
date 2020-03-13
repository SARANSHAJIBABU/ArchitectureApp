package com.example.architectureapplication

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import javax.inject.Inject

class NoteRepository @Inject constructor(val dao: NoteDao) {

    val allNotes: LiveData<List<Note>> = dao.getNotes()

    fun insert(note: Note) = InsertNoteAsyncTask(dao).execute(note)

    fun update(note: Note) = UpdateNoteAsyncTask(dao).execute(note)

    fun delete(note: Note) = DeleteNoteAsyncTask(dao).execute(note)

    fun deleteAllNotes() = DeleteAllNoteAsyncTask(dao).execute()

    inner class InsertNoteAsyncTask(val dao: NoteDao) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg note: Note?): Void? {
            dao.insert(note[0]!!)
            return null
        }

    }

    inner class UpdateNoteAsyncTask(val dao: NoteDao) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg note: Note?): Void? {
            dao.update(note[0]!!)
            return null
        }

    }

    inner class DeleteNoteAsyncTask(val dao: NoteDao) : AsyncTask<Note, Void, Void>() {

        override fun doInBackground(vararg note: Note?): Void? {
            dao.delete(note[0]!!)
            return null
        }

    }

    inner class DeleteAllNoteAsyncTask(val dao: NoteDao) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg note: Void?): Void? {
            dao.deleteAllNotes()
            return null
        }

    }
}
