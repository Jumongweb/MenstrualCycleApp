package ticTacToe;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final TicTacToe game = new TicTacToe();
    public static void main(String[] args) {
        Scanner collector = new Scanner(System.in);
        displayBeforePlay();
        playGame(collector);
        collector.close();
    }


    private static void displayBeforePlay() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("""
            These are the playing positions:
             1 | 2 | 3
            -----------
             4 | 5 | 6
            -----------
             7 | 8 | 9
            """);
    }

    private static void playGame(Scanner collector) {
        while (true) {
            displayGame();
            System.out.println("Player " + (game.isPlayerTurn() ? 'X' : 'O') + "'s turn. Enter position (1-9):");
            int position;
            try {
                position = collector.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                collector.nextLine();
                continue;
            }
            try {
                game.makeMove(position);
            } catch (Exception e) {
                System.out.println(e.getMessage());

                continue;
            }
            if (game.checkWinner()) {
                displayGame();
                System.out.println("Player " + (game.isPlayerTurn() ? 'X' : 'O') + " wins!");
                break;
            }
            if (game.isDraw()) {
                displayGame();
                System.out.println("It's a draw!");
                break;
            }
            game.switchPlayerTurn();
        }
    }

    public static void displayGame() {
        System.out.println("________________");
        for (Positions[] row : game.getGameBoard()) {
            for (Positions position : row) {
                System.out.print(((position == Positions.EMPTY) ? " " : position.getValue()) + "      ");
            }
            System.out.println();
            System.out.println("________________");
        }
    }
}
