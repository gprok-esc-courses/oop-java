package p06_tictactoe.refactored;

import p06_tictactoe.refactored.model.Game;
import p06_tictactoe.refactored.view.GameFrame;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        GameFrame frame;
        frame = new GameFrame(game);
    }
}
