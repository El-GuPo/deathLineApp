package com.ru.elgupo.deathlineapp.viewModels;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

import com.ru.elgupo.deathlineapp.MainActivity;
import com.ru.elgupo.deathlineapp.model.Deadline;
import com.ru.elgupo.deathlineapp.model.DeadlineDto;
import com.ru.elgupo.deathlineapp.repository.DeadlineRepositoryImpl;
import com.ru.elgupo.deathlineapp.repository.DeadlinesRepository;

import java.util.ArrayList;
import java.util.List;

public class CalendarViewModel extends ViewModel {

    private MainActivity activity;
    private List<DeadlineDto> deadlines = new ArrayList<>();
    private final DeadlinesRepository deadlinesRepository = new DeadlineRepositoryImpl();

    public CalendarViewModel() {
    }

    public List<DeadlineDto> getDeadlines(MainActivity activity) {
        loadDeadlines(activity);
        return deadlines;
    }

    private void loadDeadlines(MainActivity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("AppPrefs", MODE_PRIVATE);
        Long id = prefs.getLong("userId", -1);
        deadlines = deadlinesRepository.getDeadlines(id, null, null);
    }

    public Long addDeadline(Deadline deadline, MainActivity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("AppPrefs", MODE_PRIVATE);
        Long id = prefs.getLong("userId", -1);
        return deadlinesRepository.createDeadline(id, new DeadlineDto(null, deadline));
    }


    public void removeDeadline(int position) {
        if (position >= 0 && position < deadlines.size()) {
            deadlinesRepository.deleteDeadline(deadlines.get(position).getId());
            deadlines.remove(position);
        }
    }
}
