
public class ArrayQueue<T> implements QueueInterface<T> {

	private T [] queue;
	private int frontIndex;
	private int backIndex;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	//default constructor
	public ArrayQueue()
	{
		this (DEFAULT_INITIAL_CAPACITY);
	}
	
	//constructor with parameters
	public ArrayQueue (int initialCapacity)
	{
		queue = (T[]) new Object[initialCapacity + 1];
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	//adds an element to the queue array
	public void enqueue (T newEntry)
	{
		if (isArrayFull())
			doubleArray();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}
	
	//gets element in front on queue
	public T getFront()
	{
		T front = null;
		if (!isEmpty())
			front = queue [frontIndex];
		return front;
	}
	
	//deletes front element in array queue
	public T dequeue()
	{
		T front = null;
		if (!isEmpty()){
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		return front;
	}
	
	//entends length of array
	public void doubleArray()
	{
		T[] oldQueue = queue;
		int oldSize = oldQueue.length;
		queue = (T[])new Object[2*oldSize];
		
		for(int i=0; i<(oldSize - 1); i++){
			queue[i] = oldQueue[frontIndex];
			frontIndex = (frontIndex + 1) % oldSize;
		}
		frontIndex = 0;
		backIndex = oldSize - 2;
	}
	
	//checks whether queue is empty
	public boolean isEmpty()
	{
		return frontIndex == ((backIndex+1) % queue.length);
	}
	
	//checks whether queue is full
	private boolean isArrayFull()
	{
		return frontIndex == ((backIndex + 2) % queue.length);
	}
	
	public static void main(String args [])
	{
		ArrayQueue<Integer> number = new ArrayQueue<Integer>(); //instance of queue
		number.enqueue(6); //adds numbers to queue
		number.enqueue(8);
		number.enqueue(10);
		number.enqueue(12);
		System.out.print(number.getFront() + "\n");
		number.dequeue(); //deletes front number
		System.out.print(number.getFront() + "\n");
		number.clear(); //clears queue
		number.enqueue(5);
		System.out.print(number.getFront() + "\n");
		
		
		
	}

	//empties array queue
	public void clear() {
		while(!isEmpty()){
			dequeue();
		}	
	}
}
