package application;

// import model.boardgame.Board;
// import model.boardgame.Position;
import model.chess.ChessMatch;

public class Program {

    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

    }
}
