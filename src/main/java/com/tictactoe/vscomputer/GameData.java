package com.tictactoe.vscomputer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameData {
    GameDisplay gameDisplay = new GameDisplay();
    public static boolean endGame = false;
    private int numberOfMoves;
    private static String playerName;
    private boolean playerWon = false;
    private static int playerWonTimes = 0;
    private static String player2Name;
    private boolean player2Won = false;
    private static int player2WonTimes = 0;
    private boolean playerFirstTurn;
    private List<Character> gameBoard = new ArrayList<>();
    public GameData() {
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        gameBoard.add(' ');
        gameBoard.add('|');
        playerFirstTurn = true;
        numberOfMoves = 0;
    }
    public void playerMenuDecision(){
        boolean endLoop = false;
        do {
            char key = gameDisplay.playerDecisionInMenu();
            boolean newGame = false;
            if (key == 'n'){
                newGame = gameDisplay.areYouSure("play new");
                if(newGame){
                    endLoop = true;
                }
            } else if (key == 'x'){
                endGame = gameDisplay.areYouSure("quit");
                if (endGame){
                    endLoop = true;
                }
            }
        } while (!endLoop);
    }
    public void makeMove() {
        char key = gameDisplay.playerDecisionInGame();
        int keyInt = Character.getNumericValue(key);
        int arrayMove = keyInt + keyInt - 1;
        if (playerFirstTurn) {
            if (gameBoard.get(arrayMove) == ' ') {
                gameBoard.remove(arrayMove);
                gameBoard.add(arrayMove, 'X');
                playerFirstTurn = false;
                numberOfMoves++;
            }
        } else {
            if (gameBoard.get(arrayMove) == ' ') {
                gameBoard.remove(arrayMove);
                gameBoard.add(arrayMove, 'O');
                playerFirstTurn = true;
                numberOfMoves++;
            }
        }
    }
    public void makeMoveVsComputer() {
        char key = gameDisplay.playerDecisionInGame();
        int keyInt = Character.getNumericValue(key);
        int arrayMove = keyInt + keyInt - 1;
        if (gameBoard.get(arrayMove) == ' ' && playerFirstTurn) {
            gameBoard.remove(arrayMove);
            gameBoard.add(arrayMove, 'X');
            numberOfMoves++;
            playerFirstTurn = false;
        }
    }
    public void makeComputerMove(){
        if (!playerFirstTurn){
            List<Integer> randomList = Arrays.asList(1,3,5,7,9,11,13,15,17);
            Random random = new Random();
            boolean endLoop = false;
            while(!endLoop){
            int randomMove = randomList.get(random.nextInt(randomList.size()));
            if(gameBoard.get(randomMove) == ' '){
                gameBoard.remove(randomMove);
                gameBoard.add(randomMove, 'O');
                endLoop = true;
            }
            }
            numberOfMoves++;
            playerFirstTurn = true;
        }
    }
    public boolean checkWin(){
        if (gameBoard.get(1) == 'X' && gameBoard.get(9) == 'X' && gameBoard.get(17) == 'X'){
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(13) == 'X' && gameBoard.get(9) == 'X' && gameBoard.get(5) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(1) == 'X' && gameBoard.get(3) == 'X' && gameBoard.get(5) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(7) == 'X' && gameBoard.get(9) == 'X' && gameBoard.get(11) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(13) == 'X' && gameBoard.get(15) == 'X' && gameBoard.get(17) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(1) == 'X' && gameBoard.get(7) == 'X' && gameBoard.get(13) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(3) == 'X' && gameBoard.get(9) == 'X' && gameBoard.get(15) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(5) == 'X' && gameBoard.get(11) == 'X' && gameBoard.get(17) == 'X') {
            gameDisplay.playerWonMessage(playerName);
            playerWon = true;
            playerWonTimes++;
            return true;
        } else if (gameBoard.get(1) == 'O' && gameBoard.get(9) == 'O' && gameBoard.get(17) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(13) == 'O' && gameBoard.get(9) == 'O' && gameBoard.get(5) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(1) == 'O' && gameBoard.get(3) == 'O' && gameBoard.get(5) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(7) == 'O' && gameBoard.get(9) == 'O' && gameBoard.get(11) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(13) == 'O' && gameBoard.get(15) == 'O' && gameBoard.get(17) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(1) == 'O' && gameBoard.get(7) == 'O' && gameBoard.get(13) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(3) == 'O' && gameBoard.get(9) == 'O' && gameBoard.get(15) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (gameBoard.get(5) == 'O' && gameBoard.get(11) == 'O' && gameBoard.get(17) == 'O') {
            gameDisplay.playerWonMessage(player2Name);
            player2Won = true;
            player2WonTimes++;
            return true;
        } else if (numberOfMoves == 9) {
            gameDisplay.tieMessage();
            return false;
        } else {
            return false;
        }
    }
    public void setPlayerName() {
        this.playerName = gameDisplay.playersNamesInput("first");
    }
    public void setPlayer2Name() {
        this.player2Name = gameDisplay.playersNamesInput("second");
    }
    public List<Character> getGameBoard() {
        return gameBoard;
    }
    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static int getPlayerWonTimes() {
        return playerWonTimes;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public static int getPlayer2WonTimes() {
        return player2WonTimes;
    }

    public void setGameBoard(List<Character> gameBoard) {
        this.gameBoard = gameBoard;
    }
}
