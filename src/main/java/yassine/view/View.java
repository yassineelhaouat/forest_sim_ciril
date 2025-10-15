package yassine.view;

import yassine.model.Forest;
import yassine.utils.ConfigLoader;

public interface View {
    void displayHeader();
    void displayForest(Forest forest);
    void displayProperties(ConfigLoader config);
    void displayStep(int step);
    void displayStats(Forest forest);
}
