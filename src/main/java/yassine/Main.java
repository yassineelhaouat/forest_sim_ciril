package yassine;

import java.io.IOException;

import yassine.logic.SimulationRunner;
import yassine.utils.ConfigLoader;
import yassine.view.ConsoleView;

public class Main {
  public static void main(String[] args)  {

    try{
    ConfigLoader config = new ConfigLoader("config.properties");
    SimulationRunner runner = new SimulationRunner(config, new ConsoleView());
    runner.runSimulation();
    } catch (IOException | IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }   


}