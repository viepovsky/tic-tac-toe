package com.tictactoe.newaproach;

public class GRunner {
    public static void main(String[] args) {
        GData gameData = new GData();
        boolean version10x10 = false;
        do{
            if (gameData.newGame){
                gameData = new GData();
                gameData.newGame = true;
            }
            gameData.gameDisplay.displayMenu();
            version10x10 = gameData.version3Or10Data();
            if(!version10x10 && !gameData.endGame){                     //start gry 3x3
                gameData.gameDisplay.displayMenu3x3();
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
            } else if (!gameData.endGame){                        //start gry 10x10
                gameData = new GData("10x10");
                gameData.gameDisplay.displayMenu10x10();

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
                boolean endLoop = false;
                do {
                    gameData.playerDecisionInGame10x10();
                    if (gameData.newGame || gameData.endGame){
                        break;
                    }
                    gameData.gameDisplay.displayBoard10x10(gameData.lineList0, gameData.lineList1, gameData.lineList2,gameData.lineList3,gameData.lineList4,
                            gameData.lineList5,gameData.lineList6,gameData.lineList7,gameData.lineList8,gameData.lineList9);
                    endLoop = gameData.checkWin10x10();
                    if(gameData.endGame || endLoop){
                        break;
                    }
                    gameData.makeRandomComputerMove10x10();
                    gameData.gameDisplay.displayBoard10x10(gameData.lineList0, gameData.lineList1, gameData.lineList2,gameData.lineList3,gameData.lineList4,
                            gameData.lineList5,gameData.lineList6,gameData.lineList7,gameData.lineList8,gameData.lineList9);
                    endLoop = gameData.checkWin10x10();
                } while (!gameData.endGame && !gameData.newGame && !endLoop);
                if (!gameData.newGame && !gameData.endGame){
                    gameData.playerDecisionAtStart();
                }
            }
        } while(!gameData.endGame);
    }
}
