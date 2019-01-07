package antoniogusmao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Use of a BufferedReader speeds up Scanner
 */
public class FastScanner {

    private final BufferedReader br;
    private StringTokenizer st;
    private final String delim;


    public FastScanner(InputStreamReader in) {
        this(in, null);
    }

    public FastScanner(InputStreamReader in, String delim) {
        br = new BufferedReader(in);
        this.delim = delim;
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                if(this.delim != null) {
                    st = new StringTokenizer(br.readLine(), this.delim);
                } else {
                    st = new StringTokenizer(br.readLine());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int size) {
        int[] array = new int[size];
        for(int i=0; i < size; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
