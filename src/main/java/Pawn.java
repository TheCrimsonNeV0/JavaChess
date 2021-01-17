package src.main.java;
// Written by: Nevzat Umut Demirseren

import javax.swing.*;

public class Pawn extends Piece {
    boolean hasMoved;

    public Pawn(boolean color) {
        hasMoved = false;
        this.color = color;
        whiteImageIcon = new ImageIcon("src/main/resources/white_pawn.png");
        blackImageIcon = new ImageIcon("src/main/resources/black_pawn.png");
    }

    @Override
    boolean isPathAvailable(Board board, int from_x, int from_y, int to_x, int to_y) {
        boolean isAvailable = false;
        if (from_x == to_x) {
            if (color == Piece.WHITE && from_y == to_y + 1) {
                if (board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
            else if (color == Piece.WHITE && from_y == to_y + 2 && !hasMoved) {
                if (board.chessBoardArray[to_x][to_y - 1] == null && board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
            else if (color == Piece.BLACK && from_y == to_y - 1) {
                if (board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
            else if (color == Piece.BLACK && from_y == to_y - 2 && !hasMoved) {
                if (board.chessBoardArray[to_x][to_y + 1] == null && board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
        } else if (Math.abs(from_x - to_x) == 1) {
            if (color == Piece.WHITE && from_y == to_y + 1 && board.chessBoardArray[to_x][to_y] != null && board.chessBoardArray[to_x][to_y].color == Piece.BLACK) isAvailable = true;
            else if (color == Piece.BLACK && from_y == to_y - 1 && board.chessBoardArray[to_x][to_y] != null && board.chessBoardArray[to_x][to_y].color == Piece.WHITE) isAvailable = true;
        } else {
            return false;
        }

        if (isAvailable) hasMoved = true;
        return isAvailable;
    }
}
