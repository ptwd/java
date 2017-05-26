package midterm;
import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		Tree directory = new Tree("home");
		directory.addLeft(directory.getRoot(), "DataStructure");
		directory.addRight(directory.getRoot(), "ComputerPractice");
		directory.addLeft(directory.findNodes("DataStructure"), "List");
		directory.addRight(directory.findNodes("DataStructure"), "Tree");
		directory.addLeft(directory.findNodes("ComputerPractice"), "Java");
		directory.addRight(directory.findNodes("ComputerPractice"), "CPP");
		directory.addLeft(directory.findNodes("List"), "ArrayList");
		directory.addRight(directory.findNodes("List"), "LinkedList");
		System.out.println();
		System.out.println("Hello, Start Terminal..");
		scan = new Scanner(System.in);
		
		while(true) {
			String currentNodePath = directory.getCurrentNodePath();
			System.out.println("SC-Terminal : " + currentNodePath + " $ ");
			
			String cmdLine = scan.nextLine();
			
			if(cmdLine.equals("exit")) {
				break;
			}
			else
				directory.executecommand(cmdLine);
			}
		System.out.println("Bye, End Terminal..");

	}
}

