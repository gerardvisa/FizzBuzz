package com.minigames.fizzbuzz.representation;

import java.util.ArrayList;
import java.util.List;

public final class Fizzbuzz extends Game {
    private int startingNumber;
    private int targetNumber;
    private List<String> resultingGame = new ArrayList<>();

    public Fizzbuzz(int startingNumber, int targetNumber) {
        this.startingNumber = startingNumber;
        this.targetNumber = targetNumber;
    }

    public int getStartingNumber() {
        return startingNumber;
    }

    public void setStartingNumber(int startingNumber) {
        this.startingNumber = startingNumber;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public List<String> getResultingGame() {
        return resultingGame;
    }

    public void setResultingGame(List<String> resultingGame) {
        this.resultingGame = resultingGame;
    }
}
