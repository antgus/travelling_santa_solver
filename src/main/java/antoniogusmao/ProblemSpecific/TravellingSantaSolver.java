package antoniogusmao.ProblemSpecific;

import antoniogusmao.input.InputReader;
import antoniogusmao.input.RawInput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class TravellingSantaSolver {
    private final static Logger log = Logger.getLogger(TravellingSantaSolver.class.getName());

    public static void main(String[] args) {
        String filename = "/Users/agus/projects/travelling_santa_solver/nicelist.txt";
        RawInput input = InputReader.readInput(filename);
        System.out.println(input);

        log.info("Starting dist service init");
        DistanceService distService = new DistanceService(input.nodes);
        log.info("Done init dist service");
        log.info("Starting nearest neighbors init");
        NeighborService nnService = new NeighborService(input.nodes, distService, 500);
        log.info("Done nearest neighbor init");

        // implement something really basic!
        Set<Node> toBeVisited = new HashSet<>(input.nodes);
        toBeVisited.remove(input.depot);

        SingleRoute currentRoute = null;
        List<SingleRoute> solution = new ArrayList<>();
        while(!toBeVisited.isEmpty()) {
            if (currentRoute == null || !addedNewNodes) {
                // create a new Route
                currentRoute = new SingleRoute();
                currentRoute.add(input.depot);
            }

            // find the closest ...
            if(!addedNewNodes) {

            }

        }
    }
}
