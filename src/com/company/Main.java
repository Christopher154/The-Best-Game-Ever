package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Player> storedUsers = new ArrayList<Player>();
    public static void main(String[] args) {

	    MainMenu();
    }

    private static void MainMenu(){
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

    private static void PlayGame() {
        boolean playerExists;
        Scanner playerScanner = new Scanner(System.in);
        System.out.println("Enter the name of player one");
        String playerOne = playerScanner.nextLine();
        for (int i = 0; i < storedUsers.size(); i++) {
            if (storedUsers.get(i).getUserName() == playerOne) {
                System.out.println("Username doesn't exist, please try again");
                playerOne = playerScanner.nextLine();
            } else {
                System.out.println("Player One is " + playerOne);
            }
        }
        System.out.println("Enter the name of player two");
        String playerTwo = playerScanner.nextLine();
        for (int i = 0; i < storedUsers.size(); i++) {
            if (playerOne == playerTwo) {
                System.out.println("You have entered the same Username twice");
                playerTwo = playerScanner.nextLine();
            }
            else if (storedUsers.get(i).getUserName() == playerTwo) {
                System.out.println("Username doesn't exist, please try again");
                playerTwo = playerScanner.nextLine();
            } else{
                System.out.println("Player Two is " + playerTwo);
                Game.PlayerAssignParameters(playerOne, playerTwo);
            }
        }
    }

    private static void CreateAccount(){
        Scanner userScanner = new Scanner(System.in);
        System.out.println("\nPlease enter a username");
        String userName = userScanner.nextLine();
        if(storedUsers.size() > 0) {
            for (int i = 0; i < storedUsers.size(); i++) {
                if (storedUsers.get(i).getUserName().equals(userName)) {
                    System.out.println("Username already exists, try again");
                    CreateAccount();
                } else {
                    System.out.println("User created\n");
                    storedUsers.add(new Player(userName));
                    MainMenu();
                }
            }
        }
        else {
            storedUsers.add(new Player(userName));
            MainMenu();
        }
    }

    private static void PlayerStats(){

    }

    private static void userCreation(String userName) {
        storedUsers.add(new Player(userName));
    }
}
