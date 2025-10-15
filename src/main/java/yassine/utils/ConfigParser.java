package yassine.utils;

public class ConfigParser {

    public static int getPositiveInt(String value, String propertyName) {
        if (value == null) {
            throw new IllegalStateException(
                "Missing required property: " + propertyName
            );
        }
        
        try {
            int intValue = Integer.parseInt(value);
            
            if (intValue <= 0) {
                throw new IllegalArgumentException(
                    propertyName + " must be a positive integer, got: " + intValue
                );
            }
            
            return intValue;
            
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                propertyName + " must be a valid integer, got: " + value
            );
        }
    }

    public static double getProbability(String value, String propertyName) {
        if (value == null) {
            throw new IllegalStateException(
                "Missing required property: " + propertyName
            );
        }
        
        try {
            double prob = Double.parseDouble(value);
            
            if (prob < 0 || prob > 1) {
                throw new IllegalArgumentException(
                    propertyName + " must be between 0 and 1, got: " + prob
                );
            }
            
            return prob;
            
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                propertyName + " must be a valid number, got: " + value
            );
        }
    }


    public static int[][] parseFirePositions(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("fire.initialFires cannot be empty");
        }

        value = value.replace("(", "").replace(")", "").trim();
        
        String[] positions = value.split("\\s+");
        int[][] fires = new int[positions.length][2];

        for (int i = 0; i < positions.length; i++) {
            String[] coords = positions[i].split(",");
            
            if (coords.length != 2) {
                throw new IllegalArgumentException(
                    "Invalid fire position format: '" + positions[i] + "'. Expected format: x,y"
                );
            }
            
            try {
                fires[i][0] = Integer.parseInt(coords[0].trim());
                fires[i][1] = Integer.parseInt(coords[1].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                    "Invalid coordinates in fire position: '" + positions[i] + "'"
                );
            }
        }

        return fires;
    }
    
}
