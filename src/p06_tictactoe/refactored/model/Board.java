package p06_tictactoe.refactored.model;

public class Board {
    private Cell [][] grid;

    public Board() {
        grid = new Cell[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void reset() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j].setValue(Cell.EMPTY);
            }
        }
    }

    public void play(int row, int col, int value) {
        grid[row][col].setValue(value);
    }

    public boolean hasWinner() {
        int v;
        for(int a = 0; a < 3; a++) {
            // Check row at a
            v = grid[a][0].getValue();
            if(v == grid[a][1].getValue() && v == grid[a][2].getValue() && v != Cell.EMPTY) {
                return true;
            }
            // Check column at a
            v = grid[0][a].getValue();
            if(v == grid[1][a].getValue() && v == grid[2][a].getValue() && v != Cell.EMPTY) {
                return true;
            }
        }
        // Check diagonals
        v = grid[1][1].getValue();
        if(v == grid[0][0].getValue() && v == grid[2][2].getValue() && v != Cell.EMPTY) {
            return true;
        }
        if(v == grid[0][2].getValue() && v == grid[2][0].getValue() && v != Cell.EMPTY) {
            return true;
        }
        return false;
    }

    public boolean isTie() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j].getValue() == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
