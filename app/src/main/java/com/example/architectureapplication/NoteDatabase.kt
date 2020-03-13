package com.example.architectureapplication

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Note::class), version = 1)
abstract class NoteDatabase: RoomDatabase(){

    companion object{

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase{
            val tempInstance = INSTANCE

            if(tempInstance!=null)
                return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_database")
                        .addCallback(
                                object : RoomDatabase.Callback() {

                                    override fun onCreate(db: SupportSQLiteDatabase) {
                                        super.onCreate(db)
                                        PopulateDbAsyncTask(INSTANCE!!).execute()
                                    }
                                }
                        )
                        .build()

                INSTANCE = instance
                return instance
            }

        }

    }
    abstract fun noteDao(): NoteDao

    class PopulateDbAsyncTask(database: NoteDatabase) : AsyncTask<Void, Void, Void>() {

        val dao: NoteDao = database.noteDao()

        override fun doInBackground(vararg p0: Void?): Void? {
            dao.insert(Note("Title1","Description1",1))
            dao.insert(Note("Title2","Description2",2))
            dao.insert(Note("Title3","Description3",3))
            return null
        }

    }

}
