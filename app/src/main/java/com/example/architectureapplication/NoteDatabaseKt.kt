package com.example.architectureapplication

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(NoteKt::class), version = 1)
abstract class NoteDatabaseKt: RoomDatabase(){

    companion object{

        @Volatile
        private var INSTANCE: NoteDatabaseKt? = null

        fun getInstance(context: Context): NoteDatabaseKt{
            val tempInstance = INSTANCE

            if(tempInstance!=null)
                return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabaseKt::class.java,
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
    abstract fun noteDao(): NoteDaoKt

    class PopulateDbAsyncTask(database: NoteDatabaseKt) : AsyncTask<Void, Void, Void>() {

        val dao: NoteDaoKt = database.noteDao()

        override fun doInBackground(vararg p0: Void?): Void? {
            dao.insert(NoteKt("Title1","Description1",1))
            dao.insert(NoteKt("Title2","Description2",2))
            dao.insert(NoteKt("Title3","Description3",3))
            return null
        }

    }

}
