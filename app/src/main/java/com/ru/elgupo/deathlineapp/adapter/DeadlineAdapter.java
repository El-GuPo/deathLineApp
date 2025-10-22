package com.ru.elgupo.deathlineapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.elgupo.deathlineapp.R;
import com.ru.elgupo.deathlineapp.model.Deadline;
import com.ru.elgupo.deathlineapp.model.DeadlineDto;

import java.util.List;

public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.DeadlineViewHolder> {

    private List<DeadlineDto> deadlines;
    private OnDeadlineDeleteListener deleteListener;

    public DeadlineAdapter(List<DeadlineDto> deadlines, OnDeadlineDeleteListener deleteListener) {
        this.deadlines = deadlines;
        this.deleteListener = deleteListener;
    }

    public interface OnDeadlineDeleteListener {
        void onDeadlineDelete(int position);
    }

    @NonNull
    @Override
    public DeadlineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_deadline, parent, false);
        return new DeadlineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeadlineViewHolder holder, int position) {
        Deadline deadline = deadlines.get(position);
        holder.titleTextView.setText(deadline.getTitle());
        holder.dateTextView.setText(deadline.getDate());
        holder.descriptionTextView.setText(deadline.getDescription());

        holder.deleteButton.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onDeadlineDelete(position);
            }
        });
    }

    public void updateDeadlines(List<DeadlineDto> newDeadlines) {
        this.deadlines = newDeadlines;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return deadlines.size();
    }

    public static class DeadlineViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView dateTextView;
        TextView descriptionTextView;
        Button deleteButton;

        public DeadlineViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_textview);
            dateTextView = itemView.findViewById(R.id.date_textview);
            descriptionTextView = itemView.findViewById(R.id.description_textview);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}
