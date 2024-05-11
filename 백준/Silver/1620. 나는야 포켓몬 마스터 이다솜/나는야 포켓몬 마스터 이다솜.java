import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str[] = new String[N+1];
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=1;i<=N;i++)
        {
            String name = br.readLine();
            hashMap.put(name,i);
            str[i] = name;
        }
        for(int i=0;i<M;i++)
        {
            String findstr = br.readLine();
            if(isStringNumber(findstr))
            {
                int index = Integer.parseInt(findstr);
                sb.append(str[index]);
            }
            else {
                sb.append(hashMap.get(findstr));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static boolean isStringNumber(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
