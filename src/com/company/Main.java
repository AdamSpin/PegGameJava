package com.company;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            Solver s = new Solver(i);
            s.solve();
            System.out.print("\n\n");
            System.out.println("Solution for starting position " + i + "\n");
            s.displaySolution();
        }
    }
}
