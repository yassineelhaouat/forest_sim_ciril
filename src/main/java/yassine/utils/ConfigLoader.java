package yassine.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    
    private final Properties properties;
    
    public ConfigLoader(String filename) throws IOException {
        this.properties = loadProperties(filename);
    }
    
    private Properties loadProperties(String filename) throws IOException {
        Properties props = new Properties();
        
        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream(filename)) {
            
            if (input == null) {
                throw new IOException("Property file: " + filename + " not found");
            }
            
            props.load(input);
        }
        
        return props;
    }
    
    public int getForestHeight() {
        String value = properties.getProperty("forest.height");
        return ConfigParser.getPositiveInt(value, "forest.height"
            
        );
    }
    
    public int getForestWidth() {
        String value = properties.getProperty("forest.width");
        return ConfigParser.getPositiveInt(value, "forest.height"
            
        );
    }
    
    public double getPropagationProbability() {
        String value = properties.getProperty("fire.propagationProbability");
        return ConfigParser.getProbability(value, "fire.propagationProbability");
    }
    
    public int[][] getInitialFirePositions() {
        String value = properties.getProperty("fire.initialFires");        
        return ConfigParser.parseFirePositions(value);
    }
    

}