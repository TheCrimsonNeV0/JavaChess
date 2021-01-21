package src.main.java;

// Written by Nevzat Umut Demirseren


import javax.swing.*;

public class King extends Piece {

    boolean hasMoved;           // for castling

    public King(boolean color) {
        this.color = color;
        this.hasMoved = false;
        whiteImageIcon = new ImageIcon("src/main/resources/white_king.png");
        blackImageIcon = new ImageIcon("src/main/resources/black_king.png");
    }

    @Override
    boolean isPathAvailable(Board board, int from_x, int from_y, int to_x, int to_y) {
        if (Math.abs(from_x - to_x) <= 1 && Math.abs(from_y - to_y) <= 1 && board.chessBoardArray[to_x][to_y] == null || this.color != board.chessBoardArray[to_x][to_y].color) {
            return true;
        }
        return false;
    }

}


