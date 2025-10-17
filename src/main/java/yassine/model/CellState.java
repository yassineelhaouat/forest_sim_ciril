package yassine.model;

public enum CellState {
  TREE,
  FIRE,
  ASH;

  @Override
  public String toString() {
    switch (this) {
      case TREE:
        return "T";
      case FIRE:
        return "F";
      case ASH:
        return "A";
      default:
        return "EMPTY";
    }
  }
}
