public class Pawn extends Piece {
    boolean hasMoved;
    boolean color;

    public Pawn(boolean color) {
        hasMoved = false;
        this.color = color;
    }

    Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (from_y == to_y) {
            return null;
        } else throw new InvalidMoveException();
    }
}