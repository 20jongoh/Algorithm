import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static int check[],N,K;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        check = new int[100001];

        int result = bfs(N);

        System.out.println(result);
    }

    public static int bfs(int x)
    {
        q.offer(x);
        int index = x;
        int n=0;
        check[index] = 1;

        while(!q.isEmpty())
        {
            n = q.remove();

            if(n == K)
            {
                return check[n]-1;
            }

            if(n-1>=0&&check[n-1]==0)
            {
                check[n-1]=check[n]+1;
                q.offer(n-1);
            }
            if(n+1<=100000&&check[n+1]==0)
            {
                check[n+1]=check[n]+1;
                q.offer(n+1);
            }

            if(n*2<=100000&&check[n*2]==0)
            {
                check[n*2]=check[n]+1;
                q.offer(n*2);
            }
        }
        return -1;
    }
}
