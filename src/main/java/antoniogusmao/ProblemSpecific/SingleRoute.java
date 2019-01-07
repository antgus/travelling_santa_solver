package antoniogusmao.ProblemSpecific;

import antoniogusmao.util.IntArray;
import com.google.common.collect.BiMap;

import java.util.Collection;
import java.util.List;

/**
 * Represents a single vehicle's route
 */
public class SingleRoute {
    private IntArray visited; // ids of visited nodes // TODO: this should be behind a resizeable abstraction? In that case, can't be checking length!
    private Cache cache;

    public void addNode(int routeIdx, Node n) {
        cache.dist -= cache.subrouteDist(routeIdx - 1, routeIdx);
        int nodeIdx = nodeIdtoNodeIdx(n.id);
        visited.add(routeIdx, nodeIdx);
        cache.biMapNodeToIdx.put(n.getIdAsInteger(), ); // figure this out...
        cache.dist += cache.subrouteDist(routeIdx-1, routeIdx+1); // consider having all distance-related functionality grouped. so addNode would have a dist implementation, a totalWeight implemenetaiton, etc.
        cache.totalWeight += n.weight;
        throw new UnsupportedOperationException("TODO - must update the distance matrix");
    }

    public void addNodes(int idx, Collection<Node> nodes) {
        int i = idx;
        for(Node n: nodes) {
            addNode(i, n); // TODO make a more efficient version of this
            i++;
        }
    }

    public void removeNode(int routeIdx) {
        throw new UnsupportedOperationException("TODO");
    }

    public void removeNodes(int iStart, int iEndInclusive) {
        int count = iEndInclusive - iStart + 1;
        for(int i=0; i < count; i++) {
            removeNode(iStart); // note that we always remove iStart since after removing the route will become smallers and iStart will refer to a new item
        }
    }

    public double getTotalWeight() {
        return cache.totalWeight;
    }

    public long getTotalDist() {
        return cache.dist;
    }

    public void reverse(int iStart, int iEnd) {
        if(cache.isDistMatrixSymmetric) {
            if (iStart > 0) {
                cache.dist = cache.dist - cache.distMatrix[iStart-1][iStart]
                        - cache.distMatrix[iEnd][iEnd+1];
            }

            // if dist(A,B) == dist(B,A) reversing doesn't change dist except at the start and end of the route
            cache.dist = cache.dist + cache.distMatrix[iStart-1][iStart] + cache.distMatrix[iEnd][iEnd+1];
        } else {
            int iStartPrev = Math.max(iStart-1, 0);
            int iEndNext = Math.min(iEnd+1, visited.length());
            cache.dist -= cache.subrouteDist(iStartPrev, iEndNext);
            reverseArray(visited.getBackingArray(), iStart, iEnd);
            cache.dist += cache.subrouteDist(iStartPrev, iEndNext);
        }
    }

    public int length() {
        return visited.length();
    }

    public Node swapNewNode(int idx, Node newNode) {
        // remove the dist related to the piece of route that will be replaced
        cache.dist -= cache.subrouteDist(idx-1, idx+1);
        Node removedNode = getNode(idx);

        // add dist for the newly added piece of route
        cache.dist += cache.subrouteDist(idx-1, idx+1);
        throw new UnsupportedOperationException("TODO");
    }

    private Node getNode(int routeIdx) {

    }

    public Node internalIdxToNode(int internalIdx) {

    }

    public void swapInternal(int routeIdx1, int routeIdx2) {
        return  
    }


    public void swapNodes(int idx, List<Node> newNodes, List<Node> listForRemovedNodes) {
        throw new UnsupportedOperationException("TODO");
    }

    private class Cache {
        BiMap<Integer, Integer> biMapNodeToIdx;
        long totalWeight;
        long dist;
        long[][] distMatrix; // TODO this should also be resizable to support add/remove operations
        boolean isDistMatrixSymmetric;

        boolean isDistSymmetric() {
            return isDistMatrixSymmetric;
        }

        /**
         * Calculates the sum of the distance of the subroute that starts at visited[iStart] and
         * ends and visited[iEndInclusive].
         *
         * Note: if the route has been changed for indexes iMin <= i <= iMax, subRouteDist should be computed between
         * Math.max(0,iMin-1) and Math.max(visited.length, iMax+1);
         */
        long subrouteDist(int iStart, int iEndInclusive) {
            iStart = Math.max(iStart, 0);
            iEndInclusive = Math.min(iEndInclusive, visited.length());
            if(iStart == iEndInclusive) return 0;
            long dist = 0;
            for(int i=iStart+1; i <= iEndInclusive; i++) {
                dist += cache.distMatrix[visited.get(i-1)][visited.get(i)];
            }
            return dist;
        }
    }

    private static void reverseArray(int[] a, int i, int k) {
        while(i < k) {
            int tmp = a[i];
            a[i] = a[k];
            a[k] = tmp;
            i++;
            k--;
        }
    }
}
