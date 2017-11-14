
package chess;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

abstract public class Piece {
    protected static ArrayList<Piece> allPieces = new ArrayList<Piece>();
    protected static ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    protected  static ArrayList<Piece> blackPieces = new ArrayList<Piece>();
    protected ArrayList<Bucket> possibleMoves = new ArrayList<Bucket>();
    public enum Player{
        Player1, Player2;
    }
    protected int xpos;
    protected int ypos;
    protected boolean captured;
    protected boolean whiteTeam;
    protected Color color;
    protected boolean firstMove;
    Player player;
   
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
        firstMove = true;
        if(whiteTeam){
            player = Player.Player1;
            color = Color.blue;
            whitePieces.add(this);
        }
        else {
            player = Player.Player2;
            color = Color.red;
            blackPieces.add(this);
        }
        allPieces.add(this);
    }
    
    public static void checkForWhiteKingCheck(){
        boolean inCheck = false;
        for(Piece piece : blackPieces){
            for(Bucket loc : piece.getPossibleMovesArray()){
                if(Board.kingW == Board.board[loc.xpos][loc.ypos]){
                    System.out.println("==  White King in Check ==");
                    inCheck = true;
                }
            }
        }
        if(!inCheck)
            System.out.println("No Check");
    }
    public static void checkForBlackKingCheck(){
        boolean inCheck = false;
        for(Piece piece : whitePieces){
            for(Bucket loc : piece.getPossibleMovesArray()){
                if(Board.kingB == Board.board[loc.xpos][loc.ypos]){
                    System.out.println("==  Black King in Check ==");
                    inCheck = true;
                }
            }
        }
        if(!inCheck)
            System.out.println("No Check");
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
    }
    public static void UpdateAllPiecesPossibleMoves(){
        for(Piece piece : allPieces)
            piece.updatePossibleMoves();
    }
    
    public boolean isCaptured(){
        return captured;
    }
    public Player getPlayer(){
        return player;
    }
    public int getXPos(){
        return xpos;
    }
    public int getYPos(){
        return ypos;
    }
    public ArrayList<Bucket> getPossibleMovesArray(){
        return possibleMoves;
    }
    public static ArrayList<Piece> getAllPiecesArray(){
        return allPieces;
    }
    
    abstract protected void updatePossibleMoves();
    abstract protected boolean checkIfGoodMove(int _xpos, int _ypos);
    
    abstract protected void move(int x, int y);    
    
    abstract protected void Draw(Graphics2D g,int row,int column,
    int xdelta,int ydelta,Chess main);
}
