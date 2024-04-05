import java.util.*;
public class Main {

    static int dp[][] = new int[42][2];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;

        for(int i=2;i<42;i++)
        {
            for(int j=0;j<2;j++)
            {
                dp[i][j] = dp[i-2][j]+dp[i-1][j];
            }
        }

        for(int i=0;i<T;i++)
        {
            int N = sc.nextInt();
            System.out.println(dp[N][0]+" "+dp[N][1]);
        }
    }
}