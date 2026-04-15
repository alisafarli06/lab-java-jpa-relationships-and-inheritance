package com.ironhack.dataloader;

import com.ironhack.entity.BillableTask;
import com.ironhack.entity.InternalTask;
import com.ironhack.repository.BillableTaskRepository;
import com.ironhack.repository.InternalTaskRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TaskDataInitializer {

    private final BillableTaskRepository billableTaskRepository;
    private final InternalTaskRepository internalTaskRepository;

    public TaskDataInitializer(BillableTaskRepository billableTaskRepository,
                               InternalTaskRepository internalTaskRepository) {
        this.billableTaskRepository = billableTaskRepository;
        this.internalTaskRepository = internalTaskRepository;
    }

    public void initialize() {
        if (billableTaskRepository.count() > 0 || internalTaskRepository.count() > 0) {
            return;
        }

        billableTaskRepository.save(
                new BillableTask("Client onboarding",
                        LocalDate.now().plusDays(7),
                        false,
                        new BigDecimal("95.00"))
        );

        internalTaskRepository.save(
                new InternalTask("Team meeting",
                        LocalDate.now().plusDays(5),
                        false)
        );
    }
}