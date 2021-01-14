//Written by: Nevzat Umut Demirseren

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    private Piece[][] chessBoardArray;
    public Board() {
        chessBoardArray = new Piece[8][8];
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setBackground(Color.orange);
        setVisible(true);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //g.drawLine(100 + 100 * i, 100, 100 + 100 * i, 900);
                //g.drawLine(100, 100 + 100 * i, 900, 100 + 100 * i);
                if ((i + j) % 2 == 0) g.setColor(Color.WHITE);
                else g.setColor(Color.BLACK);
                g.fillRect(100 + 100 * i, 100 + 100 * j, 100, 100);
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
