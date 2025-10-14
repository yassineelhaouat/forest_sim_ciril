package yassine;

import yassine.model.Forest;

public class Main {
    public static void main(String[] args) {

        int height =5;
        int width =10;

        int[][] firePositions = {
            {0, 1},
            {1, 2},
            {2, 3}
        };

        Forest forest = new Forest(height, width, firePositions);


        for (int i = 0; i < forest.getHeight(); i++) {
            for (int j = 0; j < forest.getWidth(); j++) {
                System.out.print(forest.getCellState(i, j) + " ");
            }
            System.out.println();
        }

        

    }
}