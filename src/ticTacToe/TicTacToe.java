package ticTacToe;

public class TicTacToe {
    private final Positions[][] gameBoard;

    private boolean isPlayerTurn;

    public TicTacToe() {
        gameBoard = new Positions[][] {
                {Positions.EMPTY, Positions.EMPTY, Positions.EMPTY},
                {Positions.EMPTY, Positions.EMPTY, Positions.EMPTY},
                {Positions.EMPTY, Positions.EMPTY, Positions.EMPTY}
        };
        isPlayerTurn = true;
    }


    public void makeMove(int position) throws Exception {
        int row = checkRow(position);
        int column = checkColumn(position);
        if (gameBoard[row][column].equals(Positions.EMPTY)) {
            gameBoard[row][column] = (isPlayerTurn) ? Positions.X : Positions.O;
            if (checkWinner()) {
                return;
            }
            if (isDraw()) {
                return;
            }
        } else throw new Exception("Position Already filled, please play in another position");
    }

    public void switchPlayerTurn() {
        isPlayerTurn = !isPlayerTurn;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    private int checkRow(int position) throws Exception{
        if (position > 0 && position < 4) return 0;
        else if (position > 3 && position < 7) return 1;
        else if (position > 6 && position < 10) return 2;
        throw new Exception("Incorrect Position");
    }

    private int checkColumn(int position) throws Exception{
        if (position > 0 && position < 4) return position-1;
        else if (position > 3 && position < 7) return position-4;
        else if (position > 6 && position < 10) return position-7;
        throw new Exception("Incorrect Position");
    }

    public boolean checkWinner(){
        return checkWinnerDiagonalLeft()
                || checkWinnerInRow()
                || checkWinnerInColumn()
                || checkWinnerDiagonalRight();
    }

    private boolean checkWinnerInRow() {
        for (int index = 0; index < 3; index++) {
            if (gameBoard[index][0] != Positions.EMPTY &&
                    gameBoard[index][0] == gameBoard[index][1] &&
                    gameBoard[index][1] == gameBoard[index][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerInColumn() {
        for (int index = 0; index < 3; index++) {
            if (gameBoard[0][index] != Positions.EMPTY &&
                    gameBoard[0][index] == gameBoard[1][index] &&
                    gameBoard[1][index] == gameBoard[2][index]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerDiagonalLeft() {
        return gameBoard[0][0] != Positions.EMPTY &&
                gameBoard[0][0] == gameBoard[1][1] &&
                gameBoard[1][1] == gameBoard[2][2];
    }

    private boolean checkWinnerDiagonalRight() {
        return gameBoard[0][2] != Positions.EMPTY &&
                gameBoard[0][2] == gameBoard[1][1] &&
                gameBoard[1][1] == gameBoard[2][0];
    }

    public boolean isDraw() {
        int emptyCount = 0;
        for (int index1 = 0; index1 < 3; index1++) {
            for (int index2 = 0; index2 < 3; index2++) {
                if (gameBoard[index1][index2] == Positions.EMPTY) {
                    emptyCount++;
                }
            }
        }
        return emptyCount == 0;
    }



    public Positions getGameBoard(int row, int column) {
        return gameBoard[row][column];
    }
    public Positions[][] getGameBoard() {
        return gameBoard;
    }

}
