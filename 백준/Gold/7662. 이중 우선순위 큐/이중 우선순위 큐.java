import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> treeMap;
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int Q = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();
            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                switch (s) {
                    case "I": {
                        treeMap.put(k, treeMap.getOrDefault(k, 0) + 1);
                        break;
                    }
                    case "D": {
                        if (!treeMap.isEmpty()) {
                            int max;
                            if (k == 1) {
                                max = treeMap.lastKey();
                            } else {
                                max = treeMap.firstKey();
                            }
                            if (treeMap.put(max, treeMap.get(max) - 1) == 1) {
                                treeMap.remove(max);
                            }
                        }
                    }
                }
            }
            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}