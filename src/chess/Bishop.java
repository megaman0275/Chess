
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;



public class Bishop extends Piece {

    Bishop(){
        super();
        
    }
    Bishop(int _xpos, int _ypos, boolean _whiteTeam){
       super(_xpos,_ypos,_whiteTeam);
       
    }
    
    public void hilightGoodSpots(){     
    }
    public void move(int x, int y){
        xpos = x;
        ypos = y;
    }
////////////////////////////////////////////////////////////////////////////////
//                             Draw Code                                      //
////////////////////////////////////////////////////////////////////////////////    
    public void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,Chess main){
        
        if(player == Player.Player1)
            drawWhiteBishopImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
        else
            drawBlackBishopImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
    }
    
//====================  Draw White Piece  ====================================//
    private void drawWhiteBishopImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.whiteBishopImage.getWidth(main);
        int height = main.whiteBishopImage.getHeight(main);
         
        g.drawImage(main.whiteBishopImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
//====================  Draw Black Piece  ====================================//
    private void drawBlackBishopImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.blackBishopImage.getWidth(main);
        int height = main.blackBishopImage.getHeight(main);
         
        g.drawImage(main.blackBishopImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
}
