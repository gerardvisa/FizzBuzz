package com.minigames.fizzbuzz.functional;

import com.minigames.fizzbuzz.representation.Fizzbuzz;

import java.util.Date;

public class FizzbuzzProcessor {
    public static Fizzbuzz solveGame(Fizzbuzz game) {
        validateInputParameters(game.getStartingNumber(), game.getTargetNumber());
        for (int currentNum = game.getStartingNumber(); currentNum <= game.getTargetNumber(); currentNum++) {
            String currentStr = "";
            if (currentNum % 3 == 0) currentStr += "fizz";
            if (currentNum % 5 == 0) currentStr += "buzz";
            if (currentStr.isEmpty()) currentStr = String.valueOf(currentNum);
            game.getResultingGame().add(currentStr);
        }
        game.setCompletionDate(new Date());
        return game;
    }

    private static void validateInputParameters(int startingNumber, int targetNumber) {
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
