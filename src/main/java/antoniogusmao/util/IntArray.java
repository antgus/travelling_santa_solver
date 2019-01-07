package antoniogusmao.util;

public final class IntArray {
    private static int INCREASE_ARRAY_BY = 20;
    private int[] array;
    private int length;

    public void setCapacity(int len) {
        if(array.length != len) {
            this.array = new int[len];
        }
    }

    public void setLength(int len) {
        if(array.length < len) {
            setCapacity(len + INCREASE_ARRAY_BY);
        }
        this.length = len;
    }

    public void set(int i, int v) {
        this.array[i] = v;
    }

    public int get(int i) {
        return array[i];
    }

    public void add(int idx, int v) {
        if (this.length == array.length) {
            increaseArrayCapacity();
        }
        for(int i=length+1; i > idx; i--) {
            array[i] = array[i-1];
        }
        array[idx] = v;
        this.length++;
    }

    private void increaseArrayCapacity() {
        int[] tmp = new int[INCREASE_ARRAY_BY];
        System.arraycopy(array, 0, tmp, 0, array.length);
        this.array = tmp;
    }

    /**
     * Note that the backing array will typically be > than length()
     */
    public int[] getBackingArray() {
        return array;
    }

    public int length() {
        return length;
    }
}
