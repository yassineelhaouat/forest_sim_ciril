package yassine.view;

import java.util.Arrays;

import yassine.model.CellState;
import yassine.model.Forest;
import yassine.utils.ConfigLoader;

public class ConsoleView implements View {

    @Override
   public void displayHeader() {
        System.out.println("Simulation feu de foret");
        System.out.println("======================");
    }

    @Override
    public void displayForest(Forest forest) {
        for (int i = 0; i < forest.getHeight(); i++) {
            for (int j = 0; j < forest.getWidth(); j++) {
                System.out.print(forest.getCellState(i, j) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void displayProperties(ConfigLoader config){
        System.out.println("Hauteur: " + config.getForestHeight());
        System.out.println("Largeur: " + config.getForestWidth());
        System.out.println("Probabilite de propagation: " + config.getPropagationProbability());
        System.out.println("Positions de feu initiales: " + Arrays.deepToString(config.getInitialFirePositions()));        System.out.println();
    }


    @Override
    public void displayStep(int step) {
        System.out.println("Step " + step + ":");
    }


    @Override
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
