package midterm2;

import java.util.ArrayList;

public class TreeNode {
	private String data;
	private TreeNode parent;
	private ArrayList<TreeNode> Child_list;

	public TreeNode() {
		this.parent = null;
		this.data = null;
		this.Child_list = new ArrayList<TreeNode> ();
	}
	public TreeNode(String data, TreeNode parent) {
		this.parent = parent;
		this.data = data;
		this.Child_list = new ArrayList<TreeNode> ();
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ArrayList<TreeNode> getList() {
		return this.Child_list;
	}
	public void setList(ArrayList<TreeNode> list) {
		this.Child_list = list;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
}
