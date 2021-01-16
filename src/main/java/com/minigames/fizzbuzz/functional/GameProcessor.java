package com.minigames.fizzbuzz.functional;

import com.minigames.fizzbuzz.representation.Game;

import java.util.Date;

public class GameProcessor {
    public Game solveGame (int startingNumber, int targetNumber) {
        meetingRequirements(startingNumber, targetNumber);
        Game game = new Game();
        for (int currentNum = startingNumber; currentNum <= targetNumber; currentNum++) {
            String currentStr = "";
            if (currentNum % 3 == 0) currentStr += "fizz";
            if (currentNum % 5 == 0) currentStr += "buzz";
            if (currentStr.isEmpty()) currentStr = String.valueOf(currentNum);
            game.getResultingGame().add(currentStr);
        }
        game.setCompletionDate(new Date());
        return game;
    }

    private void meetingRequirements(int startingNumber, int targetNumber) {
        if (startingNumber < 1) {
            //an exception will be thrown
            System.err.println("Invalid starting number: too small");
        }
        if (startingNumber > targetNumber) {
            //an exception will be thrown
            System.err.println("Invalid starting number: greater than the maximum allowed (" + targetNumber + ")");
        }
    }
}
