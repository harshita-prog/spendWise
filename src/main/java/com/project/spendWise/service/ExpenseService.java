package com.project.spendWise.service;

import com.project.spendWise.entity.Expense;
import com.project.spendWise.entity.User;
import com.project.spendWise.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}
