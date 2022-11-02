package com.tictactoe.vsfriend;

public class GameRunner {
    public static void main(String[] args) {
        boolean endOfGame = GameData.endGame;
        while (!endOfGame) {
            GameData gameData = new GameData();

            gameData.gameDisplay.displayMenu(); //wyswietlenie menu
            if (GameData.getPlayerWonTimes() == 0 && GameData.getPlayer2WonTimes() ==0){
                gameData.playerMenuDecision(); //pierwsza decyzja w menu nowa gra/zakonczenie gry
                if (GameData.endGame) {
                    gameData.gameDisplay.displayEndSentence();
                    break;
                }
                gameData.setPlayerName();  //wpisanie imion graczy
                gameData.setPlayer2Name();
            }
            boolean endLoop = false;
            do {
                gameData.makeMove();
                gameData.gameDisplay.displayBoard(gameData.getGameBoard());
                endLoop = gameData.checkWin();
            } while (!endLoop && gameData.getNumberOfMoves() != 9);
            gameData.gameDisplay.timesWon(gameData.getPlayerName(), GameData.getPlayerWonTimes(), gameData.getPlayer2Name(), GameData.getPlayer2WonTimes());
            System.out.println("Decide if you want to play again or quit below (n/x):");
            gameData.playerMenuDecision();
            if (GameData.endGame) {
                gameData.gameDisplay.displayEndSentence();
                break;
            }
        }
    }
}
