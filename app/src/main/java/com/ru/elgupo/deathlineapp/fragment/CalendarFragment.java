package com.ru.elgupo.deathlineapp.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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

public class CalendarFragment extends Fragment implements DeadlineAdapter.OnDeadlineDeleteListener {

    private static final String CALENDAR_FRAGMENT_TAG = "Calendar_Fragment";

    private RecyclerView recyclerView;
    private DeadlineAdapter adapter;
    private CalendarViewModel viewModel;
    private Button btnAddDeadline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        viewModel = new ViewModelProvider(this).get(CalendarViewModel.class);

        initRecyclerView(view);
        btnAddDeadline = view.findViewById(R.id.btn_add_deadline);
        List<Deadline> deadlines = viewModel.getDeadlines();
        adapter.updateDeadlines(deadlines);

        btnAddDeadline.setOnClickListener(v -> showAddDeadlineDialog());

        return view;
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new DeadlineAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);
    }

    private void showAddDeadlineDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Новый дедлайн");

        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 20, 50, 20);

        final EditText inputTitle = new EditText(getContext());
        inputTitle.setHint("Название");
        layout.addView(inputTitle);

        final EditText inputDate = new EditText(getContext());
        inputDate.setHint("Дата (дд.мм.гггг)");
        layout.addView(inputDate);

        final EditText inputDescription = new EditText(getContext());
        inputDescription.setHint("Описание");
        layout.addView(inputDescription);

        builder.setView(layout);

        builder.setPositiveButton("Добавить", (dialog, which) -> {
            String title = inputTitle.getText().toString().trim();
            String date = inputDate.getText().toString().trim();
            String description = inputDescription.getText().toString().trim();

            if (!title.isEmpty() && !date.isEmpty()) {
                Deadline newDeadline = new Deadline(title, date, description);
                viewModel.addDeadline(newDeadline);

                adapter.updateDeadlines(viewModel.getDeadlines());
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    @Override
    public void onDeadlineDelete(int position) {
        viewModel.removeDeadline(position);
        adapter.updateDeadlines(viewModel.getDeadlines());
    }
}