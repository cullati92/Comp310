
public class LList<T> implements ListInterface<T>
	{
	 Node firstNode; // reference to first node
	 private int  length;   // number of entries in list
	 
	 //constructor
	 public LList()
	 {
	  clear();
	 } // end default constructor

	  //constructor
	 public LList(T[] items, int numberOfItems)
	 {
	  clear();
	  
	  for (int index = numberOfItems-1; index >= 0; index--)
	  add(items[index], 1); 
	  //next = null;// more efficient to add to beginning of list
	 } // end constructor
	  // ----------------------------------

	 //clears list
	 public final void clear() // NOTICE clear cannot be final in interface
	 {
	  firstNode = null;
	  length = 0;
	 } // end clear
	  
	 //ads node
	 public boolean add(T newEntry, int c)        // OutOfMemoryError possible
	 {
	  Node newNode = new Node(newEntry, c);

	  if (isEmpty())
	   firstNode = newNode;
	  else                                // add to end of nonempty list
	  {
	   Node lastNode = getNodeAt(length);
	   lastNode.next = newNode;        // make last node reference new node
	  } // end if 
	  
	  length++;
	  return true;
	 }  // end add
	 
	 //updates node with updating count
	 public void update(Node w){
		 Node newNode = firstNode;
		 while(newNode != null){
			 if(newNode.equalz(w)){
				 System.out.println("Node = " + newNode);
				 newNode.updateCount();
			 }
			 newNode = newNode.next;
		 }
	 }

	 //adds node
	  public boolean add(int newPosition, int c, T newEntry) // OutOfMemoryError possible                                                  
	 {
	  boolean isSuccessful = true;

	  if ((newPosition >= 1) && (newPosition <= length+1)) 
	  { 
	   Node newNode = new Node(newEntry, c); 

	   if (isEmpty() || (newPosition == 1))       // case 1: add to beginning of list
	   {
	    newNode.next = firstNode;       
	    firstNode = newNode;
	   }
	   else                               // case 2: list is not empty and newPosition > 1
	   {
	    Node nodeBefore = getNodeAt(newPosition - 1);
	    Node nodeAfter = nodeBefore.next;
	    newNode.next = nodeAfter;
	    nodeBefore.next = newNode;
	   } // end if 
	  
	   length++;
	  }
	  else
	   isSuccessful = false;
	   
	  return isSuccessful;
	 } // end add

	  //removes node
	 public T remove(int givenPosition)
	 {
	   T result = null;                 // return value
	   
	   if ((givenPosition >= 1) && (givenPosition <= length))
	   {
	     assert !isEmpty();
	     
	     if (givenPosition == 1)        // case 1: remove first entry
	     {
	       result = firstNode.data;     // save entry to be removed 
	       firstNode = firstNode.next;
	     }
	     else                           // case 2: givenPosition > 1
	     {
	       Node nodeBefore = getNodeAt(givenPosition - 1);
	       Node nodeToRemove = nodeBefore.next;
	       Node nodeAfter = nodeToRemove.next;
	       nodeBefore.next = nodeAfter; // disconnect the node to be removed
	       result = nodeToRemove.data;  // save entry to be removed
	     } // end if
	     
	     length--;
	   } // end if
	   
	   return result;                   // return removed entry, or 
	                                    // null if operation fails
	 } // end remove

	 //replaces entry with new entry
	 public boolean replace(int givenPosition, T newEntry)
	 {
	  boolean isSuccessful = true;

	    if ((givenPosition >= 1) && (givenPosition <= length))
	    {   
	     assert !isEmpty();

	   Node desiredNode = getNodeAt(givenPosition);
	   desiredNode.data = newEntry;
	    }    
	  else
	   isSuccessful = false;
	   
	  return isSuccessful;
	  } // end replace

	  public T getEntry(int givenPosition)
	  {
	   T result = null;  // result to return
	      
	  if ((givenPosition >= 1) && (givenPosition <= length))
	  {
	   assert !isEmpty();
	      result = getNodeAt(givenPosition).data;
	    } // end if
	      
	    return result;
	  } // end getEntry
	  
	  
	 
	@SuppressWarnings("unchecked")
	//checks if linked list contains element
	public boolean contains(T anEntry)
	 {
	  boolean found = false;
	  Node currentNode = firstNode;
	  
	  while (!found && (currentNode != null))
	  {
	   if (((Node) anEntry).equalz(currentNode))
	    found = true;
	   else
	    currentNode = currentNode.next;
	  } // end while
	  
	  return found;
	 } // end contains

	  public int getLength()
	  {
	     return length;
	  } // end getLength
	  
	  //checks if empty
	  public boolean isEmpty()
	  {
	   boolean result;
	   
	    if (length == 0) // or getLength() == 0
	    {
	     assert firstNode == null;
	     result = true;
	    }
	    else
	    {
	     assert firstNode != null;
	     result = false;
	    } // end if
	    
	    return result;
	  } // end isEmpty
	 
	  //checks if full
	  public boolean isFull()
	  {
	     return false;
	  } // end isFull
	  
	  //displays data
	  public void display()
	  {
	      
	   // iterative
	   Node currentNode = firstNode;
	  while (currentNode != null)
	  { 
	   System.out.println(currentNode.data + "," + currentNode.count);
	    currentNode = currentNode.next; 
	  } // end while  

	  // recursive
	// displayChain(firstNode);
	// System.out.println();
	  } // end display

	 /* private void displayChain(Node nodeOne) 
	 { 
	  if (nodeOne != null)
	  {
	   System.out.print(nodeOne.getData() + " ");
	   displayChain(nodeOne.getNext());
	  } // end if
	 } // end displayChain*/

	 /** Task: Returns a reference to the node at a given position.
	  *  Precondition: List is not empty; 1 <= givenPosition <= length. */
	 private Node getNodeAt(int givenPosition)
	 {
	  assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= length);
	  Node currentNode = firstNode;
	  
	    // traverse the list to locate the desired node
	  for (int counter = 1; counter < givenPosition; counter++)
	   currentNode = currentNode.next;
	  
	  assert currentNode != null;
	  return currentNode;
	 } // end getNodeAt

	 class Node 
	 {
	   private T    data; // entry in list
	   private int count;
	   private Node next; // link to next node

	   //constructor
	   Node(){
		   data = null;
		   count = 0;
		   next = null;
	   }

	   //constructor
	  Node(T dataPortion, int c)
	  {
	   data = dataPortion;
	   count = c;
	   next = null; 
	  } // end constructor
	  
	  //constructor
	  public Node(T dataPortion, int c, Node nextNode)
	  {
		  count = c;
		  data = dataPortion;
		  next = nextNode; 
	  } // end constructor
	  
	  //accessor
	  public Node getNext(){
		  return next;
	  }
	  
	  //accessor
	  public T getData(){
		  return data;
	  }
	  
	  //accessor
	  public int getCount(Node n){
		  while(next != null){
		  if(data == n.data)
			  count += 1;
		  }
		  return count;
	  }
	  
	  //increments count
	  public void updateCount(){
		  count += 1;
		  System.out.println("Count = " + count);
		  
	  }
	  
	  //accessor
	  public int getCount(){
		  return count;
	  }
	  
	  //mutator
	  public void setNext(Node newNext){
		  next = newNext;
	  }
	  
	  //mutator
	  public void setCount(int newCount){
		  count = newCount;
	  }
	  
	  //mutator
	  public void setData(T newData){
		  data = newData;
	  }
	  
	  //overrides equals method
	  public boolean equalz(Object o) {
		  
	        // If the object is compared with itself then return true  
	        if (o.toString().compareTo(this.toString()) == 0) {
	            return true;
	        }
	 
	        
	        return false;
	    }
	  
	  
	  //returns string of object
	  public String toString(){
		  String s = "";
		  s += getData();
		  return s;
	  }
	  
	  
	 } // end Node

	
	
}