package antoniogusmao.ProblemSpecific;

import antoniogusmao.input.Haversine;

import java.util.*;

public class NeighborService {
    private Map<Node, List<NearestNeighbor>> nearestNeighbors;

    public NeighborService(List<Node> nodes, DistanceService distService, int numNeighbors) {
        this.nearestNeighbors = initNearestNeighbors(nodes, distService, numNeighbors);
    }

    public List<NearestNeighbor> getNearestNeighbors(Node n) {
        return nearestNeighbors.getOrDefault(n, Collections.emptyList());
    }

    private static Map<Node, List<NearestNeighbor>> initNearestNeighbors(List<Node> nodes,
                                                                         DistanceService distService,
                                                                         int numNeighbors) {
        Map<Node, List<NearestNeighbor>> nnMap = new HashMap<>(nodes.size());

        List<IdDistTuple> dists = new ArrayList<>(nodes.size());
        for(int i=0; i < nodes.size(); i++) {
            dists.add(new IdDistTuple(i, Double.MAX_VALUE));
        }
        for (Node n1: nodes) {
            for(IdDistTuple t: dists) t.dist = Double.MAX_VALUE; // reset the distances

            for(int i=0, len=nodes.size(); i < len; i++) {
                Node n2 = nodes.get(i);
                if (n1 == n2) continue;
                dists.get(i).dist = distService.getDistance(n1.id, n2.id);
            }
            dists.sort(Comparator.comparing(IdDistTuple::getDist));

            // now keep the closest nodes;

            int iMax = Math.min(numNeighbors, dists.size());
            List<NearestNeighbor> neighbors = new ArrayList<>(iMax);
            for(int i=0; i < iMax; i++) {
                IdDistTuple t = dists.get(i);
                neighbors.add(new NearestNeighbor(nodes.get(t.id), t.dist));
            }
            System.out.println(neighbors);
            nnMap.put(n1, neighbors);
        }
        return nnMap;
    }

    private static class IdDistTuple {
        int id;
        double dist;

        public IdDistTuple(int id, double dist) {
            this.id = id;
            this.dist = dist;
        }

        public double getDist() {
            return dist;
        }
    }

    public static class NearestNeighbor {
        public final Node n;
        public final double dist;

        public NearestNeighbor(Node n, double dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "NearestNeighbor{" +
                    "n=" + n +
                    ", dist=" + dist +
                    '}';
        }
    }
}
