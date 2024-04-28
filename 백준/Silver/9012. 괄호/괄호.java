import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++)
        {
            Stack<Character> stack= new Stack<>();
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String result = Str(name, stack);
            System.out.println(result);
        }
    }

    public static String Str(String name,Stack<Character> stack)
    {
        for(int j = 0;j<name.length();j++)
        {
            char c = name.charAt(j);
            if(c == '(')
            {
                stack.push('(');
            }
            else if(stack.isEmpty())
            {
                return "NO";
            }
            else {
                stack.pop();
            }
        }
        if(stack.isEmpty())
        {
            return "YES";
        }
        else {
            return "NO";
        }
    }
}
