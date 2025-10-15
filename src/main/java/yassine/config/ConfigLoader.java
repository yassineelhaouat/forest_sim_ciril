package yassine.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
  private final Properties properties;

  public ConfigLoader() {
    this.properties = loadProperties("config.properties");
  }

  private Properties loadProperties(String filename) {
    Properties props = new Properties();
    InputStream input = getClass().getClassLoader().getResourceAsStream(filename);

    try {
      props.load(input);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return props;
  }

  public int getForestHeight() {
    return Integer.parseInt(properties.getProperty("forest.height"));
  }

  public int getForestWidth() {
    return Integer.parseInt(properties.getProperty("forest.width"));
  }

  public double getPropagationProbability() {
    return Double.parseDouble(properties.getProperty("fire.propagationProbability"));
  }

  public int[][] getInitialFirePositions() {
    String value = properties.getProperty("fire.initialFires").trim();
    value = value.replace("(", "").replace(")", "");
    String[] positions = value.split("\\s+");
    int[][] fires = new int[positions.length][2];

    for (int i = 0; i < positions.length; i++) {
      String[] coords = positions[i].split(",");
      fires[i][0] = Integer.parseInt(coords[0].trim());
      fires[i][1] = Integer.parseInt(coords[1].trim());
    }

    return fires;
  }
}