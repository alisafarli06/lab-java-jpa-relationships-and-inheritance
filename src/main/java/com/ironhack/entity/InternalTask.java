package com.ironhack.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("internal")
public class InternalTask extends Task {
    public InternalTask() {}

    public InternalTask(String title, java.time.LocalDate dueDate, Boolean completed) {
        super(title, dueDate, completed);
    }
}
