package com.minigames.fizzbuzz.functional;

import com.minigames.fizzbuzz.representation.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

@PropertySource("application.properties")
public class GameProcessor {
    @Value("${fizzbuzz.targetNumber}")
    private int targetNumber;

    public Game solveGame (int startingNumber) {
        meetingRequirements(startingNumber);
        Game game = new Game();
        for (int currentNum = startingNumber; currentNum < targetNumber; currentNum++) {
            String currentStr = "";
            if (currentNum % 3 == 0) currentStr += "fizz";
            if (currentNum % 5 == 0) currentStr += "buzz";
            if (currentStr.isEmpty()) currentStr = String.valueOf(currentNum);
            game.getResultingGame().add(currentStr);
        }
        game.setCompletionDate(new Date());
        return game;
    }

    private void meetingRequirements(int startingNumber) {
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
