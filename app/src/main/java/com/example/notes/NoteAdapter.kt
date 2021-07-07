package com.example.notes

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.NoteItemBinding
import com.example.notes.models.Notes

class NoteAdapter (private val notes: List <Notes>, clicker: (Notes) ->Unit, ): RecyclerView.Adapter<NoteAdapter.NoteViewHolder> (){
   inner class NoteViewHolder (private val binding: NoteItemBinding,private val listener: OnNoteItemClickListener) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Notes) {
            binding.apply {
                binding.iddisplay.text = note.id.toString()
                binding.titlename.text = note.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        var binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context))
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }
    interface OnNoteItemClickListener{
        fun onClick(note: ContactsContract.CommonDataKinds.Note)
    }
}
