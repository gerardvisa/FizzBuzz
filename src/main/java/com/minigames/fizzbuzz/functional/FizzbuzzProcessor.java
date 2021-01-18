package com.minigames.fizzbuzz.functional;

import com.minigames.fizzbuzz.exception.StartNumGreaterThanTargetException;
import com.minigames.fizzbuzz.exception.StartNumTooSmallException;
import com.minigames.fizzbuzz.representation.Fizzbuzz;

import java.util.Date;

public class FizzbuzzProcessor {
    public static Fizzbuzz solveGame(Fizzbuzz game) throws StartNumGreaterThanTargetException, StartNumTooSmallException {
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

    private static void validateInputParameters(int startingNumber, int targetNumber) throws StartNumGreaterThanTargetException, StartNumTooSmallException {
        if (startingNumber < 1) {
            throw new StartNumTooSmallException("Invalid starting number: too small");
        }
        if (startingNumber > targetNumber) {
            throw new StartNumGreaterThanTargetException("Invalid starting number: greater than the maximum allowed (" + targetNumber + ")");
        }
    }
}
