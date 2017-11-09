
package chess;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Pawn extends Piece {
    boolean royalPawn;
    private ArrayList<Piece[][]> goodSpots = new ArrayList<Piece[][]>();

    Pawn(){
        super();
        royalPawn = false;
    }
    Pawn(int _xpos, int _ypos, boolean _whiteTeam){
       super(_xpos,_ypos,_whiteTeam);
       royalPawn = false;
    }

    public void hilightGoodSpots(){
        //for()
    }
// Glitch: clibking right inbetween two squares    
    public void move(int x, int y){
        xpos = x;
        ypos = y;
    }
    public void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta){
        g.setColor(color); 
        
//        if (!royalPawn){
//            g.setColor(Color.blue);
//            g.setFont(new Font("Arial",Font.PLAIN,30));
//            g.drawString("Pawn",Window.getX(column*xdelta)+15,
//            Window.getY(row*ydelta)+50);       
//        }
//        else{
            if (whiteTeam)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Pawn",Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50);
    }
    
}
