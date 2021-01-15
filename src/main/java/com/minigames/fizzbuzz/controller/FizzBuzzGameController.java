package com.minigames.fizzbuzz.controller;

import com.minigames.fizzbuzz.representation.FizzBuzzGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzGameController {

    @GetMapping("/game")
    public FizzBuzzGame getFizzBuzzCompletedGame(@RequestParam(value = "starting_number") int startingNumber) {
        FizzBuzzGame fizzBuzzGame = new FizzBuzzGame(startingNumber);
        return fizzBuzzGame;
    }
}
