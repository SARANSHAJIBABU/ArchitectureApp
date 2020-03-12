package com.example.architectureapplication


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_note.*
import javax.inject.Inject

class AddNoteActivityKt : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDesc: EditText
    private lateinit var numberPicker: NumberPicker

    @Inject
    lateinit var viewModel: AddNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NoteApp).run {
            appComponent.addNoteComponent().build().inject(this@AddNoteActivityKt)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        editTextTitle = et_title
        editTextDesc = et_desc
        numberPicker = np_picker

        numberPicker.apply {
            maxValue = 10
            minValue = 1
        }

        setupAppBar()
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
            viewModel.insert(note)
            finish()
        }
    }


    private fun setupAppBar() {
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
        title = "Add Note"
    }

}
