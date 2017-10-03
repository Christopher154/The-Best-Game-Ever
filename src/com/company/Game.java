package com.company;

public class Game {

    private int playerOneMove;
    private int playerTwoMove;

    public Game(int playerOneMove, int playerTwoMove) {
        this.playerOneMove = playerOneMove;
        this.playerTwoMove = playerTwoMove;
    }

    public int getPlayerOneMove() {
        return playerOneMove;
    }

    public int getPlayerTwoMove() {
        return playerTwoMove;
    }

    public void setPlayerOneMove(int playerOneMove) {
        this.playerOneMove = playerOneMove;
    }

    public void setPlayerTwoMove(int playerTwoMove) {
        this.playerTwoMove = playerTwoMove;
    }

    public static void PlayerAssignParameters(String playerOneUsername, String playerTwoUsername) {
        Player playerOne = new Player(playerOneUsername);
        Player playerTwo = new Player(playerTwoUsername);
        Player[] players = new Player[] {playerOne, playerTwo};
    }
}
