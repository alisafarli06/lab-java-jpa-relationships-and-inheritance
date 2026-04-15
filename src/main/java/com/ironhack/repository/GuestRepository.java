package com.ironhack.repository;

import com.ironhack.entity.Guest;
import com.ironhack.entity.GuestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository  extends JpaRepository<Guest,Long> {

    List<Guest> findByStatus(GuestStatus status);


}
