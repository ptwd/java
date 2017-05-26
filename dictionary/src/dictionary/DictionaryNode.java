package dictionary;

public class DictionaryNode {
	int key;
	int filled;
	String value[] = new String[10];
	DictionaryNode prev;
	DictionaryNode next;
	
	
	public DictionaryNode()
	{
		key = 0; // 0으로 해도되나?
		filled = 0;
		prev = null;
		next = null;
	}
	public DictionaryNode(int key, String value, DictionaryNode prev, DictionaryNode next )
	{
		this.key = key;
		this.value[0] =value;
		this.filled = 1;
		this.prev = prev;
		this.next = next;
	}
	public void setPrev(DictionaryNode p) {
		prev = p;
	}
	
	public void setNext(DictionaryNode n) {
		next = n;
	}
	

}
