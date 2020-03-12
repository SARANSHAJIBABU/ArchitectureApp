package com.example.architectureapplication;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class NoteRepository {
    private NoteDaoKt noteDao;
    private LiveData<List<NoteKt>> allNotes;

    @Inject
    public NoteRepository(NoteDaoKt dao) {
        noteDao = dao;
        allNotes = noteDao.getNotes();
    }

    public void insert(NoteKt note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(NoteKt note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(NoteKt note) {
        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<NoteKt>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<NoteKt,Void,Void>{
        private NoteDaoKt noteDao;
        public InsertNoteAsyncTask(NoteDaoKt nDao) {
            this.noteDao = nDao;
        }

        @Override
        protected Void doInBackground(NoteKt... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<NoteKt,Void,Void>{
        private NoteDaoKt noteDao;
        public UpdateNoteAsyncTask(NoteDaoKt nDao) {
            this.noteDao = nDao;
        }

        @Override
        protected Void doInBackground(NoteKt... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<NoteKt,Void,Void>{
        private NoteDaoKt noteDao;
        public DeleteNoteAsyncTask(NoteDaoKt nDao) {
            this.noteDao = nDao;
        }

        @Override
        protected Void doInBackground(NoteKt... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>{
        private NoteDaoKt noteDao;
        public DeleteAllNotesAsyncTask(NoteDaoKt nDao) {
            this.noteDao = nDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }


}
