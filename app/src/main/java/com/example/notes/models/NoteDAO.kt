package com.example.notes.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface NoteDAO {
    @Query("SELECT * FROM notes")
    fun getAllNotes() :List<Notes>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNotesById(id: Int) : Notes

    @Insert
    fun addNotes(notes: Notes)

    @Delete
    fun deleteNotes(note: Notes)
    abstract fun addNote(note: Notes)
}
