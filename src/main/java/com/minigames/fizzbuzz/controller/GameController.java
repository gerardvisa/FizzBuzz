package com.minigames.fizzbuzz.controller;

import com.minigames.fizzbuzz.functional.GameProcessor;
import com.minigames.fizzbuzz.representation.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @GetMapping("/game")
    public Game getFizzBuzzCompletedGame(@RequestParam(value = "starting_number") int startingNumber) {
        Game completeGame = new GameProcessor().solveGame(startingNumber);
        return completeGame;
    }
}
