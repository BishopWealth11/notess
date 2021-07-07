package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.EntityDeletionOrUpdateAdapter
import androidx.room.Room
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.models.NoteDatabase
import com.example.notes.models.Notes
import com.example.notes.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: NoteDatabase
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       //instantiating database
        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase:: class.java,
            "note_database"
        ).allowMainThreadQueries().build()

        //instantiating viewModel
        var viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java

                //observe Live Data from ViewModel


                noteAdapter = NoteAdapter (database.noteDao().getAllNotes()){
            val intent = Intent(this@MainActivity, NoteDetailsActivity::class.java)
            intent.run {
                putExtra("id", it.id)
                startActivity(this)
            }
        }
                binding . notesRv . apply {
            var layoutManager = LinearLayoutManager(this@MainActivity)
            var adapter = noteAdapter
        }
                binding . button . setOnClickListener {
            val title = binding.titleInput.text.toString()
            val content = binding.contentInput.toString()

    }
    private fun saveNote(title: String, content: String) {
        val note = Notes(id = 0, title, content)
        database.noteDao().addNotes(note)
        noteAdapter.notifyDataSetChanged()
    }
private val listener = object: NoteAdapter.OnNoteItemClickListener{
    override fun onClick(note: ContactsContract.CommonDataKinds.Note) {
        val intent = Intent(this@MainActivity, NoteDetailsActivity::class.java)
        intent.run {
            putExtra("id", note.id)
            startActivity(this)
        }
    }

}
}

private operator fun <E> List<E>.invoke(value: Any): Any {

}

class NoteDetailsActivity {

}
