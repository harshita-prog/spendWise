package com.project.spendWise.repository;

import com.project.spendWise.entity.Savings;
import com.project.spendWise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
    List<Savings> findByUser(User user);
}
