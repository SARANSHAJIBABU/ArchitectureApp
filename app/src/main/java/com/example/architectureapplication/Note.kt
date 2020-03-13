package com.example.architectureapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
        val title:String,
        val description:String,
        @ColumnInfo(name = "note_priority") val priority:Int){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
