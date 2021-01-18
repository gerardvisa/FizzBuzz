package com.minigames.fizzbuzz.controller;

import com.minigames.fizzbuzz.functional.FizzbuzzProcessor;
import com.minigames.fizzbuzz.representation.Fizzbuzz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FizzbuzzController {
    Logger logger = LoggerFactory.getLogger(FizzbuzzController.class);

    @Value("${fizzbuzz.targetNumber:4000}")
    private int targetNumber;

    @GetMapping("/fizzbuzz")
    public Fizzbuzz getFizzBuzzCompletedGame(@RequestParam(value = "starting_number") int startingNumber) {
        Fizzbuzz game = new Fizzbuzz(startingNumber, targetNumber);
        try {
            FizzbuzzProcessor.solveGame(game);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid starting_number parameter value", e);
        }
        return game;
    }
}
