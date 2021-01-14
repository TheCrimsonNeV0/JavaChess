public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        Board.chessBoardArray[1][1] = new Pawn(Piece.BLACK);
        //Board.chessBoardArray[2][4] = new Pawn(Piece.WHITE);
        printboard();
        System.out.println("=======================");
        try {
            Board.chessBoardArray[1][1].move(1,1,1,2);
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
