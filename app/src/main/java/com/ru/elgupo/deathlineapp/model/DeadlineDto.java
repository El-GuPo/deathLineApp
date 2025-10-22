package com.ru.elgupo.deathlineapp.model;

public class DeadlineDto extends Deadline{
    private final Long id;

    public DeadlineDto(Long id, String title, String date, String description) {
        super(title, date, description);
        this.id = id;
    }
    public DeadlineDto(Long id, Deadline deadline) {
        super(deadline.getDate(), deadline.getDate(), deadline.getDescription());
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
