import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Node> queue = new LinkedList<>();
    static int arr[][], dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1}, N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }
        int g = bfs();
        if (check()) {
            System.out.println(g);
        } else {
            System.out.println(-1);
        }
    }

    public static class Node {
        int x, y, t;

        Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static boolean check() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int bfs() {
        int time = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            time = node.t;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        queue.offer(new Node(nx, ny, time + 1));
                    }
                }
            }
        }
        return time;
    }
}
