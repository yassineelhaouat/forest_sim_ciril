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
}