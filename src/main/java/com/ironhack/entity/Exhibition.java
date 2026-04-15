package com.ironhack.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("exhibition")
public class Exhibition extends Event {

    public Exhibition() {}

    public Exhibition(String title, String location) {
        super(title, location);
    }




}
