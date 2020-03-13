package com.example.architectureapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var noteViewModel: NotesViewModel

    val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_notes)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NoteApp).run {
            appComponent.mainComponent().build().inject(this@MainActivity)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteAdapter = NoteAdapter(object: NoteAdapter.OnItemClicked{
            override fun onClick(note: Note, position: Int) {
                Toast.makeText(this@MainActivity, note.title, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }

        noteViewModel.getAllNotes().observe(this, Observer {
            Toast.makeText(this, "onChanged", Toast.LENGTH_SHORT).show()
            noteAdapter.notes = it.toMutableList()
        })

        btn_add_notes.setOnClickListener {
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }

        ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = false
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewModel.delete(noteAdapter.getNoteAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(recyclerView)
    }

}
