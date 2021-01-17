package com.minigames.fizzbuzz.controller;

import com.minigames.fizzbuzz.functional.GameProcessor;
import com.minigames.fizzbuzz.representation.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    Logger logger = LoggerFactory.getLogger(GameController.class);

    @Value("${fizzbuzz.targetNumber:4000}")
    private int targetNumber;

    @GetMapping("/game")
    public Game getFizzBuzzCompletedGame(@RequestParam(value = "starting_number") int startingNumber) {
        logger.debug("GameController values: targetNumber = " + targetNumber + ", startingNumber = " + startingNumber);
        long startTime = System.currentTimeMillis();
        Game completeGame = new GameProcessor().solveGame(startingNumber, targetNumber);
        logger.trace("getFizzBuzzCompletedGame request completed in " + (System.currentTimeMillis() - startTime) + "ms");
        return completeGame;
    }
}
