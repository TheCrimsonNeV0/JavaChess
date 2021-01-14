public class Pawn extends Piece {
    boolean hasMoved;
    boolean color;

    public Pawn(boolean color) {
        hasMoved = false;
        this.color = color;
    }

    Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (from_y == to_y) {
            if (color) {
                if (from_x == to_x + 1) return new Position(to_x, to_y);
                else if (from_x == to_x + 2) {
                    if (!hasMoved) return new Position(to_x, to_y);
                    else throw new InvalidMoveException();
                }
                else throw new InvalidMoveException();
            }
            else {
                if (from_x == to_x - 1) return new Position(to_x, to_y);
                else if (from_x == to_x - 2) {
                    if (!hasMoved) return new Position(to_x, to_y);
                    else throw new InvalidMoveException();
                }
                else throw new InvalidMoveException();
            }
        } else throw new InvalidMoveException();
    }
}