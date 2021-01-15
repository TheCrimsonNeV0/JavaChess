public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        for (int i = 0; i < 8; i++) {
            Board.chessBoardArray[i][6] = new Pawn(Piece.WHITE);
        }
        Board.chessBoardArray[2][5] = new Rook(Piece.BLACK);


        b.repaint(); // Prints the pieces to the board
        printboard();
        /*try {

            //printboard();
            //Thread.sleep(500000000);
            b.repaint();
            /*Board.chessBoardArray[5][6].move(5,6,5,3);
            printboard();
            Board.chessBoardArray[5][3].move(5,3,3,5);
            printboard();
            Board.chessBoardArray[3][5].move(3,5,5,7);
            printboard();
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }*/
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
