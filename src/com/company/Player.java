package com.company;

public class Player {
    private String userName;
    private int currentWins;
    private  int getCurrentLosses;

    public Player(String userName) {
        this.userName = userName;
        this.currentWins = 0;
        this.getCurrentLosses = 0;
    }

    public String getUserName() {
        return userName;
    }

    public int getCurrentWins() {
        return currentWins;
    }

    public int getGetCurrentLosses() {
        return getCurrentLosses;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCurrentWins(int currentWins) {
        this.currentWins = currentWins;
    }

    public void setGetCurrentLosses(int getCurrentLosses) {
        this.getCurrentLosses = getCurrentLosses;
    }

    public void recordResult(boolean win){
        if(win = true){
            currentWins++;
        }
        else {
            getCurrentLosses++;
        }
    }
}