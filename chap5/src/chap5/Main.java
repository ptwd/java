package chap5;

public class Main {

	public static void main(String[] args) {
		
		Arraylist list = new Arraylist();
		list.add(0,5);
		list.add(1,2);
		list.add(1,7);
		list.add(0,1);
		list.add(5,41);
		list.printAll();
		System.out.print(list.remove(1) + " ");
		list.printAll();
		list.add(0,4);
		list.printAll();
		System.out.print(list.remove(10) + " ");
		list.printAll();
		System.out.print(list.remove(3) + " ");
		list.printAll();


	}

}
