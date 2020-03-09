package com.example.architectureapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.architectureapplication.EXTRA_TITLE";
    public static final String EXTRA_DESC = "com.example.architectureapplication.EXTRA_DESC";
    public static final String EXTRA_PRIORITY = "com.example.architectureapplication.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDesc;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextDesc = findViewById(R.id.et_desc);
        editTextTitle = findViewById(R.id.et_title);
        numberPicker = findViewById(R.id.np_picker);

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(1);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Add note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDesc.getText().toString();
        int priority = numberPicker.getValue();

        if(title.isEmpty() || description.isEmpty()){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_TITLE,title);
            intent.putExtra(EXTRA_DESC,description);
            intent.putExtra(EXTRA_PRIORITY,priority);

            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
