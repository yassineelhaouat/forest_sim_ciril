package yassine.logic;

import yassine.model.Forest;
import yassine.utils.ConfigLoader;
import yassine.view.View;

public class Simulation {
    private final Forest forest;
    private final FireBehavior fireBehavior;
    private final View view;
    private final ConfigLoader config;

    public Simulation(ConfigLoader config, View view) {
        this.config = config;
        this.view = view;
        this.forest = new Forest(config.getForestHeight(), config.getForestWidth());
        this.forest.initializeFires(config.getInitialFirePositions());
        this.fireBehavior = new FireBehavior(forest, config.getPropagationProbability());
    }

    public void run() {
        view.displayHeader();
        view.displayProperties(config);
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
