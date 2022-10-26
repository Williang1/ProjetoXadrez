/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author willi
 */
public class King extends ChessPiece {
   
   private ChessMatch chessMatch; 
    
   public King(Board board, Color color, ChessMatch chessMatch){
    super(board, color); 
    this.chessMatch = chessMatch;
   } 

    
    
   public String toString(){
       return "K";
   }
   
   
   private boolean canMove(Position position) {
       ChessPiece p = (ChessPiece)getBoard().piece(position);
       return p ==null || p.getColor() != getColor();
       
   }
   
   private boolean testRookCastling (Position position){
       ChessPiece p = (ChessPiece)getBoard().piece(position);
       return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount()==0;
   }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()] [getBoard().getColumns()];    
        Position p = new Position(0,0);
        
        //Move para cima
        p.setValues(position.getRow() -1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
          
        //Move para baixo
        p.setValues(position.getRow() +1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
          
        //Move para esquerda
        p.setValues(position.getRow(), position.getColumn() -1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
          
        //Move para direita
        p.setValues(position.getRow(), position.getColumn()+ 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        //noroest

        p.setValues(position.getRow() -1, position.getColumn()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
          
        //Nordeste
        p.setValues(position.getRow() -1, position.getColumn()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
          
        //suldoeste
        p.setValues(position.getRow() +1, position.getColumn()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
          
        //Move para Suldeste
        p.setValues(position.getRow() +1, position.getColumn()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()]= true;
        }
        
        // Jogada especial Castling
        if(getMoveCount()==0 && !chessMatch.getCheck()){
            Position posT1 = new Position(position.getRow(), position.getColumn()+3);
            if(testRookCastling(posT1)){
                Position p1= new Position(position.getRow(), position.getColumn() +1);
                Position p2= new Position(position.getRow(), position.getColumn() + 2);
                
                if(getBoard().piece(p1)== null && getBoard().piece(p2)==null){
                    mat[position.getRow()][position.getColumn() +2]= true;
                    
                }
            }
                Position posT2 = new Position(position.getRow(), position.getColumn()-4);
            if(testRookCastling(posT2)){
                Position p1= new Position(position.getRow(), position.getColumn() -1);
                Position p2= new Position(position.getRow(), position.getColumn() -2);
                Position p3= new Position(position.getRow(), position.getColumn() -3);
                
                if(getBoard().piece(p1)== null && getBoard().piece(p2)==null && getBoard().piece(p3)== null){
                    mat[position.getRow()][position.getColumn() -2]= true;
                
            }
        }
        }
        return mat;
    }
}


