package midterm;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tree {
	private TreeNode root;
	private TreeNode currentNode;
	
	private String command;
	private Queue<String> options;
	
	private List history;
	
	
	
	public Tree(String data) {
		root = new TreeNode(data, null);
		currentNode = root;
		history = new List();
	}
	
	
	
	public TreeNode getRoot() {
		return root;
	}
	
	
	public boolean hasLeft(TreeNode v) {
		if(v.getLeft() == null) {
			return false;
		}
		else{
			return true;
		}
	}
	public boolean hasRight(TreeNode v) {
		if(v.getRight() == null) {
			return false;
		}
		else{
			return true;
		}
	}
	
	public TreeNode addLeft(TreeNode v, String data) { 
		if(hasLeft(v) == false) {
			TreeNode newNode = new TreeNode(data, v); //parent는 v
			v.setLeft(newNode);
			return newNode;
		}
		else {
			return null;
		}
	}
	public TreeNode addRight(TreeNode v, String data) {
		if(hasRight(v) == false) {
			TreeNode newNode = new TreeNode(data, v);
			v.setRight(newNode);
			return newNode;
		}
		else {
			return null;
		}
	}
	
	
	public void inorderTrav(TreeNode v) {
		if(hasLeft(v)) {
			inorderTrav(v.getLeft());
		}
		System.out.println(v.getLeft());
		if(hasRight(v)) {
			inorderTrav(v.getRight());
		}
	}
	
	private TreeNode recursiveFinder(TreeNode v, String data) {
		if(v.getData().equals(data)) {
			return v;
		}
		else {
			if(hasLeft(v) == false && hasRight(v) == false) {
				return null;
			}
			else {
				TreeNode findNode = null;
				TreeNode leftChild = v.getLeft();
				TreeNode rightChild = v.getRight();
				
				if(leftChild != null) {
					findNode = this.recursiveFinder(leftChild, data);  //의문
					if(findNode != null) return findNode;					
				}
				if(rightChild != null&& findNode == null) {
					findNode = this.recursiveFinder(rightChild, data);
					if(findNode != null) return findNode;					
				}
				
				return findNode;
			}
		}
	}
	public TreeNode findNodes(String data) {
		return recursiveFinder(root, data);
	}
	
	public void setCurrentNode(TreeNode v) {
		this.currentNode = v;
	}
	
	public String getCurrentNodePath() {
		Stack<String> stack = new Stack<String>();
		TreeNode tmp = this.currentNode;
		stack.push(tmp.getData());
		while(tmp.getParent() !=null) {
			tmp = tmp.getParent();
			stack.push(tmp.getData());
		}
		
		String path = "";
		while(!stack.isEmpty()) {
			path = path + "/" + stack.pop();
		}
		return path;
	}
	
	public void parseCommand(String str) {
		this.options = new LinkedList<String>();
		String strArr[] = str.split(" ");
		this.command = strArr[0];
		for(int i = 1; i < strArr.length; i++) {
			this.options.offer(strArr[i]); 		 //offer은 linkedlist의 메소드
		}
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public Queue<String> getOptions() {
		return this.options;
	}
	
	public void executecommand(String str) {
		history.addLast(str);
		parseCommand(str);
		
		if(this.command.equals("ls")) {
			this.executeLs();
		}
		else if(this.command.equals("cd")) {
			this.executeCd();
		}
		else if(this.command.equals("mkdir")) {
			this.executeMkdir();
		}
		else if(this.command.equals("pwd")) {
			this.executePwd();
		}
		else if(this.command.equals("whereis")) {
			this.executeWhereis();
		}
		else if(this.command.equals("history")) {
			this.executeHistory();
		}
		else {
			System.out.println("================================================");
			System.out.println("| Usage : [Command] [Option arg]               |");
			System.out.println("| ->Command list:(pwd, ls, cd, mkdir, whereis) |");
			System.out.println("================================================");
		}
	}
	private void executeLs() {
		if(hasLeft(this.currentNode)) {
			System.out.print(this.currentNode.getLeft().getData() + " ");
		}
		if(hasRight(this.currentNode)) {
			System.out.println(this.currentNode.getRight().getData());
		}
	}
	
	private void executeCd() {
		if(options.size() == 0) {
			System.out.println("Error : size 0");
		}
		else {
			String dir = options.poll();
			if(dir.equals("..")) {
				if(this.currentNode != root)
					this.currentNode = this.currentNode.getParent();
			}
			else {
				if(dir.equals(this.currentNode.getLeft().getData())) {
					this.currentNode = this.currentNode.getLeft();
				}
				else if(dir.equals(this.currentNode.getRight().getData())) {
					this.currentNode = this.currentNode.getRight();
				}
				else {
					System.out.println("Error : Invalid option");
				}
			}
		}
	}
	private void executeMkdir() {
		if(options.size() == 0){
		}
		else {
			String newdir = options.poll();
			if(hasLeft(this.currentNode) == false) {
				addLeft(this.currentNode, newdir);
			}
			else if(hasRight(this.currentNode) == false) {
				addRight(this.currentNode, newdir);
			}
			else {
				System.out.println("Error : directory is full");
			}
		}
	}
	private void executePwd() {
		System.out.println(getCurrentNodePath());
	}
	
	private void executeWhereis() {
		if(options.size() == 0) {
			
		}
		else {
			String dir = options.poll();
			
			Stack<String> stack = new Stack<String>();
			TreeNode tmp = findNodes(dir);
			stack.push(tmp.getData());
			while(tmp.getParent() != null) {
				tmp = tmp.getParent();
				stack.push(tmp.getData());
			}
			String path = "";
			while(!stack.isEmpty()) {
				path = path + "/" + stack.pop();
			}
			System.out.println(path);
		}
	}
	
	
	private void executeHistory() {
		if(options.size() == 0) {
			ListNode temp = history.getHeader().getNextNode();
			while(temp != history.getTrailer()) {
				System.out.println(temp.getCommand());
				temp = temp.getNextNode();
			}
		}
		else {
			String opt = options.poll();
			if(opt.equals("-c")) {

				history.initialization();
			}
		}
	}
}
