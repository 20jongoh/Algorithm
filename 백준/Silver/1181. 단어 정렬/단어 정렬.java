import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		HashSet<String> set = new HashSet<String>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int cnt = 0;
		
		for(int i=0;i<num;i++)
		{
			String st = sc.next();
			if(!set.contains(st))
			{
				set.add(st);
				cnt++;
			}
		}
		String result[] = set.toArray(new String[0]);
		Arrays.sort(result);
		Arrays.sort(result, (String s1 , String s2)->s1.length()-s2.length());
		for(int i=0;i<cnt;i++)
		{
			System.out.println(result[i]);
		}
	}
}