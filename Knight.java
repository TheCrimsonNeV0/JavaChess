import javax.swing.*;

//written by Selin Mergen
public class Knight extends Piece{

    public Knight(boolean color) {
        this.color = color;
        whiteImageIcon = new ImageIcon("Images/white_knight.png");
        blackImageIcon = new ImageIcon("Images/black_knight.png");
    }

    // Move method

    @Override
    void move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (isPathAvailable(from_x, from_y, to_x, to_y)) {
            Board.chessBoardArray[from_x][from_y] = null;
            Board.chessBoardArray[to_x][to_y] = this;
        }
        else
            throw new InvalidMoveException();
    }

    // Simply iterate through the path to see if the specified path is available

    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y){
        int dif_x = to_x - from_x;
        int dif_y = to_y - from_y;

        if (!(Math.abs(dif_x) == 1 && Math.abs(dif_y) == 2) && !(Math.abs(dif_x) == 2 && Math.abs(dif_y) == 1))
            return false;

        // Check if the target color is different or the position is empty
        return Board.chessBoardArray[to_x][to_y] == null || Board.chessBoardArray[to_x][to_y].color != this.color;
    }
}
