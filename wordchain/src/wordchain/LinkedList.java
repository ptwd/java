package wordchain;


public class LinkedList {
	
	Word header = new Word();
	Word trailer = new Word();
	
	public LinkedList()
	{
		header.setNext(trailer);
		trailer.setPrev(header);
	}	
	
	public void addLast(String value)
	{
		Word nodeNew = new Word(trailer.getPrev(), trailer,value);
		trailer.getPrev().setNext(nodeNew);
		trailer.setPrev(nodeNew);
	}
	
	public void printAllNodes()
	{
		Word temp = header.getNext();
		while(temp!=trailer)
		{
			System.out.println(temp.getString());
			temp = temp.getNext();
		}
		System.out.println("");
	}
	
	
	public boolean nooverlap(String value)
	{
		Word temp = header.getNext();
		while(temp!=trailer)
		{
			if(temp.getString().equalsIgnoreCase(value))
			{
				return false;
			}
			temp = temp.getNext();
		}
		return true;
	}
	
	
	public boolean compare(String value)
	{
		Word temp = trailer.getPrev();
		String s1 = temp.getString();
		if(Character.toUpperCase(s1.charAt(s1.length()-1)) == Character.toUpperCase(value.charAt(0)))
			return true;
		else return false;
	}
}