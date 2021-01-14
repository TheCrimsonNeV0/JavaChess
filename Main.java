public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Board.chessBoardArray[5][4] = new Rook(Piece.WHITE);
        Board.chessBoardArray[2][4] = new Rook(Piece.WHITE);
        printboard();
        try {
            Board.chessBoardArray[5][4].move(5,4,2,4);
            printboard();
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
    }

    public static void printboard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board.chessBoardArray[j][i] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
    }
}
