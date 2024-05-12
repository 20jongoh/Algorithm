import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int time[] = new int[N];
        int money[] = new int[N];
        int dp[]= new int[N+2];
        int result;

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            time[i] = a;
            money[i] = b;
        }

        for(int i=N-1;i>=0;i--)
        {
            if(i+time[i]>N)
            {
                dp[i] = dp[i+1];
                continue;
            }
            dp[i] = Math.max(money[i]+dp[i+time[i]],dp[i+1]);
        }
        result = dp[0];

        System.out.println(result);
    }
}
