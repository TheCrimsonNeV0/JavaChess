//Written by Nevzat Umut Demirseren

import javax.swing.*;

public abstract class Piece {
    public static final boolean WHITE = false;      // Hold color value as a boolean since it is just a bit
    public static final boolean BLACK = true;
    ImageIcon whiteImageIcon;
    ImageIcon blackImageIcon;
    boolean color;
    abstract void move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException;
    abstract boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y);
}