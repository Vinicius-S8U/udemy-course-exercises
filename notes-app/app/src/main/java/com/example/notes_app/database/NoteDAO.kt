package com.example.notes_app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notes_app.model.Note

@Dao
interface NoteDAO {

    @Insert
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("Select * From Note Order By id Desc")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("Select * from Note where noteTitle Like :query Or noteBody Like :query")
    fun searchNote(query: String): LiveData<List<Note>>
}