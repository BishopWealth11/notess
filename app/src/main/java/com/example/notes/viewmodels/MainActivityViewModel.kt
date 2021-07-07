package com.example.notes.viewmodels

import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.models.NoteDatabase
import com.example.notes.models.Notes


class MainActivityViewModel: ViewModel(){
    private lateinit var database: NoteDatabase
    val notesLiveData =MutableLiveData<List<Notes>>()


    fun getNotes(database: NoteDatabase){
        notesLiveData.postValue(database.noteDao().getAllNotes())

    }
    fun addNote(database: NoteDatabase, note: Notes) {
        database.noteDao().addNote(note)
        getNotes(database)

    }

    }
