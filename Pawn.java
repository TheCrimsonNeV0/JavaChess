// Written by: Nevzat Umut Demirseren

import javax.swing.*;

public class Pawn extends Piece {
    boolean hasMoved;
    boolean color;

    public Pawn(boolean color) {
        hasMoved = false;
        this.color = color;
        whiteImageIcon = new ImageIcon("Images/white_pawn.png");
        blackImageIcon = new ImageIcon("Images/black_pawn.png");
    }

    void move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (isPathAvailable(from_x, from_y, to_x, to_y)) {
            Board.chessBoardArray[from_x][from_y] = null;
            Board.chessBoardArray[to_x][to_y] = this;
        }
        else throw new InvalidMoveException();
        this.hasMoved = true;
    }

    @Override
    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y) {
        boolean isAvailable = false;
        if (from_x == to_x) {
            if (color == Piece.WHITE && from_y == to_y + 1) {
                if (Board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
            else if (color == Piece.WHITE && from_y == to_y + 2 && !hasMoved) {
                if (Board.chessBoardArray[to_x][to_y - 1] == null && Board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
            else if (color == Piece.BLACK && from_y == to_y - 1) {
                if (Board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
            else if (color == Piece.BLACK && from_y == to_y - 2 && !hasMoved) {
                if (Board.chessBoardArray[to_x][to_y + 1] == null && Board.chessBoardArray[to_x][to_y] == null) isAvailable = true;
            }
        } else if (Math.abs(from_x - to_x) == 1) {
            if (color == Piece.WHITE && from_y == to_y + 1 && Board.chessBoardArray[to_x][to_y] != null && Board.chessBoardArray[to_x][to_y].color == Piece.BLACK) isAvailable = true;
            else if (color == Piece.BLACK && from_y == to_y - 1 && Board.chessBoardArray[to_x][to_y] != null && Board.chessBoardArray[to_x][to_y].color == Piece.WHITE) isAvailable = true;
        } else {
            return false;
        }

        return isAvailable;
    }
}