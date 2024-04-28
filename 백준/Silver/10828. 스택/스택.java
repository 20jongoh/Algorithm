import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            switch (name) {
                case "push": {
                    int n = Integer.parseInt(st.nextToken());
                    stack.push(n);
                    break;
                }
                case "pop":
                {
                    if(!stack.isEmpty())
                    {
                        int num = stack.pop();
                        System.out.println(num);

                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                }
                case "size":
                {
                    System.out.println(stack.size());
                    break;
                }
                case "empty":
                {
                    if(stack.isEmpty())
                    {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                }
                case "top":
                {
                    if(stack.isEmpty())
                    {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stack.peek());
                    }
                    break;
                }
            }
        }
    }
}
