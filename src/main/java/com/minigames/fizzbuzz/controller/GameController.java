package com.minigames.fizzbuzz.controller;

import com.minigames.fizzbuzz.functional.GameProcessor;
import com.minigames.fizzbuzz.representation.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Value("${fizzbuzz.targetNumber:4000}")
    private int targetNumber;

    @GetMapping("/game")
    public Game getFizzBuzzCompletedGame(@RequestParam(value = "starting_number") int startingNumber) {
        Game completeGame = new GameProcessor().solveGame(startingNumber, targetNumber);
        return completeGame;
    }
}
