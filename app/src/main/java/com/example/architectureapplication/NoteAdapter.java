package com.example.architectureapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notes = new ArrayList<>();
    private OnItemClicked mListener;

    public NoteAdapter(OnItemClicked listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_priority)
        TextView priority;
        @BindView(R.id.tv_description)
        TextView description;

        private OnItemClicked mListener;

        NoteViewHolder(@NonNull View itemView, OnItemClicked listener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mListener = listener;
        }

        void bind(Note note){
            title.setText(note.getTitle());
            priority.setText(String.valueOf(note.getPriority()));
            description.setText(note.getDescription());

            itemView.setOnClickListener(view -> mListener.onClick(note,getAdapterPosition()));
        }
    }

    interface OnItemClicked{
        void onClick(Note note, int position);
    }
}
