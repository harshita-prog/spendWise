package com.project.spendWise.controller;

import com.project.spendWise.entity.Expense;
import com.project.spendWise.entity.User;
import com.project.spendWise.service.ExpenseService;
import com.project.spendWise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private UserService userService;
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String expenses(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        List<Expense> expenses = expenseService.getExpensesByUser(user);
        model.addAttribute("user", user);
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @PostMapping("/add-expense")
    public String addExpense(@RequestParam("amount") double amount, @RequestParam("description") String description, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);

        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setUser(user);

        expenseService.saveExpense(expense);

        return "redirect:/expenses";
    }
}

