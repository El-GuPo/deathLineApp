package com.ru.elgupo.deathlineapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ru.elgupo.deathlineapp.R;
import com.ru.elgupo.deathlineapp.adapter.DeadlineAdapter;
import com.ru.elgupo.deathlineapp.model.Deadline;
import com.ru.elgupo.deathlineapp.viewModels.CalendarViewModel;

import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment {

    private static final String CALENDAR_FRAGMENT_TAG = "Calendar_Fragment";

    private RecyclerView recyclerView;
    private DeadlineAdapter adapter;
    private CalendarViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        viewModel = new ViewModelProvider(this).get(CalendarViewModel.class);

        initRecyclerView(view);
        List<Deadline> deadlines = viewModel.getDeadlines();
        adapter.updateDeadlines(deadlines);

        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new DeadlineAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }


}