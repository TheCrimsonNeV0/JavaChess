public abstract class Piece {
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int color;
    abstract Position move(int from_x, int from_y, int to_x, int to_y);
}