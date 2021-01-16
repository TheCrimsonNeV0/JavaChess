public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        for (int i = 0; i < 8; i++) {
            b.chessBoardArray[i][1] = new Pawn(Piece.BLACK);
            b.chessBoardArray[i][6] = new Pawn(Piece.WHITE);
        }
        b.chessBoardArray[0][0] = new Rook(Piece.BLACK);
        b.chessBoardArray[7][0] = new Rook(Piece.BLACK);
        b.chessBoardArray[0][7] = new Rook(Piece.WHITE);
        b.chessBoardArray[7][7] = new Rook(Piece.WHITE);

        b.chessBoardArray[1][0] = new Knight(Piece.BLACK);
        b.chessBoardArray[6][0] = new Knight(Piece.BLACK);
        b.chessBoardArray[1][7] = new Knight(Piece.WHITE);
        b.chessBoardArray[6][7] = new Knight(Piece.WHITE);

        b.chessBoardArray[2][0] = new Bishop(Piece.BLACK);
        b.chessBoardArray[5][0] = new Bishop(Piece.BLACK);
        b.chessBoardArray[2][7] = new Bishop(Piece.WHITE);
        b.chessBoardArray[5][7] = new Bishop(Piece.WHITE);

        b.chessBoardArray[3][0] = new Queen(Piece.BLACK);
        b.chessBoardArray[3][7] = new Queen(Piece.WHITE);



        /*b.chessBoardArray[0][0] = new Bishop(Piece.BLACK);
        b.chessBoardArray[5][0] = new Bishop(Piece.BLACK);
        b.chessBoardArray[0][5] = new Bishop(Piece.WHITE);
        b.chessBoardArray[5][5] = new Bishop(Piece.WHITE);*/


        b.repaint();
        printboard(b);
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

    public static void printboard(Board b){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (b.chessBoardArray[j][i] == null) {
                    System.out.print("[ ]");
                } else if (b.chessBoardArray[j][i].color == Piece.WHITE) {
                    System.out.print("[X]");
                }
                else System.out.print("[O]");
            }
            System.out.println();
        }
        System.out.println("*******************");
    }
}
