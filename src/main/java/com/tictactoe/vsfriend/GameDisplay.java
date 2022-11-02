package com.tictactoe.vsfriend;

import java.util.List;
import java.util.Scanner;

public class GameDisplay {
    private Scanner scanner = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("Welcome to the Tic Tac Toe game!");
        System.out.println("\nRules:\nFirst player plays X's, second plays O's.\nThree X's or O's in line means win.");
        System.out.println("\nControl keys:");
        System.out.println("Key \"x\" - quit game.");
        System.out.println("Key \"n\" - new game.");
        System.out.println("Key \"1-9\" - move X or O on position as shown below:");
        System.out.println("|1|2|3|");
        System.out.println("|4|5|6|");
        System.out.println("|7|8|9|\n");
    }
    public void displayBoard(List<Character> gameBoard){

        System.out.print(gameBoard.get(0));
        System.out.print(gameBoard.get(1));
        System.out.print(gameBoard.get(2));
        System.out.print(gameBoard.get(3));
        System.out.print(gameBoard.get(4));
        System.out.print(gameBoard.get(5));
        System.out.println(gameBoard.get(6));
        System.out.print(gameBoard.get(6));
        System.out.print(gameBoard.get(7));
        System.out.print(gameBoard.get(8));
        System.out.print(gameBoard.get(9));
        System.out.print(gameBoard.get(10));
        System.out.print(gameBoard.get(11));
        System.out.println(gameBoard.get(12));
        System.out.print(gameBoard.get(12));
        System.out.print(gameBoard.get(13));
        System.out.print(gameBoard.get(14));
        System.out.print(gameBoard.get(15));
        System.out.print(gameBoard.get(16));
        System.out.print(gameBoard.get(17));
        System.out.println(gameBoard.get(18));
    }
    public void displayEndSentence(){
        System.out.println("The game has ended.");
        System.out.println("Thank you for playing our game.");
    }
    public void playerWonMessage(String text){
        System.out.println("Player " + text + " won the game.");
    }
    public String playersNamesInput(String text){
        System.out.println("Please enter " + text + " player name:");
        String name = scanner.next();
        return name;
    }
    public char keyPressedByPlayer(){
        return scanner.next().charAt(0);
    }
    public char playerDecisionInMenu(){
        boolean endLoop = false;
        char decision;
        do{
            System.out.print("Make your decision:");
            decision = keyPressedByPlayer();
            if(decision == 'n' || decision == 'x'){
                endLoop = true;
                }
        } while (!endLoop);
        return decision;
    }
    public char playerDecisionInGame(){
        boolean endLoop = false;
        char decision;
        do{
            System.out.print("Make your move:");
            decision = keyPressedByPlayer();
            if(decision == '1' || decision == '2' || decision == '3' ||  decision == '4' || decision == '5' || decision == '6' ||
                    decision == '7' || decision == '8' || decision == '9'){
                endLoop = true;
            }
        } while (!endLoop);
        return decision;
    }
    public boolean areYouSure(String exitOrNew){
        boolean endLoop = false;
        boolean playerSure = false;
        do{
            System.out.print("Are you sure you want to " + exitOrNew + " game?(y/n)");
            char decision = keyPressedByPlayer();
            if(decision == 'y'){
                playerSure = true;
                endLoop = true;
            } else if (decision == 'n'){
                playerSure = false;
                endLoop = true;
            }
        } while(!endLoop);
        return playerSure;
    }
    public void timesWon(String text1, int n1, String text2, int n2){
        System.out.println("Player " + text1 + " won:" + n1 + " times.");
        System.out.println("Player " + text2 + " won:" + n2 + " times.");
    }
    public void tieMessage(){
        System.out.println("It's a ite! Nobody won this time.");
    }
}
