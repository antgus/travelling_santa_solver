package antoniogusmao.ProblemSpecific;

import antoniogusmao.Optimizer.IState;

import java.util.List;

public class State implements IState {
    List<SingleRoute> allRoutes;
    Cache cache;

    public double getCost() {
        // TODO: Optimize this by using cached values.
        double cost = 0;
        for(SingleRoute r: allRoutes) {
            cost += r.getTotalDist();
        }
        return cost;
    }

    private class Cache {
        List<Node> unvisitedNodes; // how is this maintained?
    }
}
