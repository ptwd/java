package wordchain;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 단어 입력 :");
		String s = scanner.next();
		list.addLast(s);
		
		while(true)
		{
			System.out.println("다음 단어 입력 :");
			s = scanner.next();
			if(!list.nooverlap(s))
			{
				System.out.println("*중복된 단어입니다*");
			}
			if(s.equalsIgnoreCase("exit"))
			{
				System.out.println("종료");
				break;
			}
			if(list.compare(s))
			{
				list.addLast(s);
				continue;
			}
			else
				break;	
		}
		System.out.println("*기록*");
		list.printAllNodes();
	}
}
