package com.ru.elgupo.deathlineapp.repository;

import com.ru.elgupo.deathlineapp.model.Deadline;
import com.ru.elgupo.deathlineapp.model.DeadlineDto;

import java.time.Instant;
import java.util.List;

public interface DeadlinesRepository {

    List<DeadlineDto> getDeadlines(Long userId, Instant from, Instant to);

    Long createDeadline(Long userId, DeadlineDto deadlineDto);

    void deleteDeadline(Long deadlineId);

    void updateDeadline(DeadlineDto deadlineDto);

}
