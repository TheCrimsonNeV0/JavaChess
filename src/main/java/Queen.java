package src.main.java;

import javax.swing.*;

public class Queen extends Piece{

    public Queen(boolean color) {
        this.color = color;
        moveCount = 0;
        whiteImageIcon = new ImageIcon("src/main/resources/white_queen.png");
        blackImageIcon = new ImageIcon("src/main/resources/black_queen.png");
    }

    // Simply iterate through the path to see if the specified path is available

    boolean isPathAvailable(Board board, int from_x, int from_y, int to_x, int to_y){
        int dif_x = to_x - from_x;
        int dif_y = to_y - from_y;
        int moveType = -1; // 0 -> rook 1 -> bishop

        moveType = dif_x == 0 || dif_y == 0 ? 0 : moveType;
        moveType = Math.abs(dif_x) == Math.abs(dif_y) ? 1 : moveType;

        switch (moveType){
            case 0:
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
                break;
            case 1:
                if (dif_x > 0 && dif_y < 0) {        // NE
                    for (int i = from_x+1, j = from_y-1; i < to_x; i++, j--){
                        if (board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                else if (dif_x < 0 && dif_y < 0) {       // NW
                    for (int i = from_x-1, j = from_y-1; i > to_x; i--, j--){
                        if (board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                else if (dif_x > 0){          // SE
                    for (int i = from_x+1, j = from_y+1; i < to_x; i++, j++){
                        if (board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                else if (dif_x < 0) {         // SW
                    for (int i = from_x-1, j = from_y+1; i > to_x; i--, j++){
                        if (board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                break;
            case -1:
                return false;
        }

        // Check if the target color is different or the position is empty
        boolean returnValue = board.chessBoardArray[to_x][to_y] == null || board.chessBoardArray[to_x][to_y].color != this.color;
        if (returnValue) moveCount++;
        return returnValue;
    }
}
