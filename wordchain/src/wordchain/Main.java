package wordchain;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("ù �ܾ� �Է� :");
		String s = scanner.next();
		list.addLast(s);
		
		while(true)
		{
			System.out.println("���� �ܾ� �Է� :");
			s = scanner.next();
			if(!list.nooverlap(s))
			{
				System.out.println("*�ߺ��� �ܾ��Դϴ�*");
			}
			if(s.equalsIgnoreCase("exit"))
			{
				System.out.println("����");
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
		System.out.println("*���*");
		list.printAllNodes();
	}
}
