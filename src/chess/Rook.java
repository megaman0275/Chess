
package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class Rook  extends Piece{

    Rook(){
        super();
        
    }
    Rook(int _xpos, int _ypos,  boolean _whiteTeam){
       super(_xpos,_ypos,_whiteTeam);
       
    }
    
    public void updatePossibleMoves(){
        possibleMoves.clear();
        
        //Testing Up Positions
        int testX = xpos;
        int testY = ypos - 1;
        boolean pieceInWay = false;
        
        while(testY >=0 && !pieceInWay){
            if(Board.board[testX][testY] == null){
                possibleMoves.add(new Bucket(testX,testY));
            }
            else if(Board.board[testX][testY].getPlayer() != player){
                possibleMoves.add(new Bucket(testX,testY));
                pieceInWay = true;
            }
            else if(Board.board[testX][testY].getPlayer() == player){
                pieceInWay = true;
            }
            testY -= 1;
        }
        
        //Testing Down Positions
        testX = xpos;
        testY = ypos + 1;
        pieceInWay = false;
        
        while(testY < Board.NUM_ROWS && !pieceInWay){
            if(Board.board[testX][testY] == null){
                possibleMoves.add(new Bucket(testX,testY));
            }
            else if(Board.board[testX][testY].getPlayer() != player){
                possibleMoves.add(new Bucket(testX,testY));
                pieceInWay = true;
            }
            else if(Board.board[testX][testY].getPlayer() == player){
                pieceInWay = true;
            }
            testY += 1;
        }
        
        //Testing Right Positions
        testX = xpos + 1;
        testY = ypos;
        pieceInWay = false;
        
        while(testX < Board.NUM_COLUMNS && !pieceInWay){
            if(Board.board[testX][testY] == null){
                possibleMoves.add(new Bucket(testX,testY));
            }
            else if(Board.board[testX][testY].getPlayer() != player){
                possibleMoves.add(new Bucket(testX,testY));
                pieceInWay = true;
            }
            else if(Board.board[testX][testY].getPlayer() == player){
                pieceInWay = true;
            }
            testX += 1;
        }
        
        //Testing Left Positions
        testX = xpos - 1;
        testY = ypos;
        pieceInWay = false;
        
        while(testX >= 0 && !pieceInWay){
            if(Board.board[testX][testY] == null){
                possibleMoves.add(new Bucket(testX,testY));
            }
            else if(Board.board[testX][testY].getPlayer() != player){
                possibleMoves.add(new Bucket(testX,testY));
                pieceInWay = true;
            }
            else if(Board.board[testX][testY].getPlayer() == player){
                pieceInWay = true;
            }
            testX -= 1;
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
            drawWhiteRookImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
        else
            drawBlackRookImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
    }
    
//====================  Draw White Piece  ====================================//
    private void drawWhiteRookImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.whiteRookImage.getWidth(main);
        int height = main.whiteRookImage.getHeight(main);
         
        g.drawImage(main.whiteRookImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
//====================  Draw Black Piece  ====================================//
    private void drawBlackRookImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.blackRookImage.getWidth(main);
        int height = main.blackRookImage.getHeight(main);
         
        g.drawImage(main.blackRookImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
}
