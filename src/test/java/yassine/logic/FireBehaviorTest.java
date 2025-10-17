package yassine.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import yassine.model.CellState;
import yassine.model.Forest;

class FireBehaviorTest {

    @Test
    void testFirePropagation() {
        Forest forest = new Forest(3, 3);
        forest.setFire(1, 1);
        
        FireBehavior behavior = new FireBehavior(forest, 1.0); // 100% propagation
        behavior.next();
        
        assertEquals(CellState.ASH, forest.getCellState(1, 1));
        
        assertEquals(CellState.FIRE, forest.getCellState(0, 1));
        assertEquals(CellState.FIRE, forest.getCellState(2, 1));
        assertEquals(CellState.FIRE, forest.getCellState(1, 0));
        assertEquals(CellState.FIRE, forest.getCellState(1, 2));
    }

    @Test
    void testSimulationEnds() {
        Forest forest = new Forest(3, 3);
        forest.setFire(1, 1);
        
        FireBehavior behavior = new FireBehavior(forest, 0.0);
        
        assertTrue(behavior.hasFireLeft());
        behavior.next();
        assertFalse(behavior.hasFireLeft()); 
    }
    
    @Test
    void testFireDoesNotSpreadTwiceInSameStep() {
        Forest forest = new Forest(5, 5);
        forest.setFire(0, 0);
        
        FireBehavior behavior = new FireBehavior(forest, 1.0); 
        behavior.next();
        
        // After one step:
        // - (0,0) should be ASH
        // - (1,0) and (0,1) should be FIRE
        // - (2,0), (1,1), (0,2) should still be TREE (not ignited in same step)
        assertEquals(CellState.ASH, forest.getCellState(0, 0));
        assertEquals(CellState.FIRE, forest.getCellState(1, 0));
        assertEquals(CellState.FIRE, forest.getCellState(0, 1));
        assertEquals(CellState.TREE, forest.getCellState(2, 0));
        assertEquals(CellState.TREE, forest.getCellState(1, 1));
    }
    
    @Test
    void testCornerFirePropagation() {
        Forest forest = new Forest(3, 3);
        forest.setFire(0, 0);
        
        FireBehavior behavior = new FireBehavior(forest, 1.0);
        behavior.next();
        
        assertEquals(CellState.ASH, forest.getCellState(0, 0));
        assertEquals(CellState.FIRE, forest.getCellState(1, 0));
        assertEquals(CellState.FIRE, forest.getCellState(0, 1));
        
        // Count total fires - should be exactly 2
        assertEquals(2, forest.countCellsByState(CellState.FIRE));
    }
    
    @Test
    void testNoPropagationWithZeroProbability() {
        Forest forest = new Forest(3, 3);
        forest.setFire(1, 1);
        
        FireBehavior behavior = new FireBehavior(forest, 0.0);
        behavior.next();
        
        // Fire should turn to ash but not spread
        assertEquals(CellState.ASH, forest.getCellState(1, 1));
        assertEquals(0, forest.countCellsByState(CellState.FIRE));
        assertEquals(8, forest.countCellsByState(CellState.TREE));
    }
    
    @Test
    void testMultipleInitialFires() {
        Forest forest = new Forest(5, 5);
        forest.setFire(1, 1);
        forest.setFire(3, 3);
        
        FireBehavior behavior = new FireBehavior(forest, 1.0);
        
        assertEquals(2, forest.countCellsByState(CellState.FIRE));
        
        behavior.next();
        
        // Both should turn to ash
        assertEquals(CellState.ASH, forest.getCellState(1, 1));
        assertEquals(CellState.ASH, forest.getCellState(3, 3));
        assertEquals(2, forest.countCellsByState(CellState.ASH));
        
        // Should have spread from both sources
        assertTrue(forest.countCellsByState(CellState.FIRE) > 0);
    }
}