import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

// int []num = {i, top};
// stack.push(num);
//stack.push(new int[] {i, top});
public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        Stack<int[]> stack = new Stack<int[]>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<T;i++)
        {
            int top = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty())
            {
                if(stack.peek()[1] >= top)
                {
                    System.out.print(stack.peek()[0]+" ");
                    break;
                }
                    stack.pop();
            }
            if(stack.isEmpty())
            {
                System.out.print(0+" ");
            }
            stack.push(new int[] {i+1, top});
        }
    }
}
