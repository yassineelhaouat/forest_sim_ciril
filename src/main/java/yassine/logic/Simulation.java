package yassine.logic;

import yassine.model.Forest;
import yassine.view.View;

public class Simulation {
    private final Forest forest;
    private final FireBehavior fireBehavior;
    private final View view;

    public Simulation(Forest forest, FireBehavior fireBehavior, View view) {
        this.forest = forest;
        this.fireBehavior = fireBehavior;
        this.view = view;
    }

    public void run() {
        view.displayForest(forest);
        view.displayStats(forest);

        int current = 0;
        while (fireBehavior.hasFireLeft()) {
            current++;
            view.displayStep(current);
            fireBehavior.next();
            view.displayForest(forest);
            view.displayStats(forest);
        }
    }
}
