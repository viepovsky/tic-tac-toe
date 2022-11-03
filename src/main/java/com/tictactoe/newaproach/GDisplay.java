package com.tictactoe.newaproach;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GDisplay {
    Scanner scanner = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("Welcome to the Tic Tac Toe game!");
        System.out.println("\nRules:\nFirst player plays X's, second plays O's.\nThree X's or O's in line means win.");
        System.out.println("\nControl keys:");
        System.out.println("Key \"x\" - quit game.");
        System.out.println("Key \"n\" - new game.");
        System.out.println("Making move, first choose line:");
        System.out.println("0| | | |");
        System.out.println("1| | | |");
        System.out.println("2| | | |");
        System.out.println("then choose column:");
        System.out.println(" 0 1 2 ");
        System.out.println("| | | |");
        System.out.println("| | | |");
        System.out.println("| | | |");
        System.out.println("Key input should look like this \"1,2\" - move X on 1st line,2nd column.");
    }
    public void displayBoard(List<Character> list1, List<Character> list2, List<Character> list3){
        for (Character line1Columns : list1){
            System.out.print(line1Columns);
        }
        System.out.println();
        for (Character line2Columns : list2){
            System.out.print(line2Columns);
        }
        System.out.println();
        for (Character line3Columns : list3){
            System.out.print(line3Columns);
        }
        System.out.println();
    }
    public String keyPressedByPlayer(){
        String text = scanner.next();
        char line = text.charAt(0);
        if(text.length() == 3){
            char column = text.charAt(2);
            return "" + line + column;
        }
        return "" + line;
    }
    public String playerNameInsert(){
        System.out.print("Please write your name:");
        return scanner.next();
    }
    public void chooseWhatYouWantStartMessage(){
        System.out.print("\nChoose if you want to play a new game or quit:");
    }
    public void yourMoveMessage(){
        System.out.println("Your move:");
    }
    public boolean areYouSureMessage(String text){
        boolean endLoop = false;
        boolean result = false;
        do{
            System.out.print("Are you sure you want to " + text + "? (y/n)");
            char yesOrNo = scanner.next().charAt(0);
            if (yesOrNo == 'y'){
                result = true;
                endLoop = true;
            } else if (yesOrNo == 'n') {
                endLoop = true;
            }
        } while(!endLoop);
        return result;
    }
    public void computerMoveMessage(){
        System.out.println("\nThis is computer move:");
    }
    public void tieMessage(){
        System.out.println("It's a tie! Nobody won this time.");
    }
    public void winMessagePlayer(String text){
        System.out.println("Player " + text + " won the game.");
    }
    public void winMessageComputer(){
        System.out.println("Computer won the game.");
    }
    public void timesWon(String text1, int n1, int n2) {
        System.out.println("Player " + text1 + " won:" + n1 + " times.");
        System.out.println("Computer won:" + n2 + " times.");
    }
}
