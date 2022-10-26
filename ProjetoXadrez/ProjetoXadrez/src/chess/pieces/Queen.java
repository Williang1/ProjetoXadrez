/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author willi
 */
public class Queen extends ChessPiece {
 
    
    public Queen(Board board, Color color){
        super(board, color);
 
}
    @Override
    public String toString(){
       return "Q"; 
    }
     public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()] [getBoard().getColumns()];   
        
        Position p = new Position(0,0);
        // acima da peça
        p.setValues(position.getRow()-1, position.getColumn());
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            p.setRow(p.getRow()-1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        //esquerda
        p.setValues(position.getRow()-1, position.getColumn() -1);
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            p.setColumn(p.getColumn()-1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        
        //Direita
        p.setValues(position.getRow(), position.getColumn() +1);
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            p.setColumn(p.getColumn()+1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        //Abaixo
        p.setValues(position.getRow()+1, position.getColumn());
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            p.setRow(p.getRow()+1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        
         p.setValues(position.getRow()-1, position.getColumn()-1);
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            p.setValues(p.getRow()-1, p.getColumn() -1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        //nordeste
        p.setValues(position.getRow()-1, position.getColumn() +1);
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            p.setValues(p.getRow()-1, p.getColumn() +1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        
        //sudeste
        p.setValues(position.getRow() +1, position.getColumn() +1);
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
            
            p.setValues(p.getRow() +1, p.getColumn() +1);
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        //suldoeste
        p.setValues(position.getRow()+1, position.getColumn() -1);
        while(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) ){
            mat[p.getRow()][p.getColumn()]= true;
             p.setValues(p.getRow()+1, p.getColumn() -1);
           
        }
        if(getBoard().positionExists(p)&& isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        
        return mat;
    }
}