public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Board.chessBoardArray[3][6] = new Queen(Piece.WHITE);
        //Board.chessBoardArray[4][6] = new Rook(Piece.BLACK);
        printboard();
        try {
            Board.chessBoardArray[3][6].move(3,6,5,6);
            printboard();
            Board.chessBoardArray[5][6].move(5,6,5,3);
            printboard();
            Board.chessBoardArray[5][3].move(5,3,3,5);
            printboard();
            Board.chessBoardArray[3][5].move(3,5,5,7);
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
        System.out.println("*******************");
    }
}
