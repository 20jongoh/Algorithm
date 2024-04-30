import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N,M,T,arr[][];
    static boolean check[][][];
    static Queue<Load> queue = new LinkedList<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args)throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[N][M][2];
        int a = bfs(0,0);

        if(a==-1)
        {
            System.out.println("Fail");
        }
        else
            System.out.print(a);

    }
    public static class Load
    {
        int x,y,t;
        boolean sw;
        Load(int x,int y,int t,boolean sw)
        {
            this.x=x;
            this.y=y;
            this.t=t;
            this.sw=sw;
        }
    }
    public static int bfs(int x, int y)
    {
        queue.offer(new Load(0,0,0,false));
        check[0][0][0] = true;

        while(!queue.isEmpty())
        {
            Load ld = queue.poll();

            if(ld.t >T)
            {
                break;
            }
            if(ld.x==N-1&&ld.y==M-1)
            {
                return ld.t;
            }
            for(int i=0;i<4;i++)
            {
                int nx = ld.x+dx[i];
                int ny = ld.y+dy[i];
                if(nx >=0 && ny>=0&&nx<N&&ny<M)
                {
                    if(!ld.sw)
                    {
                        if(!check[nx][ny][0]&&arr[nx][ny]==0)
                        {
                            queue.offer(new Load(nx,ny,ld.t+1,ld.sw));
                            check[nx][ny][0]=true;
                        }
                        else if(!check[nx][ny][0]&&arr[nx][ny]==2)
                        {
                            queue.offer(new Load(nx,ny,ld.t+1,true));
                            check[nx][ny][0]=true;
                        }
                    }
                    else {
                        if(!check[nx][ny][1])
                        {
                            queue.offer(new Load(nx,ny,ld.t+1,ld.sw));
                            check[nx][ny][1]=true;
                        }
                    }
                }
            }
        }
        return-1;
    }
}
