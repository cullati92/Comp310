import java.util.Scanner;


public class BinaryTreeTest {
	
		 
		   class Node {
		    Node left;
		    Node right;
		 
		    int x;
		    int y;
		 
		    public Node(int x, int y) {
		      this.x = x;
		      this.y = y;
		    }
		    
		    public String toString(){
		    	String s = "Node (";
		    	s += x + "," + y;
		    	s += ")";
		    	return s;
		    }
		  }
		 
		  public void run() {
		    // build the simple tree from chapter 11.
		    Node root = new Node(20, 20);
		    int x = 0;
		    int y = 0;
		    String ans;
		    System.out.println("Binary Tree Example");
		    System.out.println("Building tree with root value: (" + root.x + "," + root.y + ").");
		    Scanner keyboard = new Scanner(System.in);
		    do{
		    	root.left = new Node (10, 15);
			    root.right =  new Node(30, 10);
			    System.out.println("Enter an x and y coordinate: ");
			    x = keyboard.nextInt();
			    y = keyboard.nextInt();
			    insert(root, x, y);
			    
			    System.out.println("Traversing tree in order");
			    printInOrder(root);
			    System.out.println("Would you like to add another node? (Y/N)");
			    ans = keyboard.next();
		    }while(ans.equals("Y") || ans.equals("y"));
		    //System.out.println("Traversing tree front-to-back from location 7");
		    //printFrontToBack(root, 7);
		  }
		 
		  
		  
		  public void insert(Node node, int x, int y){
			  if(node != null){
				  if(x < node.x){
					  if(node.left != null){
						  if(y<node.left.y){
							 if(node.left.left != null){
								 insert(node.left.left, x, y);
							 } else{
								 node.left.left = new Node(x, y);
								 System.out.println("  Inserted (" + x + "," + y + ") to left of ("
								            + node.left.x + "," + node.left.y + ").");
							 }
						  }else if(y > node.left.y){
							  if(node.left.right != null){
								  insert(node.left.right, x, y);
							  } else{
								  node.left.right = new Node(x, y);
								  System.out.println("  Inserted (" + x + "," + y + ") to right of ("
								            + node.left.x + "," + node.left.y + ").");
							  }
						  }
					  }else{
						  node.left = new Node(x, y);
						  System.out.println("  Inserted (" + x + "," + y + ") to left of ("
						            + node.x + "," + node.y + ").");
					  }
				 }else if(x > node.x){
					  if(node.right != null){
						  if(y < node.right.y){
							  if(node.right.left != null){
								  insert(node.right.left, x, y);
							  } else {
								  node.right.left = new Node(x, y);
								  System.out.println("  Inserted (" + x + "," + y + ") to left of ("
								            + node.right.x + "," + node.right.y + ").");
							  }
						  }else if(y > node.right.y){
							  if(node.right.right != null){
								  insert(node.right.right, x, y);
							  } else{
								  node.right.right = new Node(x, y);
								  System.out.println("  Inserted (" + x + "," + y + ") to right of ("
								            + node.right.x + "," + node.right.y + ").");
							  }
						  }
					  }else{
						  node.right = new Node(x, y);
						  System.out.println("  Inserted (" + x + "," + y + ") to right of ("
						            + node.x + "," + node.y + ").");
					  }
				 }
			  }
		 }
		 
		  public void printInOrder(Node node) {
		    if (node != null) {
		      printInOrder(node.left);
		      System.out.println("  Traversed (" + node.x + "," + node.y + ").");
		      printInOrder(node.right);
		    }
		  }
		 
		  /**
		   * uses in-order traversal when the origin is less than the node's value
		   * 
		   * uses reverse-order traversal when the origin is greater than the node's
		   * order
		   */
		  public void printFrontToBack(Node node, int camera) {
		    if (node == null)
		      return;
		    if (node.x > camera) {
		      // print in order
		      printFrontToBack(node.left, camera);
		      System.out.println("  Traversed (" + node.x + "," + node.y + ").");
		      printFrontToBack(node.right, camera);
		    } else if (node.x < camera) {
		      // print reverse order
		      printFrontToBack(node.right, camera);
		      System.out.println("  Traversed (" + node.x + "," + node.y + ").");
		      printFrontToBack(node.left, camera);
		    } else {
		      // order doesn't matter
		      printFrontToBack(node.left, camera);
		      printFrontToBack(node.right, camera);
		    }
		  }
		  
		  
			
		private boolean lookup(Node node, int data) { 
		    if (node==null) { 
		      return(false); 
		    }

		    if (data==node.x && data==node.y) { 
		      return(true); 
		    } 
		    else if (data<node.x) { 
		      return(lookup(node.left, data)); 
		    } 
		    else { 
		      return(lookup(node.right, data)); 
		    } 
		  } 
		 
		public static void main(String[] args){
			new BinaryTreeTest().run();
		}
}
