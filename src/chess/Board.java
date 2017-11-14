package chess;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;



public class Board {
    public final static int NUM_ROWS = 8;
    public final static int NUM_COLUMNS = 8;      
    public static Piece board[][] = new Piece[NUM_COLUMNS][NUM_ROWS];
    public static Piece selectedPiece;
    public static boolean whitePlayerTurn = true;
    public static boolean piecesInitalized = false;

    static Piece pawn1W = new Pawn(0,6,true);
    static Piece pawn2W = new Pawn(1,6,true);
    static Piece pawn3W = new Pawn(2,6,true);
    static Piece pawn4W = new Pawn(3,6,true);
    static Piece pawn5W = new Pawn(4,6,true);
    static Piece pawn6W = new Pawn(5,6,true);
    static Piece pawn7W = new Pawn(6,6,true);
    static Piece pawn8W = new Pawn(7,6,true);
    
    static Piece pawn1B = new Pawn(0,1,false);
    static Piece pawn2B = new Pawn(1,1,false);
    static Piece pawn3B = new Pawn(2,1,false);
    static Piece pawn4B = new Pawn(3,1,false);
    static Piece pawn5B = new Pawn(4,1,false);
    static Piece pawn6B = new Pawn(5,1,false);
    static Piece pawn7B = new Pawn(6,1,false);
    static Piece pawn8B = new Pawn(7,1,false);
    
    static Piece kingW = new King(4,7,true);     
    static Piece kingB = new King(3,0,false);
    
    static Piece queenW = new Queen(3,7,true);
    static Piece queenB = new Queen(4,0,false);
    
    static Piece rook1W = new Rook(0,7,true);
    static Piece rook2W = new Rook(7,7,true);
    static Piece rook1B = new Rook(0,0,false);    
    static Piece rook2B = new Rook(7,0,false);
    
    static Piece knight1W = new Knight(1,7,true);
    static Piece knight1B = new Knight(6,7,true);
    static Piece knight2W = new Knight(1,0,false);     
    static Piece knight2B = new Knight(6,0,false);
    
    static Piece bishop1W = new Bishop(2,7,true);
    static Piece bishop1B = new Bishop(5,7,true);
    static Piece bishop2W = new Bishop(2,0,false);     
    static Piece bishop2B = new Bishop(5,0,false);
    
    private static Player winner = null;
    private static Color brown = new Color(169,146,103);
    private static Color boardColor = brown;

    public static void Reset() {

        for (int zi = 0;zi<NUM_ROWS;zi++)
        {
            for (int zx = 0;zx<NUM_COLUMNS;zx++)
            {
                board[zi][zx] = null;
            }
        }
        winner = null;

    }
    
    public static void initalizePieces(){
        board[pawn1W.xpos][pawn1W.ypos] = pawn1W;
        board[pawn2W.xpos][pawn2W.ypos] = pawn2W;
        board[pawn3W.xpos][pawn3W.ypos] = pawn3W;
        board[pawn4W.xpos][pawn4W.ypos] = pawn4W;
        board[pawn5W.xpos][pawn5W.ypos] = pawn5W;
        board[pawn6W.xpos][pawn6W.ypos] = pawn6W;
        board[pawn7W.xpos][pawn7W.ypos] = pawn7W;
        board[pawn8W.xpos][pawn8W.ypos] = pawn8W;
        
        board[pawn1B.xpos][pawn1B.ypos] = pawn1B;
        board[pawn2B.xpos][pawn2B.ypos] = pawn2B;
        board[pawn3B.xpos][pawn3B.ypos] = pawn3B;
        board[pawn4B.xpos][pawn4B.ypos] = pawn4B;
        board[pawn5B.xpos][pawn5B.ypos] = pawn5B;
        board[pawn6B.xpos][pawn6B.ypos] = pawn6B;
        board[pawn7B.xpos][pawn7B.ypos] = pawn7B;
        board[pawn8B.xpos][pawn8B.ypos] = pawn8B;
        
        board[rook1W.xpos][rook1W.ypos] = rook1W;
        board[knight1W.xpos][knight1W.ypos] = knight1W;
        board[bishop1W.xpos][bishop1W.ypos] = bishop1W;
        board[kingW.xpos][kingW.ypos] = kingW;
        board[queenW.xpos][queenW.ypos] = queenW;
        board[bishop2W.xpos][bishop2W.ypos] = bishop2W;
        board[knight2W.xpos][knight2W.ypos] = knight2W;
        board[rook2W.xpos][rook2W.ypos] = rook2W;
       
        board[rook1B.xpos][rook1B.ypos] = rook1B;
        board[knight1B.xpos][knight1B.ypos] = knight1B;
        board[bishop1B.xpos][bishop1B.ypos] = bishop1B;
        board[kingB.xpos][kingB.ypos] = kingB;
        board[queenB.xpos][queenB.ypos] = queenB;
        board[bishop2B.xpos][bishop2B.ypos] = bishop2B;
        board[knight2B.xpos][knight2B.ypos] = knight2B;
        board[rook2B.xpos][rook2B.ypos] = rook2B;
        piecesInitalized = true;
    }
    
    public static void Draw(Graphics2D g,Chess main) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        if(!piecesInitalized){
            initalizePieces();
            for(Piece piece : Piece.getAllPiecesArray()){
                piece.updatePossibleMoves();
            }
        }
        
 //draw grid

                
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            ChangeBoardColor();
            for (int zcolumn=0;zcolumn<NUM_COLUMNS;zcolumn++)
            {
                g.setColor(boardColor);
                g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/NUM_COLUMNS,
                Window.getY(0)+zrow*Window.getHeight2()/NUM_ROWS,
                Window.getWidth2()/NUM_COLUMNS,
                Window.getHeight2()/NUM_ROWS);
                
                ChangeBoardColor();
            }
        }

//Hilighting selected Piece
        if(selectedPiece != null){
            g.setColor(Color.yellow);
            g.fillRect(Window.getX(0)+selectedPiece.xpos*Window.getWidth2()/NUM_COLUMNS,
            Window.getY(0)+selectedPiece.ypos*Window.getHeight2()/NUM_ROWS,
            Window.getWidth2()/NUM_COLUMNS,
            Window.getHeight2()/NUM_ROWS);
            
            for(Bucket possibleMove : selectedPiece.getPossibleMovesArray()){
                g.setColor(Color.green);
                g.fillRect(Window.getX(0)+possibleMove.xpos*Window.getWidth2()/NUM_COLUMNS,
                Window.getY(0)+possibleMove.ypos*Window.getHeight2()/NUM_ROWS,
                Window.getWidth2()/NUM_COLUMNS,
                Window.getHeight2()/NUM_ROWS);
                g.setColor(Color.orange);
                g.drawRect(Window.getX(0)+possibleMove.xpos*Window.getWidth2()/NUM_COLUMNS,
                Window.getY(0)+possibleMove.ypos*Window.getHeight2()/NUM_ROWS,
                Window.getWidth2()/NUM_COLUMNS,
                Window.getHeight2()/NUM_ROWS);
            }

        }
//        if(selectedPiece != null){
//            g.setColor(Color.yellow);
//            g.fillRect(Window.getX(0)+selectedPiece.xpos*Window.getWidth2()/NUM_COLUMNS,
//            Window.getY(0)+selectedPiece.ypos*Window.getHeight2()/NUM_ROWS,
//            Window.getWidth2()/NUM_COLUMNS,
//            Window.getHeight2()/NUM_ROWS);
//            for(Bucket possibleLoc : selectedPiece.getPossibleMovesArray()){
//                g.setColor(Color.green);
//                g.fillRect(Window.getX(0)+possibleLoc.xpos*Window.getWidth2()/NUM_COLUMNS,
//                Window.getY(0)+possibleLoc.ypos*Window.getHeight2()/NUM_ROWS,
//                Window.getWidth2()/NUM_COLUMNS,
//                Window.getHeight2()/NUM_ROWS);
//                
//                g.setColor(Color.orange);
//                g.drawRect(Window.getX(0)+possibleLoc.xpos*Window.getWidth2()/NUM_COLUMNS,
//                Window.getY(0)+possibleLoc.ypos*Window.getHeight2()/NUM_ROWS,
//                Window.getWidth2()/NUM_COLUMNS,
//                Window.getHeight2()/NUM_ROWS); 
//            }
// Drawing all the Pieces        
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcolumn=0;zcolumn<NUM_COLUMNS;zcolumn++)
            {
                if (board[zrow][zcolumn] != null)
//                    if(!board[zrow][zcolumn].isCaptured())
                board[zrow][zcolumn].Draw(g, zrow, zcolumn, xdelta, ydelta, main);
            }
        }
            
        
        if (winner == Player.getPlayer1()) {
            g.setColor(Player.getPlayer1().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 1 has Won", 200,70);              
        }
        else if (winner == Player.getPlayer2()) {
            g.setColor(Player.getPlayer2().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            g.drawString("Player 2 has Won", 200,70);              
        }
        else  {
            g.setColor(Player.getCurrentPlayer().getColor());
            g.setFont(new Font("Times New Roman",Font.PLAIN,30));
            if(whitePlayerTurn)
                g.drawString("White Turn", 325,70);  
            
            else
                g.drawString("Black turn", 325,70);     
        }
        
        
        
    }
    
    public static void mouseSelectedPiece(int x, int y){
        int zcol = convertXPixelToINT(x - Window.getX(0),Window.getWidth2()/NUM_COLUMNS);
        int zrow = convertYPixelToINT(y- Window.getY(0),Window.getHeight2()/NUM_ROWS);

        
        if(zrow > -1 && zcol > -1 && zrow < NUM_ROWS && zcol < NUM_COLUMNS){
            
            if(selectedPiece == null){
                if(board[zcol][zrow] != null && playersTurn(zcol,zrow)){
                    selectedPiece = board[zcol][zrow];
                }
            }else if(selectedPiece != null){
                
                if(board[zcol][zrow] != null){
                    
                    if(board[zcol][zrow] == selectedPiece){
                        
                        selectedPiece = null;
                    }else if(selectedPiece.getColor() != board[zcol][zrow].getColor()){
                        if(selectedPiece.checkIfGoodMove(zcol, zrow))
                        movePiece(zcol,zrow);
                    }
                }else{
                    if(selectedPiece.checkIfGoodMove(zcol, zrow))
                    movePiece(zcol,zrow);
                }
            }
            
        }
        
    }
    public static boolean playersTurn(int x, int y){
        if(whitePlayerTurn && board[x][y].getColor() == Color.blue){
            return true;
        }
        if(!whitePlayerTurn && board[x][y].getColor() == Color.red){
            return true;
        }
        return false;
    }
    
    public static void movePiece(int zcol, int zrow){
        if(board[zcol][zrow] != null){
            board[zcol][zrow].capturePiece();
        }
       board[selectedPiece.getXPos()][selectedPiece.getYPos()] = null;
       selectedPiece.move(zcol, zrow);
       board[zcol][zrow] = selectedPiece;
       selectedPiece = null;
       whitePlayerTurn = !whitePlayerTurn;
       Piece.UpdateAllPiecesPossibleMoves();
    }
    public static int convertXPixelToINT(int x, int xdelta){
        int intX = 0;
        for(int i=0;i<NUM_COLUMNS;i++){
            if(xdelta * i < x && x < xdelta*(i+1)){
                intX = i;
            }
        }
        return intX;
    }
    
    public static int convertYPixelToINT(int y, int ydelta){
        int intY = 0;
        for(int i=0;i<NUM_ROWS;i++){
            if(ydelta * i < y && y < ydelta * (i+1) ){
                intY = i;
            }
        }
        return intY;
    }
    
 
    
    public static void ChangeBoardColor(){
            if(boardColor == Color.white)
                boardColor = brown;
                else
                boardColor = Color.white;
    }
}

