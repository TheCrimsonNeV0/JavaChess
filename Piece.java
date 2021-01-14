//Written by Nevzat Umut Demirseren

public abstract class Piece {
    public static final boolean WHITE = false;      // Hold color value as a boolean since it is just a bit
    public static final boolean BLACK = true;
    boolean color;
    abstract void move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException;
    abstract boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y);
}