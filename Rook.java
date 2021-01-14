// Written by keremenci

public class Rook extends Piece{
    boolean hasMoved;
    public Rook(boolean color){
        this.color = color;
        this.hasMoved = false;
    }

    @Override
    Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (isPathAvailable(from_x,from_y,to_x,to_y)){
            System.out.println(" isPathAvailable(from_x,from_y,to_x,to_y) = " + isPathAvailable(from_x, from_y, to_x, to_y));
            Board.chessBoardArray[from_x][from_y] = null;
            Board.chessBoardArray[to_x][to_y] = this;
        }
        else throw new InvalidMoveException();
        this.hasMoved = true;
        return new Position(to_x,to_y);
    }

    @Override
    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y){
        if (from_x != to_x && from_y != to_y) return false;
        if (from_x < to_x) {        // right
            for (int i = from_x; i < to_x; i++){
                if (Board.chessBoardArray[i][from_y] == null){
                    return false;
                }
            }
        } else if (from_x > to_x) {       // left
            for (int i = from_x; i > to_x; i--){
                if (Board.chessBoardArray[i][from_y] == null){
                    return false;
                }
            }
        } else if (from_y < to_y){          // down
            for (int i = from_y; i < to_x; i++){
                if (Board.chessBoardArray[from_x][i] == null){
                    return false;
                }
            }
        } else if (from_y > to_y) {         // up
            for (int i = from_y; i > to_y; i--){
                if (Board.chessBoardArray[from_x][i] == null){
                    return false;
                }
            }
        }
        return true;
    }
}
