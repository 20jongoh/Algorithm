import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N,K,a;
    static int arr[][],dx[] = {1,-1,0,0},dy[] = {0,0,1,-1},count;
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr= new int[M][N];
            check = new boolean[M][N];
            count=0;

            for(int j=0;j<K;j++)
            {
                st= new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for(int l=0;l<M;l++)
            {
                for(int j=0;j<N;j++)
                {
                    if(arr[l][j]==1&&!check[l][j])
                    {
                        bfs(l,j);
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }
    public static class Node
    {
        int x,y;
        Node(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static void bfs(int x,int y)
    {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        check[x][y] = true;

        while(!q.isEmpty())
        {
            Node cur = q.poll();
            for(int i=0;i<4;i++)
            {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx>=0&&nx<M&&ny>=0&&ny<N)
                {
                    if(!check[nx][ny]&&arr[nx][ny]==1)
                    {
                        q.offer(new Node(nx,ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
}
