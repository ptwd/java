package homework3;

public class List {
	
	private ListNode header;
	private ListNode trailer;
	
	public List() {
		header = new ListNode();
		trailer = new ListNode();
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
	}
	
	public ListNode getHeader() {
		return header;
	}
	
	public void setHeader(ListNode header) {
		this.header = header;
	}
	public ListNode getTrailer() {
		return trailer;
	}
	
	public void setTrailer(ListNode trailer) {
		this.trailer = trailer;
	}
	
	public void initialization() {
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
	}
	
	public void addLast(String command) {
		ListNode newNode = new ListNode(trailer.getPrevNode(), trailer, command);
		trailer.getPrevNode().setNextNode(newNode);
		trailer.setPrevNode(newNode);
	}
	public void addFirst(String command) {
		ListNode newNode = new ListNode(header ,header.getNextNode(), command);
		trailer.getNextNode().setPrevNode(newNode);
		trailer.setNextNode(newNode);
	}
	public ListNode getNode(int i) {
		ListNode temp = header.getNextNode();
		for(int c = 0; c < i; c++) {
			temp = temp.getNextNode();
		}
		return temp;
	}
}
