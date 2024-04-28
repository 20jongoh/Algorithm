import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt=0;

        String NS[] = new String[N];
        String MS[] = new String[M];

        for(int i =0;i<N;i++)
        {
            NS[i] = bf.readLine();
        }

        for(int i =0;i<M;i++)
        {
            MS[i] = bf.readLine();
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(NS[i].equals(MS[j]))
                {
                  cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
