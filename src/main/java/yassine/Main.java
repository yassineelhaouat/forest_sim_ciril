package yassine;

import yassine.config.ConfigLoader;
import yassine.logic.FireBehavior;
import yassine.model.Forest;
import yassine.view.ConsoleView;

public class Main {
  public static void main(String[] args) {
    ConfigLoader config = new ConfigLoader();
    int height = config.getForestHeight();
    int width = config.getForestWidth();
    double propagationProbability = config.getPropagationProbability();
    int[][] firePositions = config.getInitialFirePositions();
    

    Forest forest = new Forest(height, width, firePositions);
    FireBehavior simulation = new FireBehavior(forest, propagationProbability);
    
    
    ConsoleView view = new ConsoleView();

    view.displayHeader();
    view.displayProperties(height, width, propagationProbability, firePositions);
    view.displayForest(forest);
    view.displayStats(forest);



    int current = 0;
    while(!simulation.noFireLeft()){
        current++;
        view.displayStep(current);
        simulation.next();
        view.displayForest(forest);
        view.displayStats(forest);
    }

  }


}