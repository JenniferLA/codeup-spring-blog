package com.codeup.codeupspringblog.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DiceGame {
    private long id;
    private int diceRoll;
    private int userGuess;
    private String message;

    public DiceGame(int userGuess) {
        this.diceRoll = (int)(Math.random() * 6) + 1;
        this.userGuess = userGuess;
        this.message = (diceRoll == userGuess) ? "Congratulations! You guess the correct number." : "Not the correct number. Try again!";
    }
}
