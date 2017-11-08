
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class King extends Piece {

    King(){
        super();
        
    }
    King(int _xpos, int _ypos,boolean _whiteTeam){
       super(_xpos,_ypos,_whiteTeam);
       
    }
    
    public void move(int x, int y){
        xpos = x;
        ypos = y;
    }
    public void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta){
        g.setColor(color); 
        
        if (whiteTeam)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        g.drawString("King",Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50);       
    }
}

