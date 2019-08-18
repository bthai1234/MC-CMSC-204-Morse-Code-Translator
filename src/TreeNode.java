/**
 * node class for tree MorseCodeTree class
 * @author bthai
 *
 * @param <T>
 */
public class TreeNode<T> {
	private T data; /**data the node*/
	private TreeNode<T> left ; /**left child node*/
	private TreeNode<T> right; /**right child node*/

	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 * 
	 */
	public TreeNode(T dataNode){
		data = dataNode;
		left = null;
		right = null;
	}
	
	/**
	 * used for making deep copies
	 * @param node
	 */
	public TreeNode(TreeNode<T> node){
		data = node.getData();
		left = node.getLeft();
		right = node.getRight();
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData(){
		return data;
	}
	
	/**
	 * Return the left node
	 * @return the left node 
	 */
	public TreeNode<T> getLeft(){
		return left;
	}
	
	/**
	 * Return the right node
	 * @return the right node 
	 */
	public TreeNode<T> getRight(){
		return right;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	/**
	 * Return the left node
	 * @return the left node 
	 */
	public void setLeft(TreeNode<T> e){
		left = e;
	}
	
	/**
	 * Return the right node
	 * @return the right node 
	 */
	public void setRight(TreeNode<T> e){
		right = e;
	}

}
