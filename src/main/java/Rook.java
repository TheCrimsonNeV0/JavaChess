package src.main.java;

// Written by keremenci

import javax.swing.*;

public class Rook extends Piece{
    boolean hasMoved;           // for castling

    // Constructor

    public Rook(boolean color) {
        this.hasMoved = false;
        this.color = color;
        whiteImageIcon = new ImageIcon("src/main/resources/white_rook.png");
        blackImageIcon = new ImageIcon("src/main/resources/black_rook.png");
    }

    // Simply iterate through the path to see if the specified path is available

    @Override
    boolean isPathAvailable(Board board, int from_x, int from_y, int to_x, int to_y){
        if ((to_x < 0 || 7 < to_x || to_y < 0 || 7 < to_y) && from_x != to_x && from_y != to_y) return false;

        if (from_x < to_x) {        // right
            for (int i = from_x+1; i < to_x; i++){
                if (board.chessBoardArray[i][from_y] != null){
                    return false;
                }
            }
        } else if (from_x > to_x) {       // left
            for (int i = from_x-1; i > to_x; i--){
                if (board.chessBoardArray[i][from_y] != null){
                    return false;
                }
            }
        } else if (from_y < to_y){          // down
            for (int i = from_y+1; i < to_y; i++){
                if (board.chessBoardArray[from_x][i] != null){
                    return false;
                }
            }
        } else if (from_y > to_y) {         // up
            for (int i = from_y-1; i > to_y; i--){
                if (board.chessBoardArray[from_x][i] != null){
                    return false;
                }
            }
        }
        // Check if the target color is different or the position is empty
        return board.chessBoardArray[to_x][to_y] == null || board.chessBoardArray[to_x][to_y].color != this.color;
    }
}
