package com.ironhack.dataloader;

import com.ironhack.entity.Association;
import com.ironhack.entity.Division;
import com.ironhack.entity.Member;
import com.ironhack.entity.MemberStatus;
import com.ironhack.repository.AssociationRepository;
import com.ironhack.repository.DivisionRepository;
import com.ironhack.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AssociationDataInitializer {

    private final AssociationRepository associationRepository;
    private final DivisionRepository divisionRepository;
    private final MemberRepository memberRepository;

    public AssociationDataInitializer(AssociationRepository associationRepository,
                                      DivisionRepository divisionRepository,
                                      MemberRepository memberRepository) {
        this.associationRepository = associationRepository;
        this.divisionRepository = divisionRepository;
        this.memberRepository = memberRepository;
    }

    public void initialize() {
        if (associationRepository.count() > 0) {
            return;
        }

        Association association = new Association("Nurse Association of Spain");
        associationRepository.save(association);

        for (int i = 1; i <= 3; i++) {
            Division division = new Division();
            division.setName("Division " + i);
            division.setDistrict("District " + i);
            division.setAssociation(association);
            divisionRepository.save(division);

            Member member = new Member();
            member.setName("President " + i);
            member.setStatus(MemberStatus.ACTIVE);
            member.setRenewalDate(LocalDate.now().plusMonths(6));
            member.setDivision(division);
            memberRepository.save(member);

            division.setPresident(member);
            divisionRepository.save(division);
        }
    }
}