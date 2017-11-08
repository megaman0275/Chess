
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Queen extends Piece {

    Queen(){
        super();
        
    }
    Queen(int _xpos, int _ypos, boolean _whiteTeam){
       super(_xpos,_ypos, _whiteTeam);
       
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
        g.drawString("Queen",Window.getX(xpos*xdelta)+15,
        Window.getY(ypos*ydelta)+50);       
    }
}
