package yassine.model;

public class Forest {
  private Cell[][] grid;
  private int height;
  private int width;

  public Forest(int height, int width, int[][] firePositions) {
    this.height = height;
    this.width = width;
    this.grid = new Cell[height][width];
    initializeGrid();
    initializeFires(firePositions);

  }

  private void initializeGrid() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = new Cell(CellState.TREE);
      }
    }
  }
  private void initializeFires(int[][] firePositions) {
    for (int[] pos : firePositions) {
      int i = pos[0];
      int j = pos[1];
      if (isValidPosition(i, j)) {
        grid[i][j].setOnFire();
      }
    }
  }


  public CellState getCellState(int i, int j) {
    return grid[i][j].getState();
  }

  public void setCellState(int i, int j, CellState state) {
    grid[i][j].setState(state);
  }

  public int countCellsByState(CellState state) {
    int count = 0;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (grid[i][j].getState() == state) {
          count++;
        }
      }
    }
    return count;
  }






  public boolean isValidPosition(int i, int j) {
    return i >= 0 && i < height && j >= 0 && j < width;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}
