package com.ironhack.dataloader;

import com.ironhack.entity.Conference;
import com.ironhack.entity.Exhibition;
import com.ironhack.entity.Guest;
import com.ironhack.entity.Speaker;
import com.ironhack.entity.GuestStatus;
import com.ironhack.repository.ConferenceRepository;
import com.ironhack.repository.ExhibitionRepository;
import com.ironhack.repository.GuestRepository;
import com.ironhack.repository.SpeakerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EventDataInitializer {

    private final ConferenceRepository conferenceRepository;
    private final ExhibitionRepository exhibitionRepository;
    private final GuestRepository guestRepository;
    private final SpeakerRepository speakerRepository;

    public EventDataInitializer(ConferenceRepository conferenceRepository,
                                ExhibitionRepository exhibitionRepository,
                                GuestRepository guestRepository,
                                SpeakerRepository speakerRepository) {
        this.conferenceRepository = conferenceRepository;
        this.exhibitionRepository = exhibitionRepository;
        this.guestRepository = guestRepository;
        this.speakerRepository = speakerRepository;
    }

    public void initialize() {
        if (conferenceRepository.count() > 0 || exhibitionRepository.count() > 0) {
            return;
        }

        Speaker speaker1 = new Speaker("Sarah Lee", 45);
        Speaker speaker2 = new Speaker("James Patel", 30);

        speakerRepository.save(speaker1);
        speakerRepository.save(speaker2);

        List<Speaker> speakers = new ArrayList<>();
        speakers.add(speaker1);
        speakers.add(speaker2);

        Conference conference = new Conference("Spring Summit", "Madrid", speakers);
        conference.setDate(LocalDate.now().plusWeeks(2));
        conference.setDuration(240);
        conferenceRepository.save(conference);

        Exhibition exhibition = new Exhibition("Medical Expo", "Barcelona");
        exhibition.setDate(LocalDate.now().plusWeeks(4));
        exhibition.setDuration(300);
        exhibitionRepository.save(exhibition);

        guestRepository.save(new Guest("Ana Torres", GuestStatus.ATTENDING, conference));
        guestRepository.save(new Guest("Miguel Santos", GuestStatus.NO_RESPONSE, exhibition));
    }
}