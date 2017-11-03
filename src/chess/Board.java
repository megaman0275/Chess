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
    
    static Piece queenW = new Queen();
    static Piece queenB = new Queen();
    
    static Piece rook1W = new Rook();
    static Piece rook1B = new Rook();
    static Piece rook2W = new King();     
    static Piece rook2B = new King();
    
    static Piece knight1W = new Knight();
    static Piece knight1B = new Knight();
    static Piece knight2W = new King();     
    static Piece knight2B = new King();
    
    static Piece bishop1W = new Bishop();
    static Piece bishop1B = new Bishop();
    static Piece bishop2W = new King();     
    static Piece bishop2B = new King();
    
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
        pawn1W.setWhiteTeam(true);
        board[1][1] = pawn2W;
        pawn2W.setWhiteTeam(true);
        board[1][2] = pawn3W;
        pawn3W.setWhiteTeam(true);
        board[1][3] = pawn4W;
        pawn4W.setWhiteTeam(true);
        board[1][4] = pawn5W;
        pawn5W.setWhiteTeam(true);
        board[1][5] = pawn6W;
        pawn6W.setWhiteTeam(true);
        board[1][6] = pawn7W;
        pawn7W.setWhiteTeam(true);
        board[1][7] = pawn8W;
        pawn8W.setWhiteTeam(true);
        
        board[6][0] = pawn1B;
        pawn1B.setWhiteTeam(false);
        board[6][1] = pawn2B;
        pawn2B.setWhiteTeam(false);
        board[6][2] = pawn3B;
        pawn3B.setWhiteTeam(false);
        board[6][3] = pawn4B;
        pawn4B.setWhiteTeam(false);
        board[6][4] = pawn5B;
        pawn5B.setWhiteTeam(false);
        board[6][5] = pawn6B;
        pawn6B.setWhiteTeam(false);
        board[6][6] = pawn7B;
        pawn7B.setWhiteTeam(false);
        board[6][7] = pawn8B;
        pawn8B.setWhiteTeam(false);
        
        board[0][0] = rook1W;
        rook1W.setWhiteTeam(true);
        board[0][1] = knight1W;
        knight1W.setWhiteTeam(true);
        board[0][2] = bishop1W;
        bishop1W.setWhiteTeam(true);
        board[0][3] = kingW;
        kingW.setWhiteTeam(true);
        board[0][4] = queenW;
        queenW.setWhiteTeam(true);
        board[0][5] = bishop2W;
        bishop2W.setWhiteTeam(true);
        board[0][6] = knight2W;
        knight2W.setWhiteTeam(true);
        board[0][7] = rook2W;
        rook2W.setWhiteTeam(true);
       
        board[7][0] = rook1B;
        rook1B.setWhiteTeam(false);
        board[7][1] = knight1B;
        knight1B.setWhiteTeam(false);
        board[7][2] = bishop1B;
        bishop1B.setWhiteTeam(false);
        board[7][3] = kingB;
        kingB.setWhiteTeam(false);
        board[7][4] = queenB;
        queenB.setWhiteTeam(false);
        board[7][5] = bishop2B;
        bishop2B.setWhiteTeam(false);
        board[7][6] = knight2B;
        knight2B.setWhiteTeam(false);
        board[7][7] = rook2B;
        rook2B.setWhiteTeam(false);
        
        
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

