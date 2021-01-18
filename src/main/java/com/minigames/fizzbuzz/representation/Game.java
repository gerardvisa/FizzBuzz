package com.minigames.fizzbuzz.representation;

import java.util.Date;

public class Game {
    private int id;
    private Date completionDate;

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
}
