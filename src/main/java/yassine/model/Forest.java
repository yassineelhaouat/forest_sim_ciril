package yassine.model;

public class Forest {
  private Cell[][] grid;
  private int height;
  private int width;

  public Forest(int height, int width) {
    this.height = height;
    this.width = width;
    this.grid = initializeGrid();

  }



  //Initializes all grid with TREE cells
  private Cell[][] initializeGrid() {
    Cell[][] newGrid = new Cell[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        newGrid[i][j] = new Cell(CellState.TREE);
      }
    }
    return newGrid;
  }
  
  // Initializes fire cells at given positions
  public void initializeFires(int[][] firePositions) {
    for (int[] pos : firePositions) {
      int i = pos[0];
      int j = pos[1];
      if (isValidPosition(i, j)) setFire(i, j);
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

  public void setFire(int i, int j) {
    if (!isValidPosition(i, j)) {
      throw new IllegalArgumentException(
        "Fire position (" + i + "," + j + ") is out of bounds."
      );
    }
    grid[i][j].setState(CellState.FIRE);
  }

  /*
   * 
   * Checks if coords are within defined grid bounds
   */
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
