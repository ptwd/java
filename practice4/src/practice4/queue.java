package practice4;
import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class queue {	
	
	static Queue<Integer> q = new LinkedList<Integer>();
	
	
	static void showen(int n)
	{
		q.offer(n);
		System.out.println("Output: " + "-" + " Front : " + q.peek());
	}
	
	static void showde()
	{
		 try{
			 System.out.println("Output: " + q.remove() + " Front : " + q.peek());
		 }
		 catch (NoSuchElementException e){
			 System.out.println("error");
		 }
	}
	
	static void showfront()
	{
		try{
			 System.out.println("Output: " + q.peek() + " Front : " + q.peek()); 
		 }
		 catch (NoSuchElementException e){
			 System.out.println("error");
		 }
	}
	
	static void showisEmpty()
	{
		System.out.println("Output: " + q.isEmpty());
	}
	
	
	
	public static void main(String[] args) {
		showen(5);
		showen(3);
		showde();
		showen(7);
		showde();
		showfront();
		showde();
		showde();
		showisEmpty();

	}
}

