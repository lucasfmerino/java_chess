package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.chess.ChessException;
// import model.boardgame.Board;
// import model.boardgame.Position;
import model.chess.ChessMatch;
import model.chess.ChessPiece;
import model.chess.ChessPosition;
import model.chess.Color;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        ChessPiece caputredPiece = null; // apenas para teste

        while (caputredPiece == null || caputredPiece.toString() != "K") {
            try {
                UI.clearScreen();
                System.out.println();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.println("Source:");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.println("Target");
                ChessPosition target = UI.readChessPosition(sc);
                System.out.println();

                caputredPiece = chessMatch.performChessMove(source, target);
                // ChessPiece caputredPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        // apenas para teste
        UI.printBoard(chessMatch.getPieces());
        if (caputredPiece.getColor() == Color.BLACK) {
            System.out.println("White wins!");
        } else {
            System.out.println("Black wins!");
        }
        System.out.println("Congratulations!");

    }
}
