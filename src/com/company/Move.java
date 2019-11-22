package com.company;

public class Move {
    public int fromPeg;
    public int overPeg;
    public int toPeg;

    public Move(int f, int o, int t){
        fromPeg = f;
        overPeg = o;
        toPeg = t;
    }

    public void display(){
        System.out.println("{" + fromPeg + ", " + overPeg + ", " + toPeg + "}");
    }
}
