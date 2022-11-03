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
    public boolean endGame = false;
    public boolean newGame = false;
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
}
