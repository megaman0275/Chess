package chess;

import java.awt.Color;


public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[2];
    private Color color;
    private int numPawns = 8;
    private int numRooks = 2;
    private int numKnights = 2;
    private int numBishops = 2;
    private int numQueens = 1;
    private int numKings = 1;
    
    public static void Reset() {
        if (players[0] == null) {
            players[0] = new Player(Color.black);
            players[1] = new Player(Color.red);
        }
        currentTurn = players[0];
    }
    
    Player(Color _color) {
        color = _color;
    }
    
    public Color getColor() {
        return (color);
    }
    public static Player getPlayer1() {
        return (players[0]);
    }
    public static Player getPlayer2() {
        return (players[1]);
    }
    public static Player getCurrentPlayer() {
        return(currentTurn);
    }   
    public static Player getOtherPlayer() {
        if (currentTurn == players[0])
            return (players[1]);
        return(players[0]);
    }   
    public static void switchTurn() {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }
}