package com.minigames.fizzbuzz.representation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    private int id;
    private Date completionDate;
    private List<String> resultingGame = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
