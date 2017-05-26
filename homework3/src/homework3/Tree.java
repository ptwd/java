package homework3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class Tree {
	static int MAX = 3;
	private TreeNode root;
	private TreeNode currentNode;
	
	private String command;
	private Queue<String> options;
	
	private List history;
	
	
	
	public Tree(String data) {
		root = new TreeNode(data, null);  // data를가지고 parent가 null인 TreeNode
		currentNode = root;
		history = new List();
	}
	
	
	
	public TreeNode getRoot() {
		return root;
	}
	
	public boolean isInternal(TreeNode v) {
		if(v.getList().isEmpty())
			return false;
		else
			return true;
	}
	public boolean isExternal(TreeNode v) {
		if(v.getList().isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isRoot(TreeNode v) {
		if(v.getParent() == null)
			return true;
		else
			return false;
	}
	public void addChild(TreeNode p, String data) {
		TreeNode newNode = new TreeNode(data, p);
		p.getList().add(newNode);
	}

	public void preOrder(TreeNode n) {
		System.out.println(n.getData());
		
		if(!isExternal(n)) {
			for(int i = 0; i < n.getList().size(); i++) {
				preOrder(n.getList().get(i));
			}
		}
	}
	
	private TreeNode recursiveFinder(TreeNode v, String data) {
		if(v.getData().equals(data)) {
			return v;
		}
		else {
			if(isExternal(v)) {
				return null;
			}
			else {
				TreeNode findNode = null;
				int i = 0;
				while(i < v.getList().size() && findNode == null) {
					TreeNode searchChild = v.getList().get(i);
					findNode = this.recursiveFinder(searchChild, data);
					i++;
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
		else if(this.command.equals("rm")) {
			this.executeRm();
		}
		else if(this.command.equals("cp")) {
			this.executeCp();
		}
		else if(this.command.equals("mv")) {
			this.executeMv();
		}
		else {
			System.out.println("================================================");
			System.out.println("| Usage : [Command] [Option arg]               |");
			System.out.println("| ->Command list:(pwd, ls, cd, mkdir, whereis) |");
			System.out.println("================================================");
		}
	}
	private void executeLs() {
		if(!isExternal(this.currentNode)) {
			for(int i = 0; i < this.currentNode.getList().size(); i++) {
				System.out.println(this.currentNode.getList().get(i).getData());
			}
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
				
				int i = 0;
				int j = 0; // 찾음 유무를 알기위함
				while(i < this.currentNode.getList().size() && j==0) {
					if(dir.equals(this.currentNode.getList().get(i).getData())) {
						this.currentNode = this.currentNode.getList().get(i);
						j++;
					}
					i++;
				}
				if(j == 0)
					System.out.println("Error : Invalid option");
			}
		}
	}
	private void executeMkdir() {
		if(options.size() == 0){
		}
		else {
			String newdir = options.poll();
			
			if(this.currentNode.getList().size() < MAX)
				addChild(this.currentNode, newdir);
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
	
	private void executeRm() {
		if(options.size() == 0) {		
	}
		else {
			String opt = options.poll();
			if(opt.equals("-r")) {
				opt = options.poll(); 		//어떤 노드를 찾는지 저장				
				TreeNode foundNode = findNodes(opt);
				ArrayList<TreeNode> melist= foundNode.getParent().getList();  // 삭제하려는 트리노드가있는 리스트를 저장
				int i = 0;
				int indx = 0;
				
				while(i < melist.size()) {
					
					if(melist.get(i) == foundNode) {
						indx = i;						
					}
					i++;
				}
					
				melist.remove(indx);
				foundNode.setParent(null);
						
			}
			else{
				opt = options.poll(); 		//어떤 노드를 찾는지 저장				
				TreeNode foundNode = findNodes(opt);
				
				if(isExternal(foundNode)) {
					ArrayList<TreeNode> melist= foundNode.getParent().getList();  // 삭제하려는 트리노드가있는 리스트를 저장
					int i = 0;
					int indx = 0;
					
					while(i < melist.size()) {
						
						if(melist.get(i) == foundNode) {
							indx = i;						
						}
						i++;
					}
						
					melist.remove(indx);
					foundNode.setParent(null);
				}
				else {
					System.out.println("하위 디렉토리가 있습니다. (하위 디렉토리까지 삭제하려면 rm -r로 입력)");
				}
				
			}
		}
	}
	
	private void executeCp() {
		if(options.size() == 0) {		
		}
		else {
			String opt = options.poll();
			if(opt.equals("-r")) {
				opt = options.poll();
				Tree newTree = this;
				TreeNode CNode = newTree.findNodes(opt);	 //복사하려는 노드 찾기				
				if(isExternal(CNode)) {
					opt = options.poll();
					TreeNode VNode = findNodes(opt);
					if(VNode.getList().size() <MAX) {
						VNode.getList().add(CNode);
						CNode.setParent(VNode);
					}
					else {
						System.out.println("디렉토리가 꽉차있습니다.");
					}
				}
				
				else {
					System.out.println("하위 디렉토리가 있습니다. (하위 디렉토리까지 복사하려면 cp -r로 입력)");
				}
			}
			else {
				Tree newTree = this;
				TreeNode CNode = newTree.findNodes(opt);
				opt = options.poll();
				TreeNode VNode = findNodes(opt);
				if(VNode.getList().size() <MAX) {
					VNode.getList().add(CNode);
					CNode.setParent(VNode);
				}
				else {
					System.out.println("디렉토리가 꽉차있습니다.");
				}
			}
		}
	}
	private void executeMv() {
		this.executeCp();
		this.executeRm();
	}
}
