package yassine.logic;

import java.util.ArrayList;
import java.util.List;

import yassine.model.CellState;
import yassine.model.Forest;

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
    List<int[]> cellsToBecomeAsh = new ArrayList<>();
    List<int[]> cellsToBurn = new ArrayList<>();

    for (int i = 0; i < forest.getHeight(); i++) {
      for (int j = 0; j < forest.getWidth(); j++) {

        if (forest.getCellState(i, j) == CellState.FIRE) {
          cellsToBecomeAsh.add(new int[] {i, j});

          spreadToNeighbors(i, j, cellsToBurn);
        }
      }
    }

    for (int[] pos : cellsToBecomeAsh) {
      forest.setCellState(pos[0], pos[1], CellState.ASH);
    }
    for (int[] pos : cellsToBurn) {
      if (forest.getCellState(pos[0], pos[1]) == CellState.TREE) {
        forest.setCellState(pos[0], pos[1], CellState.FIRE);
      }
    }
  }

  private void spreadToNeighbors(int i, int j, List<int[]> cellsToBurn) {
    for (int[] d : DIRECTIONS) {
      int neighbor_i = i + d[0];
      int neighbor_j = j + d[1];

      if (canSpreadTo(neighbor_i, neighbor_j)) {
        cellsToBurn.add(new int[] {neighbor_i, neighbor_j});
      }
    }
  }

  /** defines if fire can spread to neighbors by probability */
  private boolean canSpreadTo(int row, int col) {
    return forest.isValidPosition(row, col)
        && forest.getCellState(row, col) == CellState.TREE
        && Math.random() < propagationProbability;
  }

  public boolean hasFireLeft() {
    return forest.countCellsByState(CellState.FIRE) > 0;
  }
}
