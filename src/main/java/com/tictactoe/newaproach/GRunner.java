package com.tictactoe.newaproach;

public class GRunner {
    public static void main(String[] args) {
        GData gameData = new GData();
        do{
            if (gameData.newGame){
                gameData = new GData();
                gameData.newGame = true;
            }
            gameData.gameDisplay.displayMenu();
            if(!gameData.newGame){
                gameData.playerDecisionAtStart();
                if(gameData.endGame){
                    break;
                }
                gameData.setPlayerName();
            }
             if (gameData.newGame){
                 gameData.newGame = false;
            }
            boolean endLoop = true;
            do {
                gameData.playerDecisionInGame();
                if (gameData.newGame || gameData.endGame){
                    break;
                }
                gameData.gameDisplay.displayBoard(gameData.lineList0, gameData.lineList1, gameData.lineList2);
                endLoop = gameData.checkWin();
                if(gameData.endGame || endLoop){
                    break;
                }
                gameData.makeRandomComputerMove();
                gameData.gameDisplay.displayBoard(gameData.lineList0, gameData.lineList1, gameData.lineList2);
                endLoop = gameData.checkWin();
            } while (!gameData.endGame && !gameData.newGame && !endLoop);

            if (!gameData.newGame && !gameData.endGame){
                gameData.playerDecisionAtStart();
            }
        } while(!gameData.endGame);
    }
}
