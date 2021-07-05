package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.models.NoteDatabase
import com.example.notes.models.Notes

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase:: class.java,
            "note_database"
        ).build()
    }
    private fun saveNote(title: String, content: String) {
        val note = Notes(id = 0, title, content)
    }
}