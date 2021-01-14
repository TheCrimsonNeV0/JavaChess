public class Rook extends Piece{
    boolean hasMoved;
    public Rook(boolean color){
        this.color = color;
        this.hasMoved = false;
    }
    @Override
    Position move(int from_x, int from_y, int to_x, int to_y) {
        this.hasMoved = true;
        return null;
    }
}
