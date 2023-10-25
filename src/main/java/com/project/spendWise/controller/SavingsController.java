package com.project.spendWise.controller;

import com.project.spendWise.entity.Savings;
import com.project.spendWise.entity.User;
import com.project.spendWise.service.SavingsService;
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
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    private UserService userService;
    @Autowired
    private SavingsService savingsService;

    @GetMapping
    public String viewSavings(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);

        // Retrieve the user's savings
        List<Savings> savingsList = savingsService.getSavingsByUser(user);

        // Calculate total savings
        double totalSavings = calculateTotalSavings(savingsList);

        model.addAttribute("user", user);
        model.addAttribute("savingsList", savingsList);
        model.addAttribute("totalSavings", totalSavings);

        return "savings";
    }

    @PostMapping("/add-savings")
    public String addSavings(
            @RequestParam("amount") double amount,
            Principal principal
    ) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);

        // Create a new savings entry
        Savings savings = new Savings();
        savings.setAmount(amount);
        savings.setUser(user);
        savingsService.saveSavings(savings);

        return "redirect:/savings";
    }

    private double calculateTotalSavings(List<Savings> savingsList) {
        return savingsList.stream()
                .mapToDouble(Savings::getAmount)
                .sum();
    }
}
