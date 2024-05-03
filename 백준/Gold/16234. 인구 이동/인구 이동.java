import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int arr[][],N,L,R,dx[]={0,1,0,-1},dy[] = {1,0,-1,0};
    static boolean check[][],isMove=false;
    static ArrayList<Node> allNodes;
    public static void main(String[] args)throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(move());
    }

    static public int move()
    {
        int result =0;
        while(true)
        {
            isMove = false;
            check = new boolean[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(!check[i][j]) {
                        int sum = bfs(i, j);
                        if (allNodes.size() >1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove)
            {
                return result;
            }
            else {
                result++;
            }
        }
    }

    static public int bfs(int x, int y)
    {
        Queue<Node> queue = new LinkedList<>();
        allNodes = new ArrayList<>();
        queue.offer(new Node(x, y));
        check[x][y] = true;
        allNodes.add(new Node(x,y));

        int sum = arr[x][y];

        while(!queue.isEmpty())
        {
            Node cur = queue.poll();
            for(int i=0;i<4;i++)
            {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny])
                {
                    int val = Math.abs(arr[nx][ny]-arr[cur.x][cur.y]);
                    if(val>=L && val<=R)
                    {
                        check[nx][ny]=true;
                        queue.offer(new Node(nx,ny));
                        allNodes.add(new Node(nx,ny));
                        sum+=arr[nx][ny];
                    }
                }
            }
        }
        return sum;
    }

    static public void changePopulation(int sum)
    {
        int avg = sum/ allNodes.size();
        for(Node node : allNodes)
        {
            arr[node.x][node.y] = avg;
        }
    }

    static public class Node
    {
        int x,y;
        Node(int x, int y)
        {
            this.x=x;this.y=y;
        }
    }
}
