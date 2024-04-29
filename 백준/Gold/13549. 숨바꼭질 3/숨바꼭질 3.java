import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static Queue<Node> queue = new LinkedList<>();
    static int N, K,mt=Integer.MAX_VALUE;
    static boolean check[];
    static int max = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        check = new boolean[max+1];
        bfs(N);
        System.out.println(mt);
    }

    public static void bfs(int start) {
        queue.add(new Node(start,0));

        while(!queue.isEmpty())
        {
            Node node = queue.poll();
            check[node.x] = true;
            if(node.x*2<=max&&!check[node.x*2])
            {
                queue.add(new Node(node.x*2,node.time));
            }
            if(node.x+1<=max&&!check[node.x+1])
            {
                queue.add(new Node(node.x+1,node.time+1));
            }
            if(node.x-1>=0&&!check[node.x-1])
            {
                queue.add(new Node(node.x-1,node.time+1));
            }
            if(node.x==K)
            {
                mt = Math.min(mt,node.time);
            }
        }
    }
    public static class Node
    {
        int x,time;
        Node(int x, int time)
        {
            this.x=x;
            this.time=time;
        }

    }
}
