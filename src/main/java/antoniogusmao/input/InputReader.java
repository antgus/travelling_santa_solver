package antoniogusmao.input;

import antoniogusmao.ProblemSpecific.Node;
import antoniogusmao.util.FastScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private static InputReader ourInstance = new InputReader();

    public static InputReader getInstance() {
        return ourInstance;
    }

    private InputReader() {
    }

    public static RawInput readInput(String filename) {
        FastScanner sc;
        try {
            File file = new File(filename);
            sc = new FastScanner(new InputStreamReader(new FileInputStream(file)), ";");
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        RawInput input = new RawInput();

        try{
            // ignore first line, has the column names
            sc.nextLine();
            input.depot = new Node(0,68.073611, 29.315278, 0);
            addNode(input, input.depot);
            while(true) {
                // read a row
                int id = sc.nextInt() - 1;
                double lat = sc.nextDouble();
                double lon = sc.nextDouble();
                int weight = sc.nextInt();
                Node n = new Node(id, lat, lon, weight);
                addNode(input, n);
                if(id == 1000) {
                    System.out.println("TRUNCATING NODES UP TO 1000 TO DEBUG FASTER");
                    break;
                }
            }
        } catch(NullPointerException e) {
            // ignore this, it's expected at the end.
        }
        return input;
    }

    private static void addNode(RawInput input, Node n) {
        input.nodes.add(n);
        input.ids.add(n.id);
        input.latList.add(n.lat);
        input.lonList.add(n.lon);
        input.weights.add(n.weight);
    }
}
