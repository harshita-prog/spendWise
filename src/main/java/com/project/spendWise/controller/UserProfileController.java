package com.project.spendWise.controller;

import com.project.spendWise.entity.User;
import com.project.spendWise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String profile(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/update-salary")
    public String updateSalary(@RequestParam("totalSalary") double totalSalary, Principal principal) {
        String username = principal.getName();
        User user = userService.findUserByUsername(username);
        user.setTotalSalary(totalSalary);
        userService.saveUser(user);
        return "redirect:/profile";
    }
}

