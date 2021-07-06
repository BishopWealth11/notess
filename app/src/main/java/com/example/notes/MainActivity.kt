package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.Room
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.models.NoteDatabase
import com.example.notes.models.Notes

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase:: class.java,
            "note_database"
        ).allowMainThreadQueries().build()

        noteAdapter = NoteAdapter(database.noteDao().getAllNotes())
        binding.notesRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }
        binding.button.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val content = binding.contentInput.toString()
        }
    }
    private fun saveNote(title: String, content: String) {
        val note = Notes(id = 0, title, content)
        database.noteDao().addNotes(note)
        noteAdapter.notifyDataSetChanged()
    }
}