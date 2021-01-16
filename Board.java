//Written by: Nevzat Umut Demirseren

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    public static Piece[][] chessBoardArray;
    Piece movingPiece;
    int movingPiece_x;
    int movingPiece_y;
    public Board() {
        chessBoardArray = new Piece[8][8];
        movingPiece = null;
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.orange);
        setVisible(true);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //g.drawLine(100 + 100 * i, 100, 100 + 100 * i, 900);
                //g.drawLine(100, 100 + 100 * i, 900, 100 + 100 * i);
                if ((i + j) % 2 == 0) g.setColor(Color.WHITE);
                else g.setColor(Color.DARK_GRAY);
                g.fillRect(100 + 100 * i, 100 + 100 * j, 100, 100);
                if (chessBoardArray[i][j] != null) {
                    if (chessBoardArray[i][j].color == Piece.WHITE) chessBoardArray[i][j].whiteImageIcon.paintIcon(this, g, 120 + 100 * i, 120 + 100 * j);
                    else chessBoardArray[i][j].blackImageIcon.paintIcon(this, g, 120 + 100 * i, 120 + 100 * j);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x_index;
        int y_index;

        //Calculates the x index of the moving piece
        if (e.getX() < 100) {
            x_index = 0;
        }
        else if (900 < e.getX()) {
            x_index = 7;
        }
        else {
            x_index = (e.getX() - 100) / 100;
        }

        //Calculates the y index of the moving piece
        if (e.getY() < 100) {
            y_index = 0;
        }
        else if (900 < e.getY()) {
            y_index = 7;
        }
        else {
            y_index = (e.getY() - 100) / 100;
        }

        movingPiece = chessBoardArray[x_index][y_index];
        movingPiece_x = x_index;
        movingPiece_y = y_index;

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
