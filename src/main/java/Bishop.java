package src.main.java;

import javax.swing.*;

//written by Selin Mergen
public class Bishop extends Piece{

    public Bishop(boolean color){
        this.color = color;
        moveCount = 0;
        whiteImageIcon = new ImageIcon("src/main/resources/white_bishop.png");
        blackImageIcon = new ImageIcon("src/main/resources/black_bishop.png");
    }

    // Simply iterate through the path to see if the specified path is available

    boolean isPathAvailable(Board board, int from_x, int from_y, int to_x, int to_y){
        int dif_x = to_x - from_x;
        int dif_y = to_y - from_y;

        if (Math.abs(dif_x) != Math.abs(dif_y))
            return false;

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
        else if (dif_x > 0 && dif_y > 0){          // SE
            for (int i = from_x+1, j = from_y+1; i < to_x; i++, j++){
                if (board.chessBoardArray[i][j] != null){
                    return false;
                }
            }
        }
        else if (dif_x < 0 && dif_y > 0) {         // SW
            for (int i = from_x-1, j = from_y+1; i > to_x; i--, j++){
                if (board.chessBoardArray[i][j] != null){
                    return false;
                }
            }
        }
        // Check if the target color is different or the position is empty
        boolean returnValue = board.chessBoardArray[to_x][to_y] == null || board.chessBoardArray[to_x][to_y].color != this.color;
        if (returnValue) moveCount++;
        return returnValue;
    }
}
