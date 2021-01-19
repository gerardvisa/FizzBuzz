package com.minigames.fizzbuzz.service;

import com.minigames.fizzbuzz.exception.StartNumGreaterThanTargetException;
import com.minigames.fizzbuzz.exception.StartNumTooSmallException;
import com.minigames.fizzbuzz.representation.Fizzbuzz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FizzbuzzService {
    Logger logger = LoggerFactory.getLogger(FizzbuzzService.class);

    public Fizzbuzz solveGame(Fizzbuzz game) throws StartNumGreaterThanTargetException, StartNumTooSmallException {
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

    private void validateInputParameters(int startingNumber, int targetNumber) throws StartNumGreaterThanTargetException, StartNumTooSmallException {
        if (startingNumber < 1) {
            throw new StartNumTooSmallException("Invalid starting number: too small");
        }
        if (startingNumber > targetNumber) {
            throw new StartNumGreaterThanTargetException("Invalid starting number: greater than the maximum allowed (" + targetNumber + ")");
        }
        logger.info("Game input parameters (" + startingNumber + ", " + targetNumber + ") are correct, ready to begin");
    }
}
