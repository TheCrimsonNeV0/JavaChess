package src.main.java;
//Written by Nevzat Umut Demirseren

import javax.swing.*;

public abstract class Piece {
    public static final boolean WHITE = false;      // Hold color value as a boolean since it is just a bit
    public static final boolean BLACK = true;
    ImageIcon whiteImageIcon;
    ImageIcon blackImageIcon;
    public boolean color;
    public int moveCount;
    abstract boolean isPathAvailable(Board board, int from_x, int from_y, int to_x, int to_y);
}
