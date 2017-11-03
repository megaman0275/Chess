
package chess;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Pawn extends Piece {
    boolean royalPawn;
    private Color color;

    Pawn(){
        super();
        royalPawn = false;
    }
    Pawn(int _xpos, int _ypos, boolean _whiteTeam){
       super(_xpos,_ypos,_whiteTeam);
       royalPawn = false;
    }
    
    public void Move(){
        
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
            g.drawString("Pawn",Window.getX(column*xdelta)+15,
            Window.getY(row*ydelta)+50);       
        }
    
}
