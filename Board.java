//Written by: Nevzat Umut Demirseren

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    public static Piece[][] chessBoardArray;
    public Board() {
        chessBoardArray = new Piece[8][8];
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.orange);
        setVisible(true);
    }


    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //g.drawLine(100 + 100 * i, 100, 100 + 100 * i, 900);
                //g.drawLine(100, 100 + 100 * i, 900, 100 + 100 * i);
                if ((i + j) % 2 == 0) g.setColor(Color.WHITE);
                else g.setColor(Color.DARK_GRAY);
                g.fillRect(100 + 100 * i, 100 + 100 * j, 100, 100);
                if (chessBoardArray[i][j] != null) { // Prints the necessary images to board
                    if (chessBoardArray[i][j].color == Piece.WHITE) chessBoardArray[i][j].whiteImageIcon.paintIcon(this, g, 120 + 100 * i, 120 + 100 * j);
                    else chessBoardArray[i][j].blackImageIcon.paintIcon(this, g, 120 + 100 * i, 120 + 100 * j);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Board.chessBoardArray[3][6].move(3,6,2,5);
        } catch (InvalidMoveException invalidMoveException) {
            invalidMoveException.printStackTrace();
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { // Currently for test. Pawn takes the rook when clicked
        try {
            Board.chessBoardArray[3][6].move(3,6,2,5);
        } catch (InvalidMoveException invalidMoveException) {
            invalidMoveException.printStackTrace();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
