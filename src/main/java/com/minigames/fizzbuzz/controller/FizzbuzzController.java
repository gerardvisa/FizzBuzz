package com.minigames.fizzbuzz.controller;

import com.minigames.fizzbuzz.functional.FizzbuzzProcessor;
import com.minigames.fizzbuzz.representation.Fizzbuzz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class FizzbuzzController {
    @Value("${fizzbuzz.targetNumber:4000}")
    private int targetNumber;

    @GetMapping("/fizzbuzz")
    public Fizzbuzz getFizzBuzzCompletedGame(@RequestParam(value = "starting_number") int startingNumber) {
        Fizzbuzz game = new Fizzbuzz(startingNumber, targetNumber);
        FizzbuzzProcessor.solveGame(game);
        //validateInputParameters
        //solveGame
        return game;
    }
}
