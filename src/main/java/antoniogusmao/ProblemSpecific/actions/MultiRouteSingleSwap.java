package antoniogusmao.ProblemSpecific.actions;

import antoniogusmao.ProblemSpecific.Node;
import antoniogusmao.ProblemSpecific.SingleRoute;
import antoniogusmao.ProblemSpecific.State;

public class MultiRouteSingleSwap {

    public void swap(State s, SingleRoute r1, SingleRoute r2, int iRoute1, int iRoute2) {
        Node n1 = r1.getNode(iRoute1);
        Node n2 = r2.getNode(iRoute2);
        Node r1RemovedNode = r1.swapNewNode(iRoute1, n2);
        Node r2RemovedNode = r2.swapNewNode(iRoute2, n1);
    }
}
