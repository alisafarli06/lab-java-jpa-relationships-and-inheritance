package com.ironhack.dataloader;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderRunner {

    private final ContactDataInitializer contactDataInitializer;
    private final AssociationDataInitializer associationDataInitializer;
    private final EventDataInitializer eventDataInitializer;
    private final TaskDataInitializer taskDataInitializer;

    public DataLoaderRunner(ContactDataInitializer contactDataInitializer,
                            AssociationDataInitializer associationDataInitializer,
                            EventDataInitializer eventDataInitializer,
                            TaskDataInitializer taskDataInitializer) {
        this.contactDataInitializer = contactDataInitializer;
        this.associationDataInitializer = associationDataInitializer;
        this.eventDataInitializer = eventDataInitializer;
        this.taskDataInitializer = taskDataInitializer;
    }

    @PostConstruct
    public void run() {
        contactDataInitializer.initialize();
        associationDataInitializer.initialize();
        eventDataInitializer.initialize();
        taskDataInitializer.initialize();
    }
}