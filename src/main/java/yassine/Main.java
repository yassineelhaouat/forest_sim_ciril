package yassine;

import yassine.logic.SimulationRunner;
import yassine.utils.ConfigLoader;
import yassine.view.ConsoleView;

public class Main {
  public static void main(String[] args) throws java.io.IOException {
    ConfigLoader config = new ConfigLoader("config.properties");
    SimulationRunner runner = new SimulationRunner(config, new ConsoleView());
    runner.runSimulation();
  }   


}