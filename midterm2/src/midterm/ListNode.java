package midterm2;

public class ListNode {
	private String command;
	private ListNode nextNode;
	private ListNode prevNode;
	
	
	public ListNode() {
		this.prevNode = null;
		this.nextNode = null;
		this.command = null;
	}
	
	public ListNode(ListNode prevNode, ListNode nextNode, String command){
		this.prevNode = prevNode;
		this.nextNode = nextNode;
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	public ListNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(ListNode nextNode) {
		this.nextNode = nextNode;
	}
	public ListNode getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(ListNode prevNode) {
		this.prevNode = prevNode;
	}

}
