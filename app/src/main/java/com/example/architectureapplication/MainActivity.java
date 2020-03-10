package com.example.architectureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;

    @BindView(R.id.rv_notes)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final NoteAdapter adapter = new NoteAdapter((note, position) -> {
            Toast.makeText(this, note.getTitle(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);

        noteViewModel = ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication()).create(NoteViewModel.class);

        noteViewModel.getAllNotes().observe(this, notes -> {
            //Update recycler view
            Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();

            adapter.setNotes(notes);
        });
    }

    @OnClick(R.id.btn_add_notes)
    public void addNote() {
        Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
        startActivity(intent);
    }

}
