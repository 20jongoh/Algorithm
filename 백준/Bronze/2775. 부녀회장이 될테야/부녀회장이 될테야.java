import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int result[][] = new int[15][15];

        for(int i=1;i<15;i++)
        {
            result[0][i] = i;
            result[i][1] = 1;
        }

        for(int i=1;i<15;i++)
        {
            for(int j=2;j<15;j++)
            {
                result[i][j] = result[i][j-1]+result[i-1][j];
            }
        }

        for(int i=0;i<T;i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            System.out.println(result[K][N]);
        }
    }
}
