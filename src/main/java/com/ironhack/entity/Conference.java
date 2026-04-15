package com.ironhack.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("conference")
public class Conference extends Event {

    @ManyToMany
    @JoinTable(name = "conference_speakers",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers =new ArrayList<>();

    public Conference() {}



    public Conference(String title, String location, List<Speaker> speakers) {
        super(title, location);
        this.speakers = speakers;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }



    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
