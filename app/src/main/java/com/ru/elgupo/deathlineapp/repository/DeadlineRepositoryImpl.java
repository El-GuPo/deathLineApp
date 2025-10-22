package com.ru.elgupo.deathlineapp.repository;

import com.ru.elgupo.deathlineapp.model.Deadline;
import com.ru.elgupo.deathlineapp.model.DeadlineDto;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class DeadlineRepositoryImpl implements DeadlinesRepository{
    @Override
    public List<DeadlineDto> getDeadlines(Long userId, Instant from, Instant to) {
        return Collections.emptyList();
    }

    @Override
    public Long createDeadline(Long userId, DeadlineDto deadlineDto) {
            return 1L;
    }

    @Override
    public void deleteDeadline(Long deadlineId) {

    }

    @Override
    public void updateDeadline(DeadlineDto deadlineDto) {

    }
}
