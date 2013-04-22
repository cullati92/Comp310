
public interface QueueInterface<T> 
{
	 public void  enqueue (T newEntry); //adds node to queue
	 public T dequeue (); //deletes first node from queue
	 public T getFront (); //gets first node
	 public boolean isEmpty (); // checks whether queue is empty
	 public void  clear (); //clears queue
}

	