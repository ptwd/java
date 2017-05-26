package practice4;
import java.util.Stack;
import java.util.EmptyStackException;


public class stackclass {
	
	static Stack<Integer> s = new Stack<Integer>();
	
	static void showpush(Stack<Integer> st, int a) {
	      st.push(a);
	      System.out.println("Output: "+ "-" + " Stack : " + st);
	   }
	
	
	 static void showpop(Stack<Integer> st) {
		 try{
			 System.out.println("Output: " + st.pop() + " Stack : " + st); 
		 }
		 catch (EmptyStackException e){
			 System.out.println("error");
		 }
	   }
	 
	 
	 static void showpeek(Stack<Integer> st) {
		 try{
			 System.out.println("Output: " + st.peek() + " Stack : " + st); 
		 }
		 catch (EmptyStackException e){
			 System.out.println("error");
		 }
	   }
	 
	 
	 static void showisEmpty(Stack<Integer> st) {
		 System.out.println("Output: " + st.isEmpty());
	 }

	
	

	public static void main(String[] args) {
		showpush(s, 5);
		showpush(s, 3);
		showpop(s);
		showpush(s, 7);
		showpop(s);
		showpeek(s);
		showpop(s);
		showpop(s);
		showisEmpty(s);

	}
}
