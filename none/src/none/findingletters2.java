package none;
import java.math.*;

public class findingletters2 {
	public static int StringCounter(char[] a, int i, int n)
	{
		if( n == 1 )
		{
			if(a[i] == 'm')
				return 1;
			else return 0;
		}
		
		else return StringCounter(a , i , (int)Math.ceil((double)n/2)) + StringCounter( a , i + (int)Math.ceil((double)n/2), (int)Math.floor(n/2));
	}
			

	public static void main(String[] args) {
		
		String str = "my mom loves me!";
		char[] abc= str.toCharArray();
		System.out.println(StringCounter(abc, 0, abc.length));


	}

}