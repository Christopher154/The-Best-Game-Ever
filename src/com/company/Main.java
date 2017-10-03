package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Player> storedUsers = new ArrayList<Player>();
    public static String playerOne;
    public static void main(String[] args) {

	    MainMenu();
    }

    public static void MainMenu(){
        System.out.flush();
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
                PlayerOneGameSetup();
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

    public static void PlayerOneGameSetup() {
        Scanner playerOneScanner = new Scanner(System.in);
        System.out.println("Enter the name of player one");
        playerOne = playerOneScanner.nextLine();
        if (storedUsers.size() > 0)
            for (int i = 0; i < storedUsers.size(); i++) {
                if (storedUsers.get(i).getUserName().equals(playerOne)) {
                    System.out.println("Player One is " + playerOne);
                    break;
                }
            }
        PlayerTwoGameSetup();
    }

    public  static  void  PlayerTwoGameSetup(){
        Scanner playerTwoScanner = new Scanner(System.in);
        System.out.println("Enter the name of player two");
        String playerTwo = playerTwoScanner.nextLine();
        if (storedUsers.size() > 0)
            for (int i = 0; i < storedUsers.size(); i++) {
                if (playerOne.equals(playerTwo)) {
                    System.out.println("You have entered the same Username twice");
                    PlayerTwoGameSetup();
                } else if (storedUsers.get(i).getUserName().equals(playerTwo)) {
                    System.out.println("Player Two is " + playerTwo);
                    Game.PlayerAssignParameters(playerOne, playerTwo);
                    break;
                }
            }
        System.out.println("Username doesn't exist, please try again");
        PlayerTwoGameSetup();
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
        for(int i = 0;i< storedUsers.size(); i++){
            System.out.println("User:" + storedUsers.get(i).getUserName() + ", Wins:"
            + storedUsers.get(i).getCurrentWins() + ", Losses:" + storedUsers.get(i).getCurrentLosses());
        }
        MainMenu();
    }

    private static void userCreation(String userName) {
        storedUsers.add(new Player(userName));
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
        MainMenu();
    }
}
