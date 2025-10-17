package yassine;

import java.io.IOException;

import yassine.logic.Simulation;
import yassine.utils.ConfigLoader;
import yassine.view.ConsoleView;

public class Main {
  public static void main(String[] args)  {

    try{
      ConfigLoader config = new ConfigLoader("config.properties");
      Simulation simulation = new Simulation(config, new ConsoleView());
      simulation.run();
    } catch (IOException | IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  
}