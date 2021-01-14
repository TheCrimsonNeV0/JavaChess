public class Pawn extends Piece {
    boolean didMove;
    boolean hasMoved;
    boolean color;

    public Pawn(int color) {
        didMove = false;
    }

    Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (from_y == to_y) {
            return null;
        } else throw new InvalidMoveException();
    }
}