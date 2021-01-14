// Written by: Nevzat Umut Demirseren

public class Pawn extends Piece {
    boolean hasMoved;
    boolean color;

    public Pawn(boolean color) {
        hasMoved = false;
        this.color = color;
    }

    void move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (from_y == to_y) {
            if (color == Piece.WHITE) { //White
                if (from_x == to_x + 1) {
                    if (isPathAvailable(from_x, from_y, to_x, to_y)) {
                        hasMoved = true;
                    }
                    else throw new InvalidMoveException();
                }
                else if (from_x == to_x + 2) {
                    if (!hasMoved) {
                        if (isPathAvailable(from_x, from_y, to_x, to_y)) {
                            hasMoved = true;
                        }
                        else throw new InvalidMoveException();
                    }
                    else throw new InvalidMoveException();
                }
                else throw new InvalidMoveException();
            }
            else { //Black
                if (from_x == to_x - 2) {
                    if (hasMoved) throw new InvalidMoveException();
                }
                else throw new InvalidMoveException();
            }
        } else throw new InvalidMoveException();
    }

    @Override
    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y) {
        boolean isAvailable = true;
        if (color == Piece.WHITE) { //White
            for (int i = to_y; i <= from_y; i++) {
                if (Board.chessBoardArray[to_x][i] == null) {
                    isAvailable = false;
                    break;
                }
            }
        }
        else { //Black
            for (int i = from_y; i <= to_y; i++) {
                if (Board.chessBoardArray[to_x][i] == null) {
                    isAvailable = false;
                    break;
                }
            }
        }
        return isAvailable;
    }
}