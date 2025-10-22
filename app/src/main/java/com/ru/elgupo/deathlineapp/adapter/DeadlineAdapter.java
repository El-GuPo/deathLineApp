package com.ru.elgupo.deathlineapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.elgupo.deathlineapp.R;
import com.ru.elgupo.deathlineapp.model.Deadline;

import java.util.List;

public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.DeadlineViewHolder> {

    private List<Deadline> deadlines;

    public DeadlineAdapter(List<Deadline> deadlines) {
        this.deadlines = deadlines;
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
    }

    public void updateDeadlines(List<Deadline> newDeadlines) {
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

        public DeadlineViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_textview);
            dateTextView = itemView.findViewById(R.id.date_textview);
            descriptionTextView = itemView.findViewById(R.id.description_textview);
        }
    }
}
