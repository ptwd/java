package dictionary;

public class Dictionary {
	DictionaryNode header = new DictionaryNode();
	DictionaryNode trailer = new DictionaryNode();
	
	public Dictionary() {
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public void insert(int key, String value){
		int check = 0;
		DictionaryNode temp = header.next;
		while(temp !=trailer){
			if(temp.key == key){
				check = 1;
				if(temp.filled == 10)
					System.out.println("value가 가득 찼습니다");
				else{
					temp.value[temp.filled] = value;
					temp.filled++;
					
					System.out.print(String.format("%-20s","("+key+","+value+")"));
				}
				break;
			}
			temp = temp.next;
		}
		if(check == 0)
		{
			DictionaryNode nodeNew = new DictionaryNode(key, value, trailer.prev, trailer);
			trailer.prev.setNext(nodeNew);
			trailer.setPrev(nodeNew);
			System.out.print(String.format("%-20s","("+key+","+value+")"));
		}
	}
	
	public void remove(int key){
		DictionaryNode temp = header.next;
		int check = 0;
		while(temp !=trailer){
			if(temp.key == key){
				check = 1;
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				break;
			}
			temp = temp.next;
		}
		if( check == 0)
			System.out.println("찾으려는 키가 없습니다");
			
	
	}
	
	public String find(int key){
		DictionaryNode temp = header.next;
		while(temp !=trailer){
			if(temp.key == key){
				return temp.value[0];
			}
			temp = temp.next;
		}
		return null;
	}
	public void print(){
		DictionaryNode temp = header.next;
		while(temp !=trailer){
			for(int i = 0; i < temp.filled; i++)
				System.out.print("("+temp.key+","+temp.value[i]+")");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	public String[] findAll(int key){

		DictionaryNode temp = header.next;
		while(temp !=trailer){
			if(temp.key == key){
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}

}
