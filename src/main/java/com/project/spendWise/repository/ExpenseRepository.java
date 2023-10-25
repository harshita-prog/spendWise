package com.project.spendWise.repository;

import com.project.spendWise.entity.Expense;
import com.project.spendWise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}
