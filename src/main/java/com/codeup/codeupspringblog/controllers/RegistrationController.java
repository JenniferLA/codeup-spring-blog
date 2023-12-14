package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// should fetch to see if email already exists in the db bc it's better for user experience

@Controller
public class RegistrationController {
    @GetMapping("/signup")
    public String showSignupForm() {
        // since there is no @ResponseBody thymeleaf will look for view
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(
            @RequestParam(name="email") String email,
            Model model) {
        model.addAttribute("email", email);
        // after submitting the signup page, go back to the signup page and display the email address used in signing up
        return "signup";
    }


}
