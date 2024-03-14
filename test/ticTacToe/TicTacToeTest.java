package ticTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ticTacToe.Positions;
import ticTacToe.TicTacToe;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    TicTacToe game;

    @BeforeEach
    public void initializeGame(){
        game = new TicTacToe();
    }

    @Test
    public void testThatPlayerCanMakeMoveToFirstPosition() throws Exception {
        game.makeMove(1);
        assertEquals(Positions.X, game.getGameBoard(0, 0));
    }

    @Test
    public void testThatPlayerCanMakeMoveToSecondPosition() throws Exception {
        game.makeMove(2);
        assertEquals(Positions.X, game.getGameBoard(0, 1));
    }

    @Test
    public void testThatPlayerCanMakeMoveToThirdPosition() throws Exception {
        game.makeMove(3);
        assertEquals(Positions.X, game.getGameBoard(0, 2));
    }

    @Test
    public void testThatPlayerCanMakeMoveToFourthPosition() throws Exception {
        game.makeMove(4);
        assertEquals(Positions.X, game.getGameBoard(1, 0));
    }

    @Test
    public void testThatPlayerCanMakeMoveToFifthPosition() throws Exception {
        game.makeMove(5);
        assertEquals(Positions.X, game.getGameBoard(1, 1));
    }

    @Test
    public void testThatPlayerCanMakeMoveToSixthPosition() throws Exception {
        game.makeMove(6);
        assertEquals(Positions.X, game.getGameBoard(1, 2));
    }

    @Test
    public void testThatPlayerCanMakeMoveToSeventhPosition() throws Exception {
        game.makeMove(7);
        assertEquals(Positions.X, game.getGameBoard(2, 0));
    }

    @Test
    public void testThatPlayerCanMakeMoveToEighthPosition() throws Exception {
        game.makeMove(8);
        assertEquals(Positions.X, game.getGameBoard(2, 1));
    }

    @Test
    public void testThatPlayerCanMakeMoveToLastPosition() throws Exception {
        game.makeMove(9);
        assertEquals(Positions.X, game.getGameBoard(2, 2));
    }

    @Test
    public void testThatBothPlayerCanMakeMove() throws Exception {
        game.makeMove(2);
        game.switchPlayerTurn();
        game.makeMove(9);
        assertEquals(Positions.X, game.getGameBoard(0, 1));
        assertEquals(Positions.O, game.getGameBoard(2, 2));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheFirstPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(1);
        assertEquals(Positions.O, game.getGameBoard(0, 0));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheSecondPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(2);
        assertEquals(Positions.O, game.getGameBoard(0, 1));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheThirdPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(3);
        assertEquals(Positions.O, game.getGameBoard(0, 2));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheFourthPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(4);
        assertEquals(Positions.O, game.getGameBoard(1, 0));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheFifthPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(5);
        assertEquals(Positions.O, game.getGameBoard(1, 1));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheSixthPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(6);
        assertEquals(Positions.O, game.getGameBoard(1, 2));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheSeventhPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(7);
        assertEquals(Positions.O, game.getGameBoard(2, 0));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheEighthPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(8);
        assertEquals(Positions.O, game.getGameBoard(2, 1));
    }

    @Test
    public void testThatSecondPlayerCanMoveToTheNinthPosition() throws Exception {
        game.switchPlayerTurn();
        game.makeMove(9);
        assertEquals(Positions.O, game.getGameBoard(2, 2));
    }

    @Test
    public void testThatWhenPlayerMakeTheWrongMove_ExceptionIsThrown(){
        assertThrows(Exception.class, ()-> game.makeMove(19));
        assertThrows(Exception.class, ()-> game.makeMove(-10));
        assertThrows(Exception.class, ()-> game.makeMove(Integer.parseInt("a")));
    }

    @Test
    public  void testThatPlayersCanWinInColumn1() throws Exception {
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(7);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinInColumn2() throws Exception {
        game.makeMove(2);
        game.makeMove(5);
        game.makeMove(8);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinInColumn3() throws Exception {
        game.makeMove(3);
        game.makeMove(6);
        game.makeMove(9);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinInRow() throws Exception {
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(3);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinInRow2() throws Exception {
        game.makeMove(4);
        game.makeMove(5);
        game.makeMove(6);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinInRow3() throws Exception {
        game.makeMove(7);
        game.makeMove(8);
        game.makeMove(9);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinDiagonal() throws Exception {
        game.makeMove(1);
        game.makeMove(5);
        game.makeMove(9);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanWinDiagonal2() throws Exception {
        game.makeMove(3);
        game.makeMove(5);
        game.makeMove(7);
        assertTrue(game.checkWinner());
    }

    @Test
    public  void testThatPlayersCanDraw() throws Exception {
        game.makeMove(1);
        game.switchPlayerTurn();
        game.makeMove(2);
        game.switchPlayerTurn();
        game.makeMove(6);
        game.switchPlayerTurn();
        game.makeMove(3);
        game.switchPlayerTurn();
        game.makeMove(5);
        game.switchPlayerTurn();
        game.makeMove(9);
        game.switchPlayerTurn();
        game.makeMove(4);
        game.switchPlayerTurn();
        game.makeMove(7);
        game.switchPlayerTurn();
        game.makeMove(8);
        assertTrue(game.isDraw());
    }

    @Test
    public void testThatPlayerCannotPlayOnATheSameCellTwice() throws Exception {
        game.makeMove(2);
        assertThrows(Exception.class, ()-> game.makeMove(2));
    }
}