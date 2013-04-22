
public class BinaryTree<T> implements BinaryTreeInterface<T>, java.io.Serializable {

	private BinaryNode<T> root;
	
	public BinaryTree(){
		root = null;
	}
	
	public BinaryTree(T rootData){
		root = new BinaryNode<T>(rootData);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right){
		privateSetTree(rootData, left, right);
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	protected void setRootData(T rootData){
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNodeInterface<T> rootNode){
		root = (BinaryNode<T>) rootNode;
	}
	
	protected BinaryNodeInterface<T> getRootNode(){
		return root;
	}
	
	public T getRootData(){
		T rootData = null;
		if(root != null)
			rootData = root.getData();
		return rootData;
	}
	
	public void clear(){
		root = null;
	}
	
	public void setTree(T rootData){
		setTree(rootData, null, null);
	}
	
	public void setTree(T rootData, BinaryTreeInterface<T> left, BinaryTreeInterface<T> right){
		privateSetTree(rootData, (BinaryTree<T>) left, (BinaryTree<T>) right);
	}
	
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		root = new BinaryNode<T>(rootData);
		
		if((leftTree!=null)&&!leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		if((rightTree!=null)&&!rightTree.isEmpty()){
			if(rightTree != leftTree)
				root.setRightChild(rightTree.root);
		else
			root.setRightChild(rightTree.root.copy());
		}
		if((leftTree!=null)&&(leftTree!=this))
			leftTree.clear();
		if((rightTree!=null)&&(rightTree!=this))
			rightTree.clear();
	}
	
	public int getHeight(){
		return root.getHeight();
	}
	
	public int getNumberOfNodes(){
		return root.getNumberOfNodes();
	}
	
	
	
	/*public void inOrderTraverse(){
		inOrderTraverse(root);
	}
	
	public void inOrderTraverse(BinaryNode<T> node){
		if (node != null){
			inOrderTraverse(node.getLeftChild());
			System.out.print(node.getData());
			inOrderTraverse(node.getRightChild());
		}
	}
	
	public void inOrderTraverse(){
		
		BinaryNodeInterface<T> currentNode = root;
		
		StackInterface<BinaryNodeInterface<T>> nodeStack = new LinkedStack<BinaryNodeInterface<T>>();
		
		while(!nodeStack.isEmpty() || (currentNode != null)){
			while(currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if(!nodeStack.isEmpty(){
				BinaryNodeInterface<T> nextNode = nodeStack.pop();
				System.out.println(nextNode.getData());
				currentNode = nextNode.getRightChild();
			}
		}	
	}*/
	
}
