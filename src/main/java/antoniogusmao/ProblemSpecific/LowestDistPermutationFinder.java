package antoniogusmao.ProblemSpecific;

public final class LowestDistPermutationFinder {
    private int minDist;
    private int[] minPermutation;
    private int[][] distMatrix;

    public void init(int[] a, int[][] distMatrix) {

    }

    public void findLowestDistPermutation(int[] arr, int[][] distMatrix) {
        int totalDist = 0;
        for(int i = 1; i < arr.length; i++) {
            totalDist += distMatrix[arr[i-1]][arr[i]];
        }
        updateMinPermutation(arr, totalDist);

        permute(arr, 0, totalDist);
    }

    private static void swap(int[] arr, int i, int k) {
        int t = arr[i];
        arr[i] = arr[k];
        arr[k] = t;
    }

    private void updateMinPermutation(int[] arr, int totalDist) {
        minDist = totalDist;
        System.arraycopy(arr, 0, minPermutation, 0, arr.length);
    }

    private void permute(int[] arr, int index, int totalDist){
        if(index >= arr.length - 1){
            // last element, permutation ready!
            if (totalDist < minDist) {
                updateMinPermutation(arr, totalDist);
            }
            return;
        }

        for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]
            int newTotalDist = totalDist;
            // == swap(arr, index, i)
            newTotalDist -= distMatrix[arr[index-1]][arr[index]];
            newTotalDist -= distMatrix[arr[index]][arr[index+1]];
            newTotalDist -= distMatrix[arr[i-1]][arr[i]];
            newTotalDist -= distMatrix[arr[i]][arr[i+1]];
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
            newTotalDist += distMatrix[arr[index-1]][arr[index]];
            newTotalDist += distMatrix[arr[index]][arr[index+1]];
            newTotalDist += distMatrix[arr[i-1]][arr[i]];
            newTotalDist += distMatrix[arr[i]][arr[i+1]];

            if (newTotalDist < minDist) {
                // TODO: improve the bound: use a lower bound of distance still to be covered (e.g. with MST)
                //       MST can be computed in O(arr.length) so it can easily be done as preprocessing step.
                //
                // so we can more effectively prune the search tree earlier.
                // only recurse if there's a chance that the total distance will be <
                //Recurse on the sub array arr[index+1...end]
                permute(arr, index+1, newTotalDist);
            }

            // == swap(arr, i, index) Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }
}
