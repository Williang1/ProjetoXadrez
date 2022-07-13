/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoxadrez;

import chess.ChessPiece;

/**
 *
 * @author willi
 */
public class UI {
    public static void printBoard(ChessPiece[][] pieces){
        for(int i=0;  i<pieces.length; i++){
        System.out.println((8-i)+" ");
        for(int j=0; j<pieces.length; j++){
            printPieces(pieces[i][j]);
        }
            System.out.println();
    }
        System.out.println(" a b c d e f g h");
    }
    
    private static void printPieces(ChessPiece piece){
        if(piece== null){
        System.out.print("-");
    }else{
            System.out.print(piece);
           
            }
    
        System.out.print(" ");
    }
}
