package com.company;

import java.util.Scanner;
public class Game {
    public static String[] gamePlayer = new String[2];

    public static void PlayerAssignParameters(String playerOne, String playerTwo){
        gamePlayer[0] = playerOne;
        gamePlayer[1] = playerTwo;
        getPlayerMove();
    }
    private static void getPlayerMove() {
        int[] playerChoice = new int[2];
        Scanner gameScanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println(gamePlayer[i] + " Would you like to pick" +
                    "\n1. Rock" +
                    "\n2. Paper" +
                    "\n3. Scissors");
            playerChoice[i] = gameScanner.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            if(playerChoice[i] == 0){
                System.out.println("Please enter a valid choice");
                i--;
            } else {
                playGame(playerChoice[0], playerChoice[1]);
            }
        }
    }

    private static int choiceValidation(int choice){
        if (choice > 1 || choice < 4) {
            return choice;
        } else {
            return 0;
        }
    }

    private static void playGame(int choiceOne,int choiceTwo){
        switch (choiceOne){
            case 1:
                if (choiceTwo == 1 ){
                    rematch();
                } else if (choiceTwo == 2) {
                    System.out.println(gamePlayer[1] + " wins");
                } else if(choiceTwo == 3) {
                    System.out.println(gamePlayer[0] + " wins");
                }
                break;
            case 2:
                if (choiceTwo == 1 ){
                    System.out.println(gamePlayer[0] + " wins");
                } else if (choiceTwo == 2) {
                    rematch();
                } else if(choiceTwo == 3) {
                    System.out.println(gamePlayer[1] + " wins");
                }
                break;
            case 3:
                if (choiceTwo == 1 ){
                    System.out.println(gamePlayer[1] + " wins");
                } else if (choiceTwo == 2) {
                    System.out.println(gamePlayer[0] + " wins");
                } else if(choiceTwo == 3) {
                    rematch();
                }
                break;
        }
    }

    private static void rematch() {
        Scanner rematchScanner = new Scanner(System.in);
        System.out.println("Would you like to play again y/n?");
        String rematchChoice = rematchScanner.nextLine();
        rematchChoice = rematchChoice.toLowerCase();
        char rematchChoiceChar = rematchChoice.toCharArray()[0];
        switch (rematchChoiceChar){
            case 'y':
                getPlayerMove();
                break;
            case 'n':
                Main.MainMenu();
        }
    }


}
