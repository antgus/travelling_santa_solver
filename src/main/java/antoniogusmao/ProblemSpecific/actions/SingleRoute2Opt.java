package antoniogusmao.ProblemSpecific.actions;

import antoniogusmao.ProblemSpecific.SingleRoute;

public class SingleRoute2Opt {

    public static void apply(SingleRoute r) {
        while(true) {
            boolean wasImproved = false;

            long bestCost = r.getTotalDist();
            outerloop: {
                for (int i = 1, iMax = r.length(); i < iMax; i++) {
                    for (int k = i + 1, kMax = r.length(); k < kMax; k++) {
                        swap2opt(r, i, k);
                        long newCost = r.getTotalDist();
                        if (newCost < bestCost) {
                            wasImproved = true;
                            break outerloop;
                        } else {
                            // undo 2 opt.
                            swap2opt(r, i, k);
                        }
                    }
                }
            }

            if(!wasImproved) break;
        }
    }

    public static void swap2opt(SingleRoute r, int i, int k) {
        /**
         * 1. take route[0] to route[i-1] and add them in order to new_route
         * 2. take route[i] to route[k] and add them in reverse order to new_route
         * 3. take route[k+1] to end and add them in order to new_route
         * return new_route;
         */
        r.reverse(i, k);
    }
}
