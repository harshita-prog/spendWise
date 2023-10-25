package com.project.spendWise.service;

import com.project.spendWise.entity.Savings;
import com.project.spendWise.entity.User;
import com.project.spendWise.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

    public SavingsService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    public List<Savings> getSavingsByUser(User user) {
        return savingsRepository.findByUser(user);
    }

    public Savings saveSavings(Savings savings) {
        return savingsRepository.save(savings);
    }
}