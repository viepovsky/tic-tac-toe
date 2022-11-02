package com.tictactoe.vsfriend;

import com.tictactoe.vsfriend.GameData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Game Tic Tac Toe Test Suite")
public class GameTestSuite {
    GameData gameData;
    GameData gameData2;
    GameData gameData3;
    List<Character> gameBoard = new ArrayList<>();
    List<Character> gameBoard2 = new ArrayList<>();
    List<Character> gameBoard3 = new ArrayList<>();

    @BeforeEach
    public void beforeEach(){
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

        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');
        gameBoard3.add(' ');
        gameBoard3.add('|');

        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
        gameBoard2.add(' ');
        gameBoard2.add('|');
    }
    @Test
    void testWinOInLines(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'O');
        gameBoard.remove(3);
        gameBoard.add(3,'O');
        gameBoard.remove(5);
        gameBoard.add(5,'O');
        gameData.setGameBoard(gameBoard);
        gameData2 = new GameData();
        gameBoard2.remove(7);
        gameBoard2.add(7,'O');
        gameBoard2.remove(9);
        gameBoard2.add(9,'O');
        gameBoard2.remove(11);
        gameBoard2.add(11,'O');
        gameData2.setGameBoard(gameBoard2);
        gameData3 = new GameData();
        gameBoard3.remove(13);
        gameBoard3.add(13,'O');
        gameBoard3.remove(15);
        gameBoard3.add(15,'O');
        gameBoard3.remove(17);
        gameBoard3.add(17,'O');
        gameData3.setGameBoard(gameBoard3);
        //When
        boolean expectedResult = gameData.checkWin();
        boolean expectedResult2 = gameData2.checkWin();
        boolean expectedResult3 = gameData3.checkWin();
        //Then
        assertTrue(expectedResult);
        assertTrue(expectedResult2);
        assertTrue(expectedResult3);
    }
    @Test
    void testWinOInColumns(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'O');
        gameBoard.remove(7);
        gameBoard.add(7,'O');
        gameBoard.remove(13);
        gameBoard.add(13,'O');
        gameData.setGameBoard(gameBoard);
        gameData2 = new GameData();
        gameBoard2.remove(3);
        gameBoard2.add(3,'O');
        gameBoard2.remove(9);
        gameBoard2.add(9,'O');
        gameBoard2.remove(15);
        gameBoard2.add(15,'O');
        gameData2.setGameBoard(gameBoard2);
        gameData3 = new GameData();
        gameBoard3.remove(5);
        gameBoard3.add(5,'O');
        gameBoard3.remove(11);
        gameBoard3.add(11,'O');
        gameBoard3.remove(17);
        gameBoard3.add(17,'O');
        gameData3.setGameBoard(gameBoard3);
        //When
        boolean expectedResult = gameData.checkWin();
        boolean expectedResult2 = gameData2.checkWin();
        boolean expectedResult3 = gameData3.checkWin();
        //Then
        assertTrue(expectedResult);
        assertTrue(expectedResult2);
        assertTrue(expectedResult3);
    }
    @Test
    void testWinOInDiagonals(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'O');
        gameBoard.remove(9);
        gameBoard.add(9,'O');
        gameBoard.remove(17);
        gameBoard.add(17,'O');
        gameData.setGameBoard(gameBoard);
        gameData2 = new GameData();
        gameBoard2.remove(5);
        gameBoard2.add(5,'O');
        gameBoard2.remove(9);
        gameBoard2.add(9,'O');
        gameBoard2.remove(13);
        gameBoard2.add(13,'O');
        gameData2.setGameBoard(gameBoard2);
        //When
        boolean expectedResult = gameData.checkWin();
        boolean expectedResult2 = gameData2.checkWin();
        //Then
        assertTrue(expectedResult);
        assertTrue(expectedResult2);
    }
    @Test
    void testWinXInLines(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'X');
        gameBoard.remove(3);
        gameBoard.add(3,'X');
        gameBoard.remove(5);
        gameBoard.add(5,'X');
        gameData.setGameBoard(gameBoard);
        gameData2 = new GameData();
        gameBoard2.remove(7);
        gameBoard2.add(7,'X');
        gameBoard2.remove(9);
        gameBoard2.add(9,'X');
        gameBoard2.remove(11);
        gameBoard2.add(11,'X');
        gameData2.setGameBoard(gameBoard2);
        gameData3 = new GameData();
        gameBoard3.remove(13);
        gameBoard3.add(13,'X');
        gameBoard3.remove(15);
        gameBoard3.add(15,'X');
        gameBoard3.remove(17);
        gameBoard3.add(17,'X');
        gameData3.setGameBoard(gameBoard3);
        //When
        boolean expectedResult = gameData.checkWin();
        boolean expectedResult2 = gameData2.checkWin();
        boolean expectedResult3 = gameData3.checkWin();
        //Then
        assertTrue(expectedResult);
        assertTrue(expectedResult2);
        assertTrue(expectedResult3);
    }
    @Test
    void testWinXInColumns(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'X');
        gameBoard.remove(7);
        gameBoard.add(7,'X');
        gameBoard.remove(13);
        gameBoard.add(13,'X');
        gameData.setGameBoard(gameBoard);
        gameData2 = new GameData();
        gameBoard2.remove(3);
        gameBoard2.add(3,'X');
        gameBoard2.remove(9);
        gameBoard2.add(9,'X');
        gameBoard2.remove(15);
        gameBoard2.add(15,'X');
        gameData2.setGameBoard(gameBoard2);
        gameData3 = new GameData();
        gameBoard3.remove(5);
        gameBoard3.add(5,'X');
        gameBoard3.remove(11);
        gameBoard3.add(11,'X');
        gameBoard3.remove(17);
        gameBoard3.add(17,'X');
        gameData3.setGameBoard(gameBoard3);
        //When
        boolean expectedResult = gameData.checkWin();
        boolean expectedResult2 = gameData2.checkWin();
        boolean expectedResult3 = gameData3.checkWin();
        //Then
        assertTrue(expectedResult);
        assertTrue(expectedResult2);
        assertTrue(expectedResult3);
    }
    @Test
    void testWinXInDiagonals(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'X');
        gameBoard.remove(9);
        gameBoard.add(9,'X');
        gameBoard.remove(17);
        gameBoard.add(17,'X');
        gameData.setGameBoard(gameBoard);
        gameData2 = new GameData();
        gameBoard2.remove(5);
        gameBoard2.add(5,'X');
        gameBoard2.remove(9);
        gameBoard2.add(9,'X');
        gameBoard2.remove(13);
        gameBoard2.add(13,'X');
        gameData2.setGameBoard(gameBoard2);
        //When
        boolean expectedResult = gameData.checkWin();
        boolean expectedResult2 = gameData2.checkWin();
        //Then
        assertTrue(expectedResult);
        assertTrue(expectedResult2);
    }
    @Test
    void testTie(){
        //Given
        gameData = new GameData();
        gameBoard.remove(1);
        gameBoard.add(1,'X');
        gameBoard.remove(3);
        gameBoard.add(3,'0');
        gameBoard.remove(5);
        gameBoard.add(5,'x');
        gameBoard.remove(7);
        gameBoard.add(7,'O');
        gameBoard.remove(9);
        gameBoard.add(9,'X');
        gameBoard.remove(11);
        gameBoard.add(11,'O');
        gameBoard.remove(13);
        gameBoard.add(13,'X');
        gameBoard.remove(15);
        gameBoard.add(15,'O');
        gameBoard.remove(17);
        gameBoard.add(17,'O');
        gameData.setGameBoard(gameBoard);
        //When
        boolean expectedResult = gameData.checkWin();
        //Then
        assertFalse(expectedResult);
    }
}
