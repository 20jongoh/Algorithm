import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Node> q = new LinkedList<>();
    static int arr[][],count;
    static int N,M,result,dx[] = {1,-1,0,0},dy[] = {0,0,-1,1};
    static boolean check[][];

    static int fx,fy;

    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr= new int[N][M];
        check = new boolean[N][M];

        for(int i=0;i<N;i++)
        {
            String name = br.readLine();
            for(int j=0;j<M;j++)
            {
                arr[i][j] = name.charAt(j);

                if(arr[i][j]=='I')
                {
                    fx = i;
                    fy = j;
                }
                if(arr[i][j]=='X')
                {
                    check[i][j] =true;
                }
            }
        }
        bfs(fx,fy);

        if(count!=0)
        {
            System.out.println(count);
        }
        else {
            System.out.println("TT");
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
        count=0;
        q.offer(new Node(x,y));
        check[x][y] = true;

        while(!q.isEmpty())
        {
            Node node = q.poll();
            for(int i=0;i<4;i++)
            {
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];

                if(nx>=0&&nx<N&&ny>=0&&ny<M&&!check[nx][ny])
                {
                    q.offer(new Node(nx,ny));
                    check[nx][ny] = true;
                    if(arr[nx][ny]=='P')
                    {
                        count++;
                    }
                }
            }
        }
    }
}
