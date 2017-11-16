
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
    
    public void updatePossibleMoves(){
        possibleMoves.clear();
       
        int testX = xpos + 1;
        int testY = ypos;
        if(numMoves == 0){
            if(Board.board[testX][testY] == null && Board.board[testX + 1][testY] == null){
                possibleMoves.add(new Bucket(testX + 1,testY));
                System.out.println("[" + testX + "][" + testY + "]");
            }
            testX = xpos - 1;
            if(Board.board[testX][testY] == null && Board.board[testX - 1][testY] == null){
                possibleMoves.add(new Bucket(testX - 1,testY));
                System.out.println("[" + testX + "][" + testY + "]");
            }
        }
            
        testX = xpos + 1;
        testY = ypos +1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos -1;
        testY = ypos + 1;
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
        
        testX = xpos - 1;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));          
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos;
        testY = ypos + 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos;
        testY = ypos - 1;
        if(testY >= 0 && testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos - 1;
        testY = ypos;
        if(testY >= 0 & testY < Board.NUM_ROWS && testX >= 0 && testX < Board.NUM_COLUMNS)
        if(Board.board[testX][testY] == null){
            possibleMoves.add(new Bucket(testX, testY));
        }
        else if(Board.board[testX][testY].getPlayer() != player){
            possibleMoves.add(new Bucket(testX, testY));
        }
        
        testX = xpos + 1;
        testY = ypos;
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
        if(numMoves == 0){
            if(player == Player.Player1){
                if(xpos == 6 && ypos == 7){
                    Board.rook2W.move(5,7);
                }else if(xpos == 2 && ypos == 7){
                    Board.rook1W.move(3,7);
                }
            }else{
                if(xpos == 6 && ypos == 0){
                    Board.rook1B.move(5,0);
                }else if(xpos == 2 && ypos == 0){
                    Board.rook2B.move(3,0);
                }
            }
        }
        numMoves++;
    }
////////////////////////////////////////////////////////////////////////////////
//                             Draw Code                                      //
////////////////////////////////////////////////////////////////////////////////    
    public void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,Chess main){
        
        if(player == Player.Player1)
            drawWhiteKingImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
        else
            drawBlackKingImage(g,Window.getX(xpos*xdelta)+15,
            Window.getY(ypos*ydelta)+50,
            0,1.1,1.1,main);
    }
    
//====================  Draw White Piece  ====================================//
    private void drawWhiteKingImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.whiteKingImage.getWidth(main);
        int height = main.whiteKingImage.getHeight(main);
         
        g.drawImage(main.whiteKingImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
//====================  Draw Black Piece  ====================================//
    private void drawBlackKingImage(Graphics2D g,int xpos,int ypos,
    double rot,double xscale,double yscale,Chess main)
    {
        g.translate(xpos,ypos);
        g.scale( xscale , yscale );

        int width = main.blackKingImage.getWidth(main);
        int height = main.blackKingImage.getHeight(main);
         
        g.drawImage(main.blackKingImage,0,-height/2,width,height,main);        
     
        g.scale( 1.0/xscale,1.0/yscale );
        g.translate(-xpos,-ypos);
    }
}

