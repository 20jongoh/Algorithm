import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[N+1][N+1];
        StringTokenizer st;
        dp[1][1] = 1;
        for(int i=1;i<=N;i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++)
            {
                int num = Integer.parseInt(st.nextToken());

                if(dp[i][j]>=1&&num!=0)
                {
                    if(j+num<=N)
                    {
                        dp[i][j+num] +=dp[i][j];
                    }
                    if(i+num<=N)
                    {
                        dp[i+num][j] +=dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
