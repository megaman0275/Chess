
package chess;

import java.awt.Color;
import java.awt.Graphics2D;

abstract public class Piece {
    protected int xpos;
    protected int ypos;
    protected boolean captured;
    protected boolean whiteTeam;
    protected Color color;
   
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
        if(whiteTeam)
            color = Color.blue;
        else 
            color = Color.red;
    }
    
    public void setWhiteTeam(boolean _whiteTeam){
        whiteTeam = _whiteTeam;
    }
    public Color getColor(){
        return color;
    }
    public void capturePiece(){
        captured = true;
        Board.board[xpos][ypos] = null;
        System.out.println("Piece Captured");
    }
    
    public boolean isCaptured(){
        return captured;
    }
    public int getXPos(){
        return xpos;
    }
    public int getYPos(){
        return ypos;
    }
    
    abstract protected void hilightGoodSpots();
    
    abstract protected void move(int x, int y);    
    
    abstract protected void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta);
}
