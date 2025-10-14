package yassine.model;

public enum CellState {
  TREE,
  FIRE,
  ASH;

  @Override
  public String toString() {
    return switch (this) {
      case TREE -> "T";
      case FIRE -> "F";
      case ASH -> "A";
    };
  }
}
