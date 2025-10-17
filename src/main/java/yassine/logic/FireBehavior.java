package yassine.logic;

import yassine.model.CellState;
import yassine.model.Forest;
import java.util.ArrayList;
import java.util.List;

public class FireBehavior {
  /** directions for neighbor cells (left, right, down, up) */
  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private final Forest forest;
  private final double propagationProbability;

  public FireBehavior(Forest forest, double propagationProbability) {
    this.forest = forest;
    this.propagationProbability = propagationProbability;
  }

  /** Checks for fire cells, spreads fire to valid neighbors, then turns fire cell to ash */
  public void next() {
    List<int[]> fireCells = new ArrayList<>();
    for (int i = 0; i < forest.getHeight(); i++) {
      for (int j = 0; j < forest.getWidth(); j++) {
        if (forest.getCellState(i, j) == CellState.FIRE) {
          fireCells.add(new int[]{i, j});
        }
      }
    }
    
    for (int[] cell : fireCells) {
      spreadToNeighbors(cell[0], cell[1]);
      forest.setCellState(cell[0], cell[1], CellState.ASH);
    }
  }

  private void spreadToNeighbors(int i, int j) {
    for (int[] d : DIRECTIONS) {
      int neighbor_i = i + d[0];
      int neighbor_j = j + d[1];

      if (forest.isValidPosition(neighbor_i, neighbor_j) && forest.getCellState(neighbor_i, neighbor_j) == CellState.TREE && Math.random() < propagationProbability) {
        forest.setCellState(neighbor_i, neighbor_j, CellState.FIRE);
      }
    }
  }

  public boolean hasFireLeft() {
    return forest.countCellsByState(CellState.FIRE) > 0;
  }
}
