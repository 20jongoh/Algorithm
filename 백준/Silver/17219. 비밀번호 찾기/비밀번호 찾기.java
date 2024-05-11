import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,String> hashMap = new HashMap<>();

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String number = st.nextToken();

            hashMap.put(name,number);
        }

        for(int i=0;i<M;i++)
        {
            String result = br.readLine();
            System.out.println(hashMap.get(result));
        }
    }
}
