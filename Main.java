public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Board.chessBoardArray[3][6] = new Knight(Piece.WHITE);
        Board.chessBoardArray[5][5] = new Rook(Piece.BLACK);
        printboard();
        System.out.println("-----");
        try {
            Board.chessBoardArray[3][6].move(3,6,5,5);
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
