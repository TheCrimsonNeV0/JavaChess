package src.main.java;

//Written by: Nevzat Umut Demirseren

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    public Piece[][] chessBoardArray;
    Piece movingPiece;
    int movingPiece_x;
    int movingPiece_y;

    int current_x;
    int current_y;

    public Board() {
        chessBoardArray = new Piece[8][8];
        movingPiece = null;
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Chess");
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.ORANGE);
        setVisible(true);
    }

    public void replacePawnWithQueen() {
        class NewPieceSelection extends JFrame implements MouseListener {
            int x;
            int y;
            public NewPieceSelection(int x, int y) {
                this.x = x;
                this.y = y;
                setSize(600, 200);
                setBackground(Color.CYAN);
                setResizable(false);
                addMouseListener(this);
                setVisible(true);
            }

            @Override
            public void paint(Graphics g) {
                for (int i = 0; i < 4; i++) {
                    if (i % 2 == 0) g.setColor(Color.WHITE);
                    else g.setColor(Color.BLACK);

                    g.fillRect(100 + 100 * i, 60, 100, 100);
                }

                new Rook(Piece.WHITE).whiteImageIcon.paintIcon(this, g, 120, 80);
                new Knight(Piece.WHITE).whiteImageIcon.paintIcon(this, g, 220, 80);
                new Bishop(Piece.WHITE).whiteImageIcon.paintIcon(this, g, 320, 80);
                new Queen(Piece.WHITE).whiteImageIcon.paintIcon(this, g, 420, 80);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int xPosition = e.getX();
                int yPosition = e.getY();

                if (60 <= yPosition && yPosition <= 155) {
                    if (100 <= xPosition && xPosition < 200) {
                        chessBoardArray[x][y] = new Rook(Piece.WHITE);
                        dispose();
                    }
                    else if (200 <= xPosition && xPosition < 300) {
                        chessBoardArray[x][y] = new Knight(Piece.WHITE);
                        dispose();
                    }
                    else if (300 <= xPosition && xPosition < 400) {
                        chessBoardArray[x][y] = new Bishop(Piece.WHITE);
                        dispose();
                    }
                    else if (400 <= xPosition && xPosition < 500) {
                        chessBoardArray[x][y] = new Queen(Piece.WHITE);
                        dispose();
                    }
                }
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
        }
        for (int i = 0; i < chessBoardArray.length; i++) {
            if (chessBoardArray[i][0] != null && chessBoardArray[i][0].getClass().getSimpleName().equals("Pawn") && chessBoardArray[i][0].color == Piece.WHITE) {
                NewPieceSelection whitePieceSelection = new NewPieceSelection(i, 0);

            }
            if (chessBoardArray[i][7] != null && chessBoardArray[i][7].getClass().getSimpleName().equals("Pawn") && chessBoardArray[i][7].color == Piece.BLACK) {
                chessBoardArray[i][7] = new Queen(Piece.BLACK);
            }
        }
    }

    public void fillBackground(Graphics g) {
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

    public void paint(Graphics g) {
        fillBackground(g);
        if (movingPiece != null) {
            if (movingPiece.color == Piece.WHITE) {
                movingPiece.whiteImageIcon.paintIcon(this, g, current_x - 30, current_y - 30);
            }
            else movingPiece.blackImageIcon.paintIcon(this, g, current_x - 30, current_y - 30);
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
        //Calculates the y index of the moving piece

        if (100 <= e.getX() && e.getX() <= 900 && 100 <= e.getY() && e.getY() <= 900) {
            x_index = (e.getX() - 100) / 100;
            y_index = (e.getY() - 100) / 100;
            movingPiece = chessBoardArray[x_index][y_index];
            movingPiece_x = x_index;
            movingPiece_y = y_index;

            chessBoardArray[x_index][y_index] = null;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int destination_x;
        int destination_y;

        if (e.getX() < 100) {
            destination_x = 0;
        }
        else if (900 < e.getX()) {
            destination_x = 7;
        }
        else {
            destination_x = (e.getX() - 100) / 100;
        }

        if (e.getY() < 100) {
            destination_y = 0;
        }
        else if (900 < e.getY()) {
            destination_y = 7;
        }
        else {
            destination_y = (e.getY() - 100) / 100;
        }

        if (movingPiece != null) {
            if (movingPiece.isPathAvailable(this, movingPiece_x, movingPiece_y, destination_x, destination_y)) {
                chessBoardArray[destination_x][destination_y] = movingPiece;
                chessBoardArray[movingPiece_x][movingPiece_y] = null;
            } else {
                chessBoardArray[movingPiece_x][movingPiece_y] = movingPiece;
            }
            movingPiece = null;
        }
        replacePawnWithQueen();
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (movingPiece != null && 130 <= e.getX() && e.getX() <= 870 && 130 <= e.getY() && e.getY() <= 870) {
            current_x = e.getX();
            current_y = e.getY();
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}