package yassine.logic;

import yassine.model.Forest;
import yassine.utils.ConfigLoader;
import yassine.view.View;

public class SimulationRunner {
  private final ConfigLoader configLoader;
  private final View view;

  public SimulationRunner(ConfigLoader configLoader, View view) {
    this.configLoader = configLoader;
    this.view = view;
  }

  public void runSimulation() {
    Forest forest = new Forest(configLoader.getForestHeight(), configLoader.getForestWidth());
    forest.initializeFires(configLoader.getInitialFirePositions());

    FireBehavior fireBehavior = new FireBehavior(forest, configLoader.getPropagationProbability());
    Simulation simulation = new Simulation(forest, fireBehavior, view);
    view.displayHeader();
    view.displayProperties(configLoader);
    simulation.run();
  }


}
