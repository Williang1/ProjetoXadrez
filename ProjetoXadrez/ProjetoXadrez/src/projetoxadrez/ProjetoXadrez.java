/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetoxadrez;
import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author willi
 */
public class ProjetoXadrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     Scanner sc = new Scanner(System.in);   
     ChessMatch chessMatch = new ChessMatch();
     List<ChessPiece> captured = new ArrayList<>();
     
     while (!chessMatch.getCheckMate()){
       try{
            UI.clearScreen(); 
            UI.printMatch(chessMatch, captured);
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);
            
            boolean[][] possibleMoves = chessMatch.possibleMoves(source);
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
         
         
         ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
         
            if(capturedPiece !=null){
                captured.add(capturedPiece);
            }
            
            if(chessMatch.getPromoted() != null){
                System.out.println("coloque a peça para promoção (B/N/R/Q)");
                String type = sc.nextLine().toUpperCase();
                while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q") ){
                    System.out.println("Camando errado, digite novamente peça para promoção (B/N/R/Q)");
                    type = sc.nextLine().toUpperCase();
                }
                chessMatch.replacePromotedPiece(type);
            }
         } 
       catch (ChessException e){
           System.out.println(e.getMessage());
           sc.nextLine();
    }   catch(InputMismatchException e){
           System.out.println(e.getMessage());
           sc.nextLine();
    }
    UI.clearScreen();
    UI.printMatch(chessMatch, captured);

    }}}