//Chris Cullati
//Comp 310 Professor Assiter

public class StackImplementation<E> implements StackInterface<E>{

	private int capacity;
	public static final int CAPACITY = 1000;
	private E[] stack;
	private int topIndex = -1;
	
	//Default constructor
	public StackImplementation(){
		this(CAPACITY);
	}
	
	//Constructor for specific size
	@SuppressWarnings("unchecked")
	public StackImplementation(int cap){
		capacity = cap;
		stack = (E[]) new Object[capacity];
	}
	
	//Returns size of the stack
	public int size(){
		return (topIndex + 1);
	}
	
	//Checks whether the stack is empty
	public boolean isEmpty(){
		return (topIndex < 0);
	}
	
	//Pops the top element off the stack
	public E pop() {
		E element;
		if(isEmpty())
			return null;
		element = stack[topIndex];
		stack[topIndex--] = null;
		return element;
	}

	//Adds element to the stack
	public void push(E element) {
		if(size() != capacity)
			stack[++topIndex] = element;
	}
	
	//Shows user top element in stack
	public E peek(){
		if(isEmpty())
			return null;
		return stack[topIndex];
	}
	
	//Outputs information about the stack
	public String toString(){
		String s;
		s = "[";
		if (size() > 0)
			s += stack[0];
		if(size() > 1)
			for(int i=1; i <= size()-1; i++){
				s += "," + stack[i];
			}
		return s + "]";
	}
	

	public static void main(String args[]){
		StackImplementation<Integer> iStack = new StackImplementation<Integer>();
		iStack.push(8);
		iStack.push(9);
		System.out.print(iStack);
		System.out.print("\n");
		System.out.print(iStack.pop());
		System.out.print(iStack.pop());
		System.out.print(iStack);
		
		StackImplementation<String> sStack = new StackImplementation<String>();
		sStack.push(new String("s1"));
		System.out.print(sStack);
		System.out.print("\n");
		sStack.push(new String("s2"));
		System.out.print(sStack);
		System.out.print("\n");
		sStack.push(new String("s3"));
		System.out.print(sStack);
		while(!sStack.isEmpty()){
			System.out.print(sStack.pop());
		}
		
	}
	
}
