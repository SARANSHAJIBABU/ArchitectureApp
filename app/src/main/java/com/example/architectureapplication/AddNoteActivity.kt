package com.example.architectureapplication


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_note.*
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDesc: EditText
    private lateinit var numberPicker: NumberPicker

    @Inject
    lateinit var viewModel: AddNoteViewModel

    companion object{
        val SELECTED_NOTE = "selected_note"

        fun getIntent(context: Context, note:Note?=null): Intent{
            val intent = Intent(context,AddNoteActivity::class.java)

            return if(note==null)
                intent
            else
                intent.apply {
                            putExtra(SELECTED_NOTE,note)
                        }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NoteApp).run {
            appComponent.addNoteComponent().build().inject(this@AddNoteActivity)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        setupViews()

        setupAppBar()
    }

    private fun setupViews() {
        editTextTitle = et_title
        editTextDesc = et_desc
        numberPicker = np_picker

        numberPicker.apply {
            maxValue = 10
            minValue = 1
        }

        if(intent.hasExtra(SELECTED_NOTE)){
            val note: Note = intent.getParcelableExtra(SELECTED_NOTE)
            editTextTitle.setText(note.title)
            editTextDesc.setText(note.description)
            numberPicker.value = note.priority
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.save_note -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
        val title = editTextTitle.text.toString()
        val description = editTextDesc.text.toString()
        val priority = numberPicker.value

        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
        } else {
            val note = Note(title, description, priority)

            if(intent.hasExtra(SELECTED_NOTE)){
                note.id = (intent.getParcelableExtra(SELECTED_NOTE) as Note).id
                viewModel.update(note)
            }else{
                viewModel.insert(note)
            }

            finish()
        }
    }


    private fun setupAppBar() {
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
        title = "Add Note"
        if(intent.hasExtra(SELECTED_NOTE)){
            title = "Edit Note"
        }
    }

}
