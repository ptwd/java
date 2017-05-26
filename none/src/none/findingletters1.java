package none;

public class findingletters1 {
	public static int StringCounter(char[] a, int i)
	{
		if(i == 0)
		{
			if(a[i] == 'm')
				return 1;
			else return 0;
		}
		
		else
			if(a[i] == 'm')
				return 1 + StringCounter(a, i-1);
			else return 0 + StringCounter(a, i-1);
	}

	public static void main(String[] args) {
		
		String str = "my mom loves me!";
		char[] abc= str.toCharArray();
		System.out.println(StringCounter(abc,abc.length-1));


	}

}