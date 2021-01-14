// Written by: Nevzat Umut Demirseren

public class Pawn extends Piece {
    boolean hasMoved;
    boolean color;

    public Pawn(boolean color) {
        hasMoved = false;
        this.color = color;
    }

    Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (from_y == to_y) {
            if (color == Piece.WHITE) { //White
                if (from_x == to_x + 1) return new Position(to_x, to_y);
                else if (from_x == to_x + 2) {
                    if (!hasMoved) return new Position(to_x, to_y);
                    else throw new InvalidMoveException();
                }
                else throw new InvalidMoveException();
            }
            else { //Black
                if (from_x == to_x - 1) return new Position(to_x, to_y);
                else if (from_x == to_x - 2) {
                    if (!hasMoved) return new Position(to_x, to_y);
                    else throw new InvalidMoveException();
                }
                else throw new InvalidMoveException();
            }
        } else throw new InvalidMoveException();
    }

    @Override
    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y) {
        boolean isAvailable = true;
        if (color == Piece.WHITE) { //White
            if ()
        }
        else { //

        }
        return isAvailable;
    }
}