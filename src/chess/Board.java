package chess;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;



public class Board {
    public final static int NUM_ROWS = 8;
    public final static int NUM_COLUMNS = 8;      
    public static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];

    static Piece pawn1W = new Pawn();
    static Piece pawn2W = new Pawn();
    static Piece pawn3W = new Pawn();
    static Piece pawn4W = new Pawn();
    static Piece pawn5W = new Pawn();
    static Piece pawn6W = new Pawn();
    static Piece pawn7W = new Pawn();
    static Piece pawn8W = new Pawn();
    
    static Piece pawn1B = new Pawn();
    static Piece pawn2B = new Pawn();
    static Piece pawn3B = new Pawn();
    static Piece pawn4B = new Pawn();
    static Piece pawn5B = new Pawn();
    static Piece pawn6B = new Pawn();
    static Piece pawn7B = new Pawn();
    static Piece pawn8B = new Pawn();
    
    static Piece kingW = new King();     
    static Piece kingB = new King();
    
    static Piece QueenW = new Queen();
    static Piece QueenB = new Queen();
    
    static Piece RookW = new Rook();
    static Piece RookB = new Rook();
    
    static Piece KnightW = new Knight();
    static Piece KnightB = new Knight();
    
    static Piece BishopW = new Bishop();
    static Piece BishopB = new Bishop();
    
    private static Player winner = null;
    private static Color boardColor = Color.white;

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
    
    
    
    public static void Draw(Graphics2D g) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        board[1][0] = pawn1W;
        board[1][1] = pawn2W;
        board[1][2] = pawn3W;
        board[1][3] = pawn4W;
        board[1][4] = pawn5W;
        board[1][5] = pawn6W;
        board[1][6] = pawn7W;
        board[1][7] = pawn8W;
        board[6][0] = pawn1B;
        board[6][1] = pawn2B;
        board[6][2] = pawn3B;
        board[6][3] = pawn4B;
        board[6][4] = pawn5B;
        board[6][5] = pawn6B;
        board[6][6] = pawn7B;
        board[6][7] = pawn8B;
        
        
 //draw grid
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
                
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
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcolumn=0;zcolumn<NUM_COLUMNS;zcolumn++)
            {
                if (board[zrow][zcolumn] != null)
                board[zrow][zcolumn].Draw(g, zrow, zcolumn, xdelta, ydelta);
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
        else {
            g.setColor(Player.getCurrentPlayer().getColor());
            g.setFont(new Font("Arial",Font.PLAIN,30));
            if (Player.getCurrentPlayer() == Player.getPlayer1())
                g.drawString("Player 1's turn", 350,70);              
            else
                g.drawString("Player 2's turn", 3500,70);              
        }
        
        
    }
    
    public static void ChangeBoardColor(){
            if(boardColor == Color.white)
                boardColor = Color.black;
                else
                boardColor = Color.white;
    }
}

