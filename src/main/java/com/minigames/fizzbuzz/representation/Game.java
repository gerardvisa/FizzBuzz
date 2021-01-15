package com.minigames.fizzbuzz.representation;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    private int id;
    private int startingNumber;
    public static int targetNumber;
    private Date completionDate;
    private List<String> resultingGame = new ArrayList<>();

    public Game(int startingNumber) {
        this.startingNumber = startingNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public List<String> getResultingGame() {
        return resultingGame;
    }

    public void setResultingGame(List<String> resultingGame) {
        this.resultingGame = resultingGame;
    }
}
