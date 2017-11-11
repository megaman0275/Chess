//stop lying
package chess;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Chess extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    
    Image whiteKingImage;
    Image blackKingImage;
    
    Image whiteQueenImage;
    Image blackQueenImage;
    
    Image whiteBishopImage;
    Image blackBishopImage;
    
    Image whiteKnightImage;
    Image blackKnightImage;
    
    Image whiteRookImage;
    Image blackRookImage;
    
    Image whitePawnImage;
    Image blackPawnImage;

//    int numPieces = 16;
//    private ArrayList<Piece> piece = 
//    new ArrayList<Piece>(); 
    
    
    
    public static void main(String[] args) {
        Chess frame = new Chess();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Chess() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    Board.mouseSelectedPiece(e.getX(), e.getY());
                }

                if (e.BUTTON3 == e.getButton()) {

                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.gray);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        int ydelta = Window.getHeight2()/Board.NUM_ROWS;
        int xdelta = Window.getWidth2()/Board.NUM_COLUMNS;
        
       
        
        Board.Draw(g,this);
        

        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        
        Player.Reset();
        Board.Reset();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            
            whiteKingImage = Toolkit.getDefaultToolkit().getImage("./White_King.GIF");
            blackKingImage = Toolkit.getDefaultToolkit().getImage("./Black_King.GIF");
            
            whiteQueenImage = Toolkit.getDefaultToolkit().getImage("./White_Queen.GIF");
            blackQueenImage = Toolkit.getDefaultToolkit().getImage("./Black_Queen.GIF");
            
            whiteBishopImage = Toolkit.getDefaultToolkit().getImage("./White_Bishop.GIF");
            blackBishopImage = Toolkit.getDefaultToolkit().getImage("./Black_Bishop.GIF");
            
            whiteKnightImage = Toolkit.getDefaultToolkit().getImage("./White_Knight.GIF");
            blackKnightImage = Toolkit.getDefaultToolkit().getImage("./Black_Knight.GIF");
            
            whiteRookImage = Toolkit.getDefaultToolkit().getImage("./White_Rook.GIF");
            blackRookImage = Toolkit.getDefaultToolkit().getImage("./Black_Rook.GIF");
            
            whitePawnImage = Toolkit.getDefaultToolkit().getImage("./White_Pawn.GIF");
            blackPawnImage = Toolkit.getDefaultToolkit().getImage("./Black_Pawn.GIF");

            reset();

        }

        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}

