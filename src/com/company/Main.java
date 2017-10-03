package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Player> storedUsers = new ArrayList<Player>();
    public static void main(String[] args) {

	    MainMenu();
    }

    public static void MainMenu(){
        Scanner choiceScanner = new Scanner(System.in);
        System.out.println("Welcome to the best game ever" +
                "\n=============================\n");
        System.out.println("Would you like to..." +
                "\n1. Play a game of Rock, Paper, Scissors" +
                "\n2. Create a new account" +
                "\n3. View the player stats" +
                "\nPlease enter the number corresponding to the action\n");
        int playerChoice = choiceScanner.nextInt();
        System.out.println();
        switch(playerChoice){
            case 1:
                PlayGame();
                break;
            case 2:
                CreateAccount();
                break;
            case 3:
                PlayerStats();
                break;
            default:
                System.out.println("Please enter a valid input");
                MainMenu();
        }
    }

    private static void PlayGame(){
        Scanner playerScanner = new Scanner(System.in);
        System.out.println("Enter the name of player one");
        String playerOne = playerScanner.nextLine();
        System.out.println("Enter the name of player two");
        String playerTwo = playerScanner.nextLine();
        Game.PlayerAssignParameters(playerOne, playerTwo);
    }

    private static void CreateAccount(){
        Scanner userScanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter a username");
        String userName = userScanner.nextLine();
        storedUsers.add(userCreation(userName));
    }

    private static void PlayerStats(){

    }

    private static Player userCreation(String userName) {
        return new Player(userName);
    }

    public static void scoreSetting (String winner, String loser) {
        for (int w = 0; w < storedUsers.size(); w++){
            if (storedUsers.get(w).getUserName().equals(winner)) {
                storedUsers.get(w).recordResult(true);
            }
        }
        for (int l = 0; l < storedUsers.size(); l++){
            if (storedUsers.get(l).getUserName().equals(loser)) {
                storedUsers.get(l).recordResult(false);
            }
        }
    }
}
