package com.tictactoe.newaproach;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GData {
    public GDisplay gameDisplay = new GDisplay();
    private static String playerName;
    public List<Character> lineList0 = new ArrayList<>();
    public List<Character> lineList1 = new ArrayList<>();
    public List<Character> lineList2 = new ArrayList<>();
    public List<Character> lineList3 = new ArrayList<>();
    public List<Character> lineList4 = new ArrayList<>();
    public List<Character> lineList5 = new ArrayList<>();
    public List<Character> lineList6 = new ArrayList<>();
    public List<Character> lineList7 = new ArrayList<>();
    public List<Character> lineList8 = new ArrayList<>();
    public List<Character> lineList9 = new ArrayList<>();
    public boolean endGame = false;
    public static boolean newGame = false;
    private boolean playerTurn = true;
    private static int playerWonTimes = 0;
    private static int computerWonTimes = 0;
    private int numberOfMoves = 0;
    public GData(){
        lineList0.add('|');
        lineList0.add(' ');
        lineList0.add('|');
        lineList0.add(' ');
        lineList0.add('|');
        lineList0.add(' ');
        lineList0.add('|');

        lineList1.add('|');
        lineList1.add(' ');
        lineList1.add('|');
        lineList1.add(' ');
        lineList1.add('|');
        lineList1.add(' ');
        lineList1.add('|');

        lineList2.add('|');
        lineList2.add(' ');
        lineList2.add('|');
        lineList2.add(' ');
        lineList2.add('|');
        lineList2.add(' ');
        lineList2.add('|');
    }
    public GData(String text){
        for (int i = 0; i < 10; i++){
            lineList0.add('|');
            lineList0.add(' ');
            if(i == 9){
             lineList0.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList1.add('|');
            lineList1.add(' ');
            if(i == 9){
                lineList1.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList2.add('|');
            lineList2.add(' ');
            if(i == 9){
                lineList2.add('|');
            }
        }
        for (int i = 0; i < 10; i++) {
            lineList3.add('|');
            lineList3.add(' ');
            if (i == 9) {
                lineList3.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList4.add('|');
            lineList4.add(' ');
            if(i == 9){
                lineList4.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList5.add('|');
            lineList5.add(' ');
            if(i == 9){
                lineList5.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList6.add('|');
            lineList6.add(' ');
            if(i == 9){
                lineList6.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList7.add('|');
            lineList7.add(' ');
            if(i == 9){
                lineList7.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList8.add('|');
            lineList8.add(' ');
            if(i == 9){
                lineList8.add('|');
            }
        }
        for (int i = 0; i < 10; i++){
            lineList9.add('|');
            lineList9.add(' ');
            if(i == 9){
                lineList9.add('|');
            }
        }
    }
    public void setPlayerName() {
        playerName = gameDisplay.playerNameInsert();
    }
    public void playerDecisionAtStart(){
        boolean endLoop = false;
        do{
            gameDisplay.chooseWhatYouWantStartMessage();
            String decision = gameDisplay.keyPressedByPlayer();
            if (decision.length() == 1){
                endLoop = isEndLoop(endLoop, decision);
            }
        } while(!endLoop);
    }
    public boolean version3Or10Data(){
        char decision = gameDisplay.version3Or10Input();
        if (decision == 'l'){
            return true;
        } else if (decision == 's') {
            return false;
        } else if (decision == 'x') {
            endGame = true;
            return false;
        } else{
            return false;
        }
    }
    public void playerDecisionInGame(){
        boolean endLoop = false;
        do {
            gameDisplay.yourMoveMessage();
            String decision = gameDisplay.keyPressedByPlayer();
            if (decision.length() == 1){
                endLoop = isEndLoop(endLoop, decision);
            } else if (decision.length() == 2) {
                if(Character.getNumericValue(decision.charAt(0)) >= 0 && Character.getNumericValue(decision.charAt(0)) <= 2
                && Character.getNumericValue(decision.charAt(1)) >= 0 && Character.getNumericValue(decision.charAt(1)) <= 2){
                    if(makeMove(decision)){
                        endLoop = true;
                    }
                }
            }
        } while(!endLoop);
    }
    public void playerDecisionInGame10x10(){
        boolean endLoop = false;
        do {
            gameDisplay.yourMoveMessage();
            String decision = gameDisplay.keyPressedByPlayer();
            if (decision.length() == 1){
                endLoop = isEndLoop(endLoop, decision);
            } else if (decision.length() == 2) {
                if(Character.getNumericValue(decision.charAt(0)) >= 0 && Character.getNumericValue(decision.charAt(0)) <= 9
                        && Character.getNumericValue(decision.charAt(1)) >= 0 && Character.getNumericValue(decision.charAt(1)) <= 9){
                    if(makeMove10x10(decision)){
                        endLoop = true;
                    }
                }
            }
        } while(!endLoop);
    }

    private boolean isEndLoop(boolean endLoop, String decision) {
        char decisionChar = decision.charAt(0);
        if(decisionChar == 'n'){
            newGame = gameDisplay.areYouSureMessage("play new game");
            if(newGame){
                endLoop = true;
            }
        } else if (decisionChar == 'x') {
            endGame = gameDisplay.areYouSureMessage("quit game");
            if(endGame){
                endLoop = true;
            }
        }
        return endLoop;
    }
    private boolean makeMove(String decision){
        int line = Character.getNumericValue(decision.charAt(0));
        int column = Character.getNumericValue(decision.charAt(1));
        column += column + 1;
        System.out.println("column" + column + "line" + line);
        if(playerTurn){
            if (line == 0 && lineList0.get(column) == ' '){
                lineList0.remove(column);
                lineList0.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            } else if (line == 1 && lineList1.get(column) == ' ') {
                lineList1.remove(column);
                lineList1.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            } else if (line == 2 && lineList2.get(column) == ' ') {
                lineList2.remove(column);
                lineList2.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }
        }
        return false;
    }
    private boolean makeMove10x10(String decision){
        int line = Character.getNumericValue(decision.charAt(0));
        int column = Character.getNumericValue(decision.charAt(1));
        column += column + 1;
        if(playerTurn){
            if (line == 0 && lineList0.get(column) == ' '){
                lineList0.remove(column);
                lineList0.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            } else if (line == 1 && lineList1.get(column) == ' ') {
                lineList1.remove(column);
                lineList1.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            } else if (line == 2 && lineList2.get(column) == ' ') {
                lineList2.remove(column);
                lineList2.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 3 && lineList3.get(column) == ' ') {
                lineList3.remove(column);
                lineList3.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 4 && lineList4.get(column) == ' ') {
                lineList4.remove(column);
                lineList4.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 5 && lineList5.get(column) == ' ') {
                lineList5.remove(column);
                lineList5.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 6 && lineList6.get(column) == ' ') {
                lineList6.remove(column);
                lineList6.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 7 && lineList7.get(column) == ' ') {
                lineList7.remove(column);
                lineList7.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 8 && lineList8.get(column) == ' ') {
                lineList8.remove(column);
                lineList8.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }else if (line == 9 && lineList9.get(column) == ' ') {
                lineList9.remove(column);
                lineList9.add(column, 'X');
                playerTurn = false;
                numberOfMoves++;
                return true;
            }
        }
        return false;
    }
    public void makeRandomComputerMove(){
        Random random = new Random();
        List<Integer> randomLineList = Arrays.asList(0,1,2);
        List<Integer> randomColumnList = Arrays.asList(1,3,5);
        boolean endLoop = false;
        do {
            int randomLine = randomLineList.get(random.nextInt(randomLineList.size()));
            int randomColumn = randomColumnList.get(random.nextInt(randomColumnList.size()));
            if(!playerTurn){
                if (randomLine == 0 && lineList0.get(randomColumn) == ' '){
                    gameDisplay.computerMoveMessage();
                    lineList0.remove(randomColumn);
                    lineList0.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                } else if (randomLine == 1 && lineList1.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList1.remove(randomColumn);
                    lineList1.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                } else if (randomLine == 2 && lineList2.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList2.remove(randomColumn);
                    lineList2.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }
            }
        } while (!endLoop);
    }
    public void makeRandomComputerMove10x10(){
        Random random = new Random();
        List<Integer> randomLineList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        List<Integer> randomColumnList = Arrays.asList(1,3,5,7,9,11,13,15,17,19);
        boolean endLoop = false;
        do {
            int randomLine = randomLineList.get(random.nextInt(randomLineList.size()));
            int randomColumn = randomColumnList.get(random.nextInt(randomColumnList.size()));
            if(!playerTurn){
                if (randomLine == 0 && lineList0.get(randomColumn) == ' '){
                    gameDisplay.computerMoveMessage();
                    lineList0.remove(randomColumn);
                    lineList0.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                } else if (randomLine == 1 && lineList1.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList1.remove(randomColumn);
                    lineList1.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                } else if (randomLine == 2 && lineList2.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList2.remove(randomColumn);
                    lineList2.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 3 && lineList3.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList3.remove(randomColumn);
                    lineList3.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 4 && lineList4.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList4.remove(randomColumn);
                    lineList4.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 5 && lineList5.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList5.remove(randomColumn);
                    lineList5.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 6 && lineList6.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList6.remove(randomColumn);
                    lineList6.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 7 && lineList7.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList7.remove(randomColumn);
                    lineList7.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 8 && lineList8.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList8.remove(randomColumn);
                    lineList8.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }else if (randomLine == 9 && lineList9.get(randomColumn) == ' ') {
                    gameDisplay.computerMoveMessage();
                    lineList9.remove(randomColumn);
                    lineList9.add(randomColumn, 'O');
                    numberOfMoves++;
                    playerTurn = true;
                    endLoop = true;
                }
            }
        } while (!endLoop);
    }
    public boolean checkWin(){
        List<Character> newLineList0 = lineList0.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList1 = lineList1.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList2 = lineList2.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        boolean playerWon = false;
        boolean computerWon = false;
        String lineWin0 = "";
        String lineWin1 = "";
        String lineWin2 = "";
        for (int i = 0; i < 3; i++){
            String columnWin = "";
            lineWin0 = lineWin0 + newLineList0.get(i);
            lineWin1 = lineWin1 + newLineList1.get(i);
            lineWin2 = lineWin2 + newLineList2.get(i);
            columnWin = columnWin + newLineList0.get(i) + newLineList1.get(i) + newLineList2.get(i);
             if(lineWin0.equals("XXX") || columnWin.equals("XXX") || lineWin1.equals("XXX") || lineWin2.equals("XXX")){
                 playerWon = true;
                 gameDisplay.winMessagePlayer(playerName);
                 playerWonTimes++;
                 gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
                 return true;
             } else if (lineWin0.equals("OOO") || columnWin.equals("OOO") || lineWin1.equals("OOO") || lineWin2.equals("OOO")) {
                 computerWon = true;
                 gameDisplay.winMessageComputer();
                 computerWonTimes++;
                 gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
                 return true;
             }
            for (int j = 0; j < 3; j+=2){
                String diagonalWin = "";
                 diagonalWin = diagonalWin + newLineList0.get(j) + newLineList1.get(1) + newLineList2.get(2-j);
                 if(diagonalWin.equals("XXX")){
                     playerWon = true;
                     gameDisplay.winMessagePlayer(playerName);
                     playerWonTimes++;
                     gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
                     return true;
                 } else if (diagonalWin.equals("OOO")) {
                     computerWon = true;
                     gameDisplay.winMessageComputer();
                     computerWonTimes++;
                     gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
                     return true;
                 }
            }
        }
        if(numberOfMoves == 9 && !playerWon && !computerWon){
            gameDisplay.tieMessage();
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        }
        return false;
    }
    public boolean checkWin10x10(){
        List<Character> newLineList0 = lineList0.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList1 = lineList1.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList2 = lineList2.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList3 = lineList3.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList4 = lineList4.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList5 = lineList5.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList6 = lineList6.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList7 = lineList7.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList8 = lineList8.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        List<Character> newLineList9 = lineList9.stream()
                .filter(n -> n != '|')
                .collect(Collectors.toList());
        boolean playerWon = false;
        boolean computerWon = false;
        String lineWin0 = "";
        String lineWin1 = "";
        String lineWin2 = "";
        String lineWin3 = "";
        String lineWin4 = "";
        String lineWin5 = "";
        String lineWin6 = "";
        String lineWin7 = "";
        String lineWin8 = "";
        String lineWin9 = "";
        for (int i = 0; i < 10; i++) {
            String columnWin = "";
            lineWin0 = lineWin0 + newLineList0.get(i);
            lineWin1 = lineWin1 + newLineList1.get(i);
            lineWin2 = lineWin2 + newLineList2.get(i);
            lineWin3 = lineWin3 + newLineList3.get(i);
            lineWin4 = lineWin4 + newLineList4.get(i);
            lineWin5 = lineWin5 + newLineList5.get(i);
            lineWin6 = lineWin6 + newLineList6.get(i);
            lineWin7 = lineWin7 + newLineList7.get(i);
            lineWin8 = lineWin8 + newLineList8.get(i);
            lineWin9 = lineWin9 + newLineList9.get(i);
            columnWin = columnWin + newLineList0.get(i) + newLineList1.get(i) + newLineList2.get(i);
            if (lineWin0.contains("XXXXX") || columnWin.contains("XXXXX") || lineWin1.contains("XXXXX") || lineWin2.contains("XXXXX") || lineWin3.contains("XXXXX")
                    || lineWin4.contains("XXXXX") || lineWin5.contains("XXXXX") || lineWin6.contains("XXXXX") || lineWin7.contains("XXXXX") || lineWin8.contains("XXXXX")
                    || lineWin9.contains("XXXXX")) {
                playerWon = true;
                gameDisplay.winMessagePlayer(playerName);
                playerWonTimes++;
                gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
                return true;
            } else if (lineWin0.contains("OOOOO") || columnWin.contains("OOOOO") || lineWin1.contains("OOOOO") || lineWin2.contains("OOOOO") || lineWin3.contains("OOOOO")
                    || lineWin4.contains("OOOOO") || lineWin5.contains("OOOOO") || lineWin6.contains("OOOOO") || lineWin7.contains("OOOOO") || lineWin8.contains("OOOOO")
                    || lineWin9.contains("OOOOO")) {
                computerWon = true;
                gameDisplay.winMessageComputer();
                computerWonTimes++;
                gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
                return true;
            }
        }
        String diagonalWin1 = "" + newLineList0.get(0) + newLineList1.get(1) + newLineList2.get(2) + newLineList3.get(3) + newLineList4.get(4) + newLineList5.get(5)
                + newLineList6.get(6) + newLineList7.get(7) + newLineList8.get(8) + newLineList9.get(9);
        String diagonalWin2 = "" + newLineList0.get(1) + newLineList1.get(2) + newLineList2.get(3) + newLineList3.get(4) + newLineList4.get(5) + newLineList5.get(6)
                + newLineList6.get(7) + newLineList7.get(8) + newLineList8.get(9);
        String diagonalWin3 = "" + newLineList0.get(2) + newLineList1.get(3) + newLineList2.get(4) + newLineList3.get(5) + newLineList4.get(6) + newLineList5.get(7)
                + newLineList6.get(8) + newLineList7.get(9);
        String diagonalWin4 = "" + newLineList0.get(3) + newLineList1.get(4) + newLineList2.get(5) + newLineList3.get(6) + newLineList4.get(7) + newLineList5.get(8)
                + newLineList6.get(9);
        String diagonalWin5 = "" + newLineList0.get(4) + newLineList1.get(5) + newLineList2.get(6) + newLineList3.get(7) + newLineList4.get(8) + newLineList5.get(9);
        String diagonalWin6 = "" + newLineList0.get(5) + newLineList1.get(6) + newLineList2.get(7) + newLineList3.get(8) + newLineList4.get(9);
        String diagonalWin7 = "" + newLineList1.get(0) + newLineList2.get(1) + newLineList3.get(2) + newLineList4.get(3) + newLineList5.get(4) + newLineList6.get(5)
                + newLineList7.get(6) + newLineList8.get(7) + newLineList9.get(8);
        String diagonalWin8 = "" + newLineList2.get(0) + newLineList3.get(1) + newLineList4.get(2) + newLineList5.get(3) + newLineList6.get(4) + newLineList7.get(5)
                + newLineList8.get(6) + newLineList9.get(7);
        String diagonalWin9 = "" + newLineList3.get(0) + newLineList4.get(1) + newLineList5.get(2) + newLineList6.get(3) + newLineList7.get(4) + newLineList8.get(5)
                + newLineList9.get(6);
        String diagonalWin10 = "" + newLineList4.get(0) + newLineList5.get(1) + newLineList6.get(2) + newLineList7.get(3) + newLineList8.get(4) + newLineList9.get(5);
        String diagonalWin11 = "" + newLineList5.get(0) + newLineList6.get(1) + newLineList7.get(2) + newLineList8.get(3) + newLineList9.get(4);
        String diagonalWin12 = "" + newLineList0.get(9) + newLineList1.get(8) + newLineList2.get(7) + newLineList3.get(6) + newLineList4.get(5) + newLineList5.get(4)
                + newLineList6.get(3) + newLineList7.get(2) + newLineList8.get(1) + newLineList9.get(0);
        String diagonalWin13 = "" + newLineList0.get(8) + newLineList1.get(7) + newLineList2.get(6) + newLineList3.get(5) + newLineList4.get(4) + newLineList5.get(3)
                + newLineList6.get(2) + newLineList7.get(1) + newLineList8.get(0);
        String diagonalWin14 = "" + newLineList0.get(7) + newLineList1.get(6) + newLineList2.get(5) + newLineList3.get(4) + newLineList4.get(3) + newLineList5.get(2)
                + newLineList6.get(1) + newLineList7.get(0);
        String diagonalWin15 = "" + newLineList0.get(6) + newLineList1.get(5) + newLineList2.get(4) + newLineList3.get(3) + newLineList4.get(2) + newLineList5.get(1)
                + newLineList6.get(0);
        String diagonalWin16 = "" + newLineList0.get(5) + newLineList1.get(4) + newLineList2.get(3) + newLineList3.get(2) + newLineList4.get(1) + newLineList5.get(0);
        String diagonalWin17 = "" + newLineList0.get(4) + newLineList1.get(3) + newLineList2.get(2) + newLineList3.get(1) + newLineList4.get(0);
        String diagonalWin18 = "" + newLineList1.get(9) + newLineList2.get(8) + newLineList3.get(7) + newLineList4.get(6) + newLineList5.get(5) + newLineList6.get(4)
                + newLineList7.get(3) + newLineList8.get(2) + newLineList9.get(1);
        String diagonalWin19 = "" + newLineList2.get(9) + newLineList3.get(8) + newLineList4.get(7) + newLineList5.get(6) + newLineList6.get(5) + newLineList7.get(4)
                + newLineList8.get(3) + newLineList9.get(2);
        String diagonalWin20 = "" + newLineList3.get(9) + newLineList4.get(8) + newLineList5.get(7) + newLineList6.get(6) + newLineList7.get(5) + newLineList8.get(4)
                + newLineList9.get(3);
        String diagonalWin21 = "" + newLineList4.get(9) + newLineList5.get(8) + newLineList6.get(7) + newLineList7.get(6) + newLineList8.get(5) + newLineList9.get(4);
        String diagonalWin22 = "" + newLineList5.get(9) + newLineList6.get(8) + newLineList7.get(7) + newLineList8.get(6) + newLineList9.get(5);
        if(diagonalWin1.contains("XXXXX")){
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin1.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin2.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin2.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin3.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin3.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin4.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin4.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin5.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin5.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin6.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin6.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin7.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin7.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin8.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin8.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin9.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin9.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin10.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin10.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin11.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin11.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin12.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin12.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin13.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin13.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin14.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin14.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin15.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin15.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin16.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin16.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin17.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin17.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin18.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin18.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin19.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin19.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin20.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin20.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin21.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin21.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin22.contains("XXXXX")) {
            playerWon = true;
            gameDisplay.winMessagePlayer(playerName);
            playerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        } else if (diagonalWin22.contains("OOOOO")) {
            computerWon = true;
            gameDisplay.winMessageComputer();
            computerWonTimes++;
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        }
        if(numberOfMoves == 100 && !playerWon && !computerWon){
            gameDisplay.tieMessage();
            gameDisplay.timesWon(playerName, playerWonTimes, computerWonTimes);
            return true;
        }
        return false;
    }
}
