package com.company;

import java.util.ArrayList;

public class Board {
    private int[] board;
    private Move[] legalMoves;

    public Board(int[] b, Move[] p){
        board = b;
        legalMoves = p;
    }

    public ArrayList<Move> possibleMoves(){
        ArrayList<Move> moves = new ArrayList<Move>();
        for(int i = 0; i < 36; i++){
            if(board[legalMoves[i].fromPeg] == 1 && board[legalMoves[i].overPeg] == 1 && board[legalMoves[i].toPeg] == 0){
                moves.add(legalMoves[i]);
            }
        }
        return moves;
    }

    public Board nextBoard(Move m){
        int[] afterMove = new int[15];
        for(int i = 0; i < 15; i++){
            if(i == m.fromPeg || i == m.overPeg) {
                afterMove[i] = 0;
            }
            else if(i == m.toPeg){
                afterMove[i] = 1;
            }
            else{
                afterMove[i] = board[i];
            }
        }
        return new Board(afterMove, legalMoves);
    }

    public boolean isSolved(){
        int count = 0;
        for(int i = 0; i < 15; i++){
            if(board[i] == 1){
                count++;
            }
        }
        return count <= 1;
    }

    public void printBoard(){
        System.out.println("     " + board[0]);
        System.out.println("    " + board[1] + " " + board[2]);
        System.out.println("   " + board[3] + " " + board[4] + " " + board[5]);
        System.out.println("  " + board[6] + " " + board[7] + " " + board[8] + " " + board[9]);
        System.out.println(" " + board[10] + " " + board[11] + " " + board[12] + " " + board[13] + " " + board[14]);
    }
}
