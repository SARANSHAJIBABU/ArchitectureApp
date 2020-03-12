package com.example.architectureapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapterKt(val listener:OnItemClicked): RecyclerView.Adapter<NoteAdapterKt.NoteViewHolder>() {

    var notes = mutableListOf<Note>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view,listener)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    inner class NoteViewHolder(itemView: View, val listener:OnItemClicked):
            RecyclerView.ViewHolder(itemView){

        val title by lazy {
            itemView.findViewById<TextView>(R.id.tv_title)
        }
        val priority by lazy {
            itemView.findViewById<TextView>(R.id.tv_priority)
        }
        val description by lazy {
            itemView.findViewById<TextView>(R.id.tv_description)
        }

        fun bind(note: Note){
            title.text = note.title
            priority.text = note.priority.toString()
            description.text = note.description

            itemView.setOnClickListener {
                listener.onClick(note, adapterPosition)
            }
        }
    }

    interface OnItemClicked{
        fun onClick(note:Note, position:Int)
    }

}
