package yassine.view;

import yassine.model.CellState;
import yassine.model.Forest;

public class ConsoleView {

   public void displayHeader() {
        System.out.println("Simulation feu de foret");
        System.out.println("======================");
    }
    public void displayForest(Forest forest) {
        for (int i = 0; i < forest.getHeight(); i++) {
            for (int j = 0; j < forest.getWidth(); j++) {
                System.out.print(forest.getCellState(i, j) + " ");
            }
            System.out.println();
        }
    }

    public void displayProperties(int height, int width, double probability, int[][] firePositions) {
        System.out.println("Hauteur h: " + height);
        System.out.println("Largeur l: " + width);
        System.out.println("Probabilite: " + probability);
        System.out.println("Positions initiales de feu: " + java.util.Arrays.deepToString(firePositions));
    }
    public void displayStep(int step) {
        System.out.println("Step " + step + ":");
    }

    public void displayStats(Forest forest) {
        int numOfFires = forest.countCellsByState(CellState.FIRE);
        if (numOfFires == 0) {
            System.out.println("Simulation terminee. Aucun feu actif restant.");
        } else {
            System.out.println("Nombre total de feux actifs: " + numOfFires);
        }
        System.out.println("Nombre d'arbres: " + forest.countCellsByState(CellState.TREE));
        System.out.println("Nombre de cendres: " + forest.countCellsByState(CellState.ASH));
        System.out.println();
    }

}
