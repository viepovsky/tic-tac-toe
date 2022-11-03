package com.tictactoe.newaproach;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GDisplay {
    Scanner scanner = new Scanner(System.in);
    public char version3Or10Input(){
        String decision;
        boolean endLoop = false;
        do {
            System.out.println("Do you want to play TicTacToe version on a board 3x3 or 10x10?");
            System.out.print("Decision (Small/Large/Quit):");
            decision = scanner.next();
            if (decision.equals("small") || decision.equals("Small")){
                return 's';
            } else if (decision.equals("large") || decision.equals("Large")) {
                return 'l';
            } else if (decision.equals("Quit") || decision.equals("quit")) {
                if (areYouSureMessage("quit game")){
                    return 'x';
                }
            }
        } while (!endLoop);
        return ' ';
    }
    public void displayMenu(){
        System.out.println("Welcome to the Tic Tac Toe game! (3x3 and 10x10 board)");
    }
    public void displayMenu3x3(){
        System.out.println("This is Tic Tac Toe 3x3 game!");
        System.out.println("\nRules:\nPlayer plays X's, computer plays O's.\nThree X's or O's in line, column or diagonal means win.");
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
        System.out.println("Key input should look like this \"1,2\" - move X on 1st line, 2nd column.");
    }
    public void displayMenu10x10(){
        System.out.println("This is Tic Tac Toe 10x10 game!");
        System.out.println("\nRules:\nPlayer plays X's, computer plays O's.\nThree X's or O's in line, column or diagonal means win.");
        System.out.println("\nControl keys:");
        System.out.println("Key \"x\" - quit game.");
        System.out.println("Key \"n\" - new game.");
        System.out.println("Making move, first choose line:");
        System.out.println("0| | | | | | | | | | |");
        System.out.println("1| | | | | | | | | | |");
        System.out.println("2| | | | | | | | | | |");
        System.out.println("3| | | | | | | | | | |");
        System.out.println("4| | | | | | | | | | |");
        System.out.println("5| | | | | | | | | | |");
        System.out.println("6| | | | | | | | | | |");
        System.out.println("7| | | | | | | | | | |");
        System.out.println("8| | | | | | | | | | |");
        System.out.println("9| | | | | | | | | | |");
        System.out.println("then choose column:");
        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("| | | | | | | | | | |");
        System.out.println("Key input should look like this \"1,5\" - move X on 1st line, 5th column.");
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
    public void displayBoard10x10(List<Character> list1, List<Character> list2, List<Character> list3, List<Character> list4, List<Character> list5,
                                  List<Character> list6, List<Character> list7, List<Character> list8, List<Character> list9, List<Character> list10){
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
        for (Character line4Columns : list4){
            System.out.print(line4Columns);
        }
        System.out.println();
        for (Character line5Columns : list5){
            System.out.print(line5Columns);
        }
        System.out.println();
        for (Character line6Columns : list6){
            System.out.print(line6Columns);
        }
        System.out.println();
        for (Character line7Columns : list7){
            System.out.print(line7Columns);
        }
        System.out.println();
        for (Character line8Columns : list8){
            System.out.print(line8Columns);
        }
        System.out.println();
        for (Character line9Columns : list9){
            System.out.print(line9Columns);
        }
        System.out.println();
        for (Character line10Columns : list10){
            System.out.print(line10Columns);
        }
        System.out.println();
    }
    public String keyPressedByPlayer(){
        String text = scanner.next();
        char line = text.charAt(0);
        String column = "";
        if(text.length() == 3){
            char columnChar = text.charAt(2);
            column = "" + columnChar;
        }
        return "" + line + column;

    }
    public String playerNameInsert(){
        System.out.print("Please write your name:");
        return scanner.next();
    }
    public void chooseWhatYouWantStartMessage(){
        System.out.print("\nChoose if you want to play a new game or quit:(n/x)");
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
