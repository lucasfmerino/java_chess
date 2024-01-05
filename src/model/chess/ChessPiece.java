package model.chess;

import model.boardgame.Board;
import model.boardgame.Piece;
import model.boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position positoin) {
        ChessPiece p = (ChessPiece) getBoard().piece(positoin);
        return p != null && p.getColor() != color;
    }
}
