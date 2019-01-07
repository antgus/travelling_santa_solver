package antoniogusmao.ProblemSpecific;

import antoniogusmao.input.Haversine;

import java.util.List;

public class DistanceService {
    double[][] distMatrix;
    double maxDist;

    public DistanceService(List<Node> nodes) {
        distMatrix = new double[nodes.size()][nodes.size()];
        for(int i=0, iMax=nodes.size(); i < iMax; i++) {
            Node n1 = nodes.get(i);
            for(int j=i+1, jMax=nodes.size(); j < jMax; j++) {
                Node n2 = nodes.get(j);
                double dist = Haversine.haversineDist(n1.lat, n1.lon, n2.lat, n2.lon);
                distMatrix[i][j] = dist;
                distMatrix[j][i] = dist;
                maxDist = Math.max(dist, maxDist);
            }
        }
    }

    public double getDistance(int id1, int id2) {
        return distMatrix[id1][id2];
    }

    public double getMaxDistance() {
        return maxDist;
    }
}
