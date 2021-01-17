package com.minigames.fizzbuzz.functional;

import com.minigames.fizzbuzz.representation.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class GameProcessor {

    Logger logger = LoggerFactory.getLogger(GameProcessor.class);

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
        //FizzBuzz rules say 1 is the minimum number to start with
        if (startingNumber < 1) {
            //an exception will be thrown
            System.err.println("Invalid starting number: too small");
        }
        //It also wouldn't make sense if the starting number is greater than the targetNumber
        if (startingNumber > targetNumber) {
            //an exception will be thrown
            System.err.println("Invalid starting number: greater than the maximum allowed (" + targetNumber + ")");
        }
        logger.info("Game input parameters (" + startingNumber + ", " + targetNumber + ") are correct, ready to begin");
    }
}
