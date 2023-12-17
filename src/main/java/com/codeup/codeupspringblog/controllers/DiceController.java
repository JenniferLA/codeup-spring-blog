package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Create a page at /roll-dice that asks the user to guess a number.
// There should be links on this page for 1 through 6 that make a GET request to /roll-dice/n.
// n is the number guessed.
// This page should display a random number (the dice roll), the user's guess, and a message based on whether they guessed the correct number.
@Controller
//@RequestMapping("/roll-dice")
public class DiceController {
    private Random rnd = new Random();

    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "diceroll";
    }

    @GetMapping("/roll-dice/{n}")
    public String showRollDice(@PathVariable int n, Model model) {
        List<String> messages = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String message = rollDiceWithGuess(n);
            messages.add(message);
        }
        model.addAttribute("messages", messages);
        return "diceroll";
    }

    private String rollDiceWithGuess(int n){
        int roll = rnd.nextInt(6); //returns a num from 0 to 5
        roll++; //shifts it to a num from 1 to 6
        // putting logic for checking the user's guess here bc not using Thymeleaf in this exercise
        String message = String.format("You guessed %d. The roll is %d.", n, roll);
        if(n == roll) {
            message += "You guess correctly!";
        } else {
            message += "Womp, womp, try again!";
        }

        return message;
    }

}
