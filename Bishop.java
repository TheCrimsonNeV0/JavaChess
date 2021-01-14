//written by Selin Mergen
public class Bishop extends Piece{
    boolean hasMoved;
    public Bishop(boolean color){
        this.color = color;
        this.hasMoved = false;
    }

    @Override
    Position move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (isPathAvailable(from_x, from_y, to_x, to_y)){
            System.out.println(" isPathAvailable(from_x,from_y,to_x,to_y) = " + isPathAvailable(from_x, from_y, to_x, to_y));
            Board.chessBoardArray[from_x][from_y] = null;
            Board.chessBoardArray[to_x][to_y] = this;
        }
        else
            throw new InvalidMoveException();
        this.hasMoved = true;
        return new Position(to_x,to_y);
    }

    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y){
        int dif_x = to_x - from_x;
        int dif_y = to_y - from_y;

        if (Math.abs(dif_x) != Math.abs(dif_y))
            return false;

        if (dif_x > 0 && dif_y < 0) {        // NE
            for (int i = from_x+1, j = from_y+1; i < to_x; i++, j++){
                if (Board.chessBoardArray[i][j] != null){
                    return false;
                }
            }
            return Board.chessBoardArray[to_x][to_y] == null || Board.chessBoardArray[to_x][to_y].color != this.color;
        }
        else if (dif_x < 0 && dif_y < 0) {       // NW
            for (int i = from_x-1; i > to_x; i--){
                if (Board.chessBoardArray[i][from_y] != null){
                    System.out.println("siktir " + i);
                    return false;
                }
            }
            return Board.chessBoardArray[to_x][from_y] == null || Board.chessBoardArray[to_x][from_y].color != this.color;
        }
        else if (dif_x > 0 && dif_y > 0){          // SE
            for (int i = from_y+1; i < to_y; i++){
                if (Board.chessBoardArray[from_x][i] != null){
                    return false;
                }
            }
            return Board.chessBoardArray[from_x][to_y] == null || Board.chessBoardArray[from_x][to_y].color != this.color;
        }
        else if (dif_x < 0 && dif_y > 0) {         // SW
            for (int i = from_y-1; i > to_y; i--){
                if (Board.chessBoardArray[from_x][i] != null){
                    return false;
                }
            }
            return Board.chessBoardArray[from_x][to_y] == null || Board.chessBoardArray[from_x][to_y].color != this.color;
        }
        return true;
    }
}