import java.util.ArrayList;

/**
 * tree used to convert morse code class builds a tree with letters in order corresponding to morse code
 * @author bthai
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	/**
	 * constructor
	 */
	public MorseCodeTree(){
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter){
		if(code.length() == 1){
			if(code.equals(".")){
				root.setLeft(new TreeNode<String>(letter));
				return;
				
			}else if(code.equals("-")){
				root.setRight(new TreeNode<String>(letter));
				return;
			}
		}else{
			if(code.charAt(0) == '.'){
				addNode(root.getLeft(), code.substring(1), letter);
			}else
				addNode(root.getRight(), code.substring(1), letter);
		}
		
	}
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	public MorseCodeTree insert(String code, String letter){
		addNode(root,code,letter);
		return this;
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1){
			if(code.equals(".")){
				return root.getLeft().getData();
			}else if(code.equals("-")){
				return root.getRight().getData();
			}
		}else{
			if(code.charAt(0) == '.'){
				return fetchNode(root.getLeft(),code.substring(1));

			}else{
				return fetchNode(root.getRight(), code.substring(1));

			}
		}
		return null;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	public void buildTree() {
		setRoot(new TreeNode<String>(""));//root level 0
		insert(".", "e"); insert("-", "t");//level 1
		insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m");// level 2
		insert("...", "s"); insert("..-", "u"); insert(".-.", "r");insert(".--", "w");//level 3  left
		insert("-..", "d"); insert("-.-", "k"); insert("--.", "g"); insert("---", "o"); //two null nodes level 3 right
		insert("....", "h"); insert("...-", "v"); insert("..-.", "f"); /*null node*/ insert(".-..", "l"); /*null*/ insert(".--.", "p"); insert(".---", "j"); //level 4 left
		insert("-...", "b"); insert("-..-", "x"); insert("-.-.", "c"); insert("-.--", "y"); insert("--..", "z"); insert("--.-", "q");//level 4 right
		
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		TreeNode<String> root =getRoot();
		LNRoutputTraversal(root, list);
		return list;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null){
			return;
		}
		LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(),list);
	}
}
