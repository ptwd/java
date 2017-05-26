package homework3;
import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		Tree directory = new Tree("home");
		directory.addChild(directory.getRoot(), "DataStructure");
		directory.addChild(directory.getRoot(), "ComputerPractice");
		directory.addChild(directory.findNodes("DataStructure"), "List");
		directory.addChild(directory.findNodes("DataStructure"), "Tree");
		directory.addChild(directory.findNodes("ComputerPractice"), "Java");
		directory.addChild(directory.findNodes("ComputerPractice"), "CPP");
		directory.addChild(directory.findNodes("List"), "ArrayList");
		directory.addChild(directory.findNodes("List"), "LinkedList");
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

