package com.ru.elgupo.deathlineapp.viewModels;

import androidx.lifecycle.ViewModel;

import com.ru.elgupo.deathlineapp.model.Deadline;

import java.util.ArrayList;
import java.util.List;

public class CalendarViewModel extends ViewModel {

    private final List<Deadline> deadlines = new ArrayList<>();

    public CalendarViewModel() {
        loadDeadlines();
    }

    public List<Deadline> getDeadlines() {
        return deadlines;
    }

    private void loadDeadlines() {
        // TODO: load actual deadlines

        deadlines.add(new Deadline(
                "Сдать проект по Android",
                "15.12.2024",
                "Завершить разработку приложения с дедлайнами"
        ));

        deadlines.add(new Deadline(
                "Подготовить презентацию",
                "20.12.2024",
                "Сделать слайды для защиты проекта"
        ));

        deadlines.add(new Deadline(
                "Сдать курсовую работу",
                "25.12.2024",
                "Написать и оформить курсовую по базам данных"
        ));

        deadlines.add(new Deadline(
                "Подготовиться к экзамену",
                "30.12.2024",
                "Повторить материалы за семестр"
        ));

        deadlines.add(new Deadline(
                "Заказать пиццу",
                "10.12.2024",
                "Не забыть про встречу с друзьями"
        ));
    }

    public void addDeadline(Deadline deadline) {
        //TODO: repo method
        deadlines.add(deadline);
    }

    public void removeDeadline(int position) {
        //TODO: repo method
        if (position >= 0 && position < deadlines.size()) {
            deadlines.remove(position);
        }
    }

    public void updateDeadline(int position, Deadline deadline) {
        // TODO: repo method
        if (position >= 0 && position < deadlines.size()) {
            deadlines.set(position, deadline);
        }
    }
}
