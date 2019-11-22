package com.company;

import java.util.ArrayList;

public class Solver {
    private Board board;
    private Move[] legalMoves;
    private ArrayList<Move> winningMoves;

    private boolean boardSolved;

    public Solver(int startPos){
        //Initializing variables
        setLegalMoves();
        winningMoves = new ArrayList<Move>();
        boardSolved = false;

        //Board Setup
        int[] pegs = new int[15];
        for(int i = 0; i < 15; i++) {
            if (i == startPos) {
                pegs[i] = 0;
            } else {
                pegs[i] = 1;
            }
        }
        board = new Board(pegs, legalMoves);
    }

    private void setLegalMoves(){
        legalMoves = new Move[36];
        legalMoves[0] = new Move(0,1,3);
        legalMoves[1] = new Move(0,2,5);
        legalMoves[2] = new Move(1,3,6);
        legalMoves[3] = new Move(1,4,8);
        legalMoves[4] = new Move(2,4,7);
        legalMoves[5] = new Move(2,5,9);
        legalMoves[6] = new Move(3,1,0);
        legalMoves[7] = new Move(3,4,5);
        legalMoves[8] = new Move(3,6,10);
        legalMoves[9] = new Move(3,7,12);
        legalMoves[10] = new Move(4,7,11);
        legalMoves[11] = new Move(4,8,13);
        legalMoves[12] = new Move(5,2,0);
        legalMoves[13] = new Move(5,4,3);
        legalMoves[14] = new Move(5,8,12);
        legalMoves[15] = new Move(5,9,14);
        legalMoves[16] = new Move(6,3,1);
        legalMoves[17] = new Move(6,7,8);
        legalMoves[18] = new Move(7,4,2);
        legalMoves[19] = new Move(7,8,9);
        legalMoves[20] = new Move(8,4,1);
        legalMoves[21] = new Move(8,7,6);
        legalMoves[22] = new Move(9,5,2);
        legalMoves[23] = new Move(9,8,7);
        legalMoves[24] = new Move(10,6,3);
        legalMoves[25] = new Move(10,11,12);
        legalMoves[26] = new Move(11,7,4);
        legalMoves[27] = new Move(11,12,13);
        legalMoves[28] = new Move(12,7,3);
        legalMoves[29] = new Move(12,8,5);
        legalMoves[30] = new Move(12,11,10);
        legalMoves[31] = new Move(12,13,14);
        legalMoves[32] = new Move(13,8,4);
        legalMoves[33] = new Move(13,12,11);
        legalMoves[34] = new Move(14,9,5);
        legalMoves[35] = new Move(14,13,12);
    }
    private void depthFirstSearch(Board b){
        if(b.isSolved()){
            boardSolved = true;
            return;
        }
        for(int i = 0; i < b.possibleMoves().size(); i++){
            winningMoves.add(b.possibleMoves().get(i));
            depthFirstSearch(b.nextBoard(b.possibleMoves().get(i)));
            if(boardSolved) return;
        }
        winningMoves.remove(winningMoves.size() - 1);
    }

    public void solve(){
        depthFirstSearch(board);
    }

    public void printMoves(){
        for(int i = 0; i < winningMoves.size(); i++){
            winningMoves.get(i).display();
        }
    }

    public void displaySolution(){
        Board temp = board;
        temp.printBoard();
        for(int i = 0; i < winningMoves.size(); i++){
            temp = temp.nextBoard(winningMoves.get(i));
            temp.printBoard();
        }
    }
}
