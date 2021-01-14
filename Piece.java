public abstract class Piece {
    public static final boolean WHITE = false;
    public static final boolean BLACK = true;
    boolean color;
    abstract Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException;
}