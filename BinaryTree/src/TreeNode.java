
public class TreeNode {
	
	private String data;
	private TreeNode right;
	private TreeNode left;
	private TreeNode parent;
	
	public TreeNode(){
		this.data = null;
		this.right = null;
		this.left = null;
		this.parent = null;
	}
	
	public TreeNode(TreeNode parent, String data){
		this.data = data;
		this.right = null;
		this.left = null;
		this.parent = parent;
	}
	
	public String getData(){
		return this.data;
	}
	
	public TreeNode getLeft(){
		return this.left;
	}
	
	public TreeNode getRight(){
		return this.right;
	}
	
	public TreeNode getParent(){
		return this.parent;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
	
	
	public void setParent(TreeNode parent){
		this.parent = parent;
	}
	
	
	
	


}
