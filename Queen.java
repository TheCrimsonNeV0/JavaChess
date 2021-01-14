public class Queen extends Piece{

    public Queen(boolean color){
        this.color = color;
    }

    // Move method

    @Override
    void move(int from_x, int from_y, int to_x, int to_y) throws InvalidMoveException {
        if (isPathAvailable(from_x, from_y, to_x, to_y)) {
            Board.chessBoardArray[from_x][from_y] = null;
            Board.chessBoardArray[to_x][to_y] = this;
        }
        else
            throw new InvalidMoveException();
    }

    // Simply iterate through the path to see if the specified path is available

    boolean isPathAvailable(int from_x, int from_y, int to_x, int to_y){
        int dif_x = to_x - from_x;
        int dif_y = to_y - from_y;
        int moveType = -1; // 0 -> rook 1 -> bishop

        moveType = Math.abs(dif_x) == Math.abs(dif_y) ? 0 : moveType;
        moveType = dif_x == 0 || dif_y == 0 ? 1 : moveType;

        switch (moveType){
            case 0:
                if (from_x < to_x) {        // right
                    for (int i = from_x+1; i < to_x; i++){
                        if (Board.chessBoardArray[i][from_y] != null){
                            return false;
                        }
                    }
                } else if (from_x > to_x) {       // left
                    for (int i = from_x-1; i > to_x; i--){
                        if (Board.chessBoardArray[i][from_y] != null){
                            return false;
                        }
                    }
                } else if (from_y < to_y){          // down
                    for (int i = from_y+1; i < to_y; i++){
                        if (Board.chessBoardArray[from_x][i] != null){
                            return false;
                        }
                    }
                } else if (from_y > to_y) {         // up
                    for (int i = from_y-1; i > to_y; i--){
                        if (Board.chessBoardArray[from_x][i] != null){
                            return false;
                        }
                    }
                }
                break;
            case 1:
                if (dif_x > 0 && dif_y < 0) {        // NE
                    for (int i = from_x+1, j = from_y-1; i < to_x; i++, j--){
                        if (Board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                else if (dif_x < 0 && dif_y < 0) {       // NW
                    for (int i = from_x-1, j = from_y-1; i > to_x; i--, j--){
                        if (Board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                else if (dif_x > 0 && dif_y > 0){          // SE
                    for (int i = from_x+1, j = from_y+1; i < to_x; i++, j++){
                        if (Board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                else if (dif_x < 0 && dif_y > 0) {         // SW
                    for (int i = from_x-1, j = from_y+1; i > to_x; i--, j++){
                        if (Board.chessBoardArray[i][j] != null){
                            return false;
                        }
                    }
                }
                break;
            case -1:
                return false;
        }

        // Check if the target color is different or the position is empty
        return Board.chessBoardArray[to_x][to_y] == null || Board.chessBoardArray[to_x][to_y].color != this.color;
    }
}
