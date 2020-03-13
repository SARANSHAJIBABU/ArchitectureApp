package com.example.architectureapplication

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import javax.inject.Inject

class NoteRepository @Inject constructor(val dao: NoteDaoKt) {

    val allNotes: LiveData<List<NoteKt>> = dao.getNotes()

    fun insert(note: NoteKt) = InsertNoteAsyncTask(dao).execute(note)

    fun update(note: NoteKt) = UpdateNoteAsyncTask(dao).execute(note)

    fun delete(note: NoteKt) = DeleteNoteAsyncTask(dao).execute(note)

    fun deleteAllNotes() = DeleteAllNoteAsyncTask(dao).execute()

    inner class InsertNoteAsyncTask(val dao: NoteDaoKt) : AsyncTask<NoteKt, Void, Void>() {

        override fun doInBackground(vararg note: NoteKt?): Void? {
            dao.insert(note[0]!!)
            return null
        }

    }

    inner class UpdateNoteAsyncTask(val dao: NoteDaoKt) : AsyncTask<NoteKt, Void, Void>() {

        override fun doInBackground(vararg note: NoteKt?): Void? {
            dao.update(note[0]!!)
            return null
        }

    }

    inner class DeleteNoteAsyncTask(val dao: NoteDaoKt) : AsyncTask<NoteKt, Void, Void>() {

        override fun doInBackground(vararg note: NoteKt?): Void? {
            dao.delete(note[0]!!)
            return null
        }

    }

    inner class DeleteAllNoteAsyncTask(val dao: NoteDaoKt) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg note: Void?): Void? {
            dao.deleteAllNotes()
            return null
        }

    }
}
