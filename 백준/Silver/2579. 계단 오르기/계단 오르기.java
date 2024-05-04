import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer dp[];
    static int st[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        st = new int[N+1];
        for(int i=1;i<=N;i++)
        {
            st[i] = Integer.parseInt(br.readLine());
        }

        dp[0]=st[0];
        dp[1]=st[1];

        if(N>=2)
        {
            dp[2] = st[1]+st[2];
        }

        System.out.println(find(N));
    }
    static int find(int N)
    {
        if(dp[N]==null)
        {
            dp[N] = Math.max(find(N-2),find(N-3)+st[N-1])+st[N];
        }
        return dp[N];
    }
}
