import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        int n = 0;
        int cnt = 0;
        while (cnt < T) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            cnt++;
            switch (name) {
                case "push": {
                    n = Integer.parseInt(st.nextToken());
                    queue.offer(n);
                    break;
                }
                case "pop": {
                    if (!queue.isEmpty()) {
                        int num = queue.poll();
                        bw.write(String.valueOf(num) + "\n");

                    } else {
                        bw.write(-1+ "\n");
                    }
                    break;
                }
                case "size": {
                    bw.write(String.valueOf(queue.size()) + "\n");
                    break;
                }
                case "empty": {
                    if (queue.isEmpty()) {
                        bw.write(1+ "\n");
                    } else {
                        bw.write(0+ "\n");
                    }
                    break;
                }
                case "front": {
                    if (queue.isEmpty()) {
                        bw.write(-1+ "\n");
                    } else {
                        bw.write(String.valueOf(queue.peek()) + " \n");
                    }
                    break;
                }
                case "back": {
                    if (queue.isEmpty()) {
                        bw.write(-1+ "\n");
                    } else {
                        bw.write(String.valueOf(n)+ "\n");
                    }
                    break;
                }
            }
        }
        bw.flush();
    }
}
