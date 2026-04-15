package com.ironhack.repository;

import com.ironhack.entity.InternalTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalTaskRepository extends JpaRepository<InternalTask, Long> {
}
