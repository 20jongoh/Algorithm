import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count=0;

        int money[] = new int[N];

        for(int i=0;i<N;i++)
        {
            money[i] = Integer.parseInt(br.readLine());
        }

        for(int i=N-1;i>=0;i--)
        {
            if(money[i] <=K)
            {
                count+=(K/money[i]);
                K %=money[i];
            }
        }
        System.out.println(count);
    }
}
