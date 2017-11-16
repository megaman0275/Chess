
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
    
    public void updatePossibleMoves(){
        possibleMoves.clear();
        
        //Testing UpRight Positions
        int testX = xpos + 1;
        int testY = ypos - 1;
        boolean pieceInWay = false;
        
        while(testX < Board.NUM_COLUMNS && testY >= 0 && !pieceInWay){
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
            testX++;
            testY--;
        }
        
        //Testing UpLeft Positions
        testX = xpos - 1;
        testY = ypos - 1;
        pieceInWay = false;
        
        while(testX >= 0 && testY >= 0 && !pieceInWay){
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
            testY--;
            testX--;
        }
        
        //Testing DownRight Positions
        testX = xpos + 1;
        testY = ypos + 1;
        pieceInWay = false;
        
        while(testX < Board.NUM_COLUMNS && testY < Board.NUM_ROWS && !pieceInWay){
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
            testX++;
            testY++;
        }
        
        //Testing DownLeft Positions
        testX = xpos - 1;
        testY = ypos + 1;
        pieceInWay = false;
        
        while(testX >=0 && testY < Board.NUM_ROWS && !pieceInWay){
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
            testX--;
            testY++;
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
