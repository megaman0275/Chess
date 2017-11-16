

package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Knight extends Piece {

    Knight(){
        super();
        
    }
    Knight(int _xpos, int _ypos,  boolean _whiteTeam){
       super(_xpos,_ypos,_whiteTeam);
       
    }
    
    public void updatePossibleMoves(){
         possibleMoves.clear();
       
       int testX = xpos + 2;
        int testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 2;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos - 2;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos + 2;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));          
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 2;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 2;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 1;
        testY = ypos + 2;
        if(testY >= 0 & testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 1;
        testY = ypos - 2;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));          
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
    }
   
    public boolean checkIfGoodMove(int _xpos, int _ypos){
        for(Bucket move : possibleMoves){
            if(_xpos == move.xpos && _ypos == move.ypos)
                return true;
        }
        return false;
    }
    public void move(int x, int y){
        xpos = x;
        ypos = y;
        numMoves++;
    }
////////////////////////////////////////////////////////////////////////////////
//                             Draw Code                                      //
////////////////////////////////////////////////////////////////////////////////    
    public void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,Chess main){
        
        if(player == Player.Player1)
            drawWhiteKnightImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
        else
            drawBlackKnightImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
    }
    
//====================  Draw White Piece  ====================================//
    private void drawWhiteKnightImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.whiteKnightImage.getWidth(main);
        int height = main.whiteKnightImage.getHeight(main);
         
        g.drawImage(main.whiteKnightImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
//====================  Draw Black Piece  ====================================//
    private void drawBlackKnightImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.blackKnightImage.getWidth(main);
        int height = main.blackKnightImage.getHeight(main);
         
        g.drawImage(main.blackKnightImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
}
