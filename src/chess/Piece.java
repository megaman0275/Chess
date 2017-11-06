
package chess;

import java.awt.Graphics2D;

abstract public class Piece {
    protected int xpos;
    protected int ypos;
    protected boolean captured;
    protected boolean whiteTeam;
   
    Piece(){
        xpos = 0;
        ypos = 0;
        captured = false;
        
    }
    Piece(int _xpos, int _ypos, boolean _whiteTeam){
        xpos = _xpos;
        ypos = _ypos;
        captured = false;
        whiteTeam = _whiteTeam;
    }
    public void setWhiteTeam(boolean _whiteTeam){
        whiteTeam = _whiteTeam;
    }
    
    abstract protected void move(int x, int y);    
    
    abstract protected void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta);
}
