package yassine.logic;

import java.util.ArrayList;
import java.util.List;

import yassine.model.CellState;
import yassine.model.Forest;

public class FireBehavior {
  private Forest forest;
  double propagationProbability = 0.5;

  public FireBehavior(Forest forest) {
    this.forest = forest;
  }

  public FireBehavior(Forest forest, double propagationProbability) {
    this.forest = forest;
    this.propagationProbability = propagationProbability;
  }

  public void step() {
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
    int[][] coords = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};

    for (int[] pos : coords) {
      int x = pos[0];
      int y = pos[1];

      if (forest.isValidPosition(x, y)
          && forest.getCellState(x, y) == CellState.TREE
          && Math.random() < this.propagationProbability) {
        cellsToBurn.add(new int[] {x, y});
      }
    }
  }

  public boolean noFireLeft() {
    for (int i = 0; i < forest.getHeight(); i++) {
      for (int j = 0; j < forest.getWidth(); j++) {
        if (forest.getCellState(i, j) == CellState.FIRE) {
          return false;
        }
      }
    }
    return true;
  }
}
