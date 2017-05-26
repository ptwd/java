
public class BinaryTree {
	
	TreeNode root;
	
	
	public BinaryTree(TreeNode root)
	{
		this.root = root;
	}
	
	public TreeNode left(TreeNode v){
		return v.getLeft();
	}
	
	public TreeNode right(TreeNode v){
		return v.getRight();
	}
	
	public boolean hasLeft(TreeNode v){
		if(v.getLeft() == null)
			return false;
		else
			return true;
	}
	
	public boolean hasRight(TreeNode v){
		if(v.getRight() == null)
			return false;
		else
			return true;
	}
	
	public void insertLeft(TreeNode v, String data){// 다르게 void로함
		TreeNode newNode = new TreeNode(v, data);
		v.setLeft(newNode);

	}
	
	public void insertRight(TreeNode v, String data){
		TreeNode newNode = new TreeNode(v, data);
		v.setRight(newNode);
	}
	
	public void remove(TreeNode v){
		if(!hasLeft(v) && !hasRight(v)){
			if(v.getParent().getLeft() == v)
				v.getParent().setLeft(null);
			else
				v.getParent().setRight(null);
			
			v.setParent(null);
		}
		else
			System.out.println("Exception!!");		
	}
	
	public void inOrder(TreeNode v){
		if(hasLeft(v))
			inOrder(v.getLeft());
		System.out.print(v.getData());
		if(hasRight(v))
			inOrder(v.getRight()); 
	}
	

}
