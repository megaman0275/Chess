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
    Pawn(int _xpos, int _ypos, boolean _whiteTeam, boolean _royalPawn){
       super(_xpos,_ypos,_whiteTeam);
       royalPawn = _royalPawn;
    }

// Glitch: clibking right inbetween two squares    
    public void move(int x, int y){
        xpos = x;
        ypos = y;
        numMoves++;
    }
    public boolean checkIfGoodMove(int _xpos, int _ypos){
        for(Bucket move : possibleMoves){
            if(_xpos == move.xpos && _ypos == move.ypos)
                return true;
        }
        return false;
    }
    
    public void updatePossibleMoves(){
        possibleMoves.clear();
       
        if(player == Player.Player1)
            if (royalPawn)
                updateWhiteCap();
            else
                updateWhite();
        else
            if (royalPawn)
                updateBlackCap();
            else
                updateBlack();
    }
    private void updateWhite(){
        int testX = xpos;
        int testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
            if(numMoves == 0 && Board.board[testX][testY-1] == null){
                possibleMoves.add(new Bucket(testX, testY-1));
            }
        }
        
        testX = xpos - 1;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] != null){
            if(Board.board[testX][testY].getPlayer() != player)
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] != null){
            if(Board.board[testX][testY].getPlayer() != player)
            possibleMoves.add(new Bucket(testX, testY));
        }
    }
    private void updateBlack(){
        int testX = xpos;
        int testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
            if(numMoves == 0 && Board.board[testX][testY+1] == null){
                possibleMoves.add(new Bucket(testX, testY+1));
            }
        }
        
        testX = xpos - 1;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] != null){
            if(Board.board[testX][testY].getPlayer() != player)
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] != null){
            if(Board.board[testX][testY].getPlayer() != player)
            possibleMoves.add(new Bucket(testX, testY));
        }
    }
    private void updateWhiteCap(){
        int testX = xpos;
        int testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 1;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
    }
    private void updateBlackCap(){
        int testX = xpos;
        int testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 1;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
    }
////////////////////////////////////////////////////////////////////////////////
//                             Draw Code                                      //
////////////////////////////////////////////////////////////////////////////////    
    public void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,Chess main){
        
        if(player == Player.Player1)
            drawWhitePawnImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
        else
            drawBlackPawnImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
    }
    
//====================  Draw White Piece  ====================================//
    private void drawWhitePawnImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.whitePawnImage.getWidth(main);
        int height = main.whitePawnImage.getHeight(main);
         
        g.drawImage(main.whitePawnImage,0,-height/2,width,height,main);       
        if (royalPawn){
            g.setColor(Color.BLACK);
            g.drawLine(height-28, -width/2+10, height-28, width/2-10);
        }
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
//====================  Draw Black Piece  ====================================//
    private void drawBlackPawnImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.blackPawnImage.getWidth(main);
        int height = main.blackPawnImage.getHeight(main);
         
        g.drawImage(main.blackPawnImage,0,-height/2,width,height,main);        
        if (royalPawn){
            g.setColor(Color.white);
            g.drawLine(height-28, -width/2+10, height-28, width/2-10);
        }
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
}
