//Chris Cullati
//Comp 310 Professor Assiter

package Assignment2;

public interface CalculatorInterface<E> {
	public E peek(); //shows top node
	public void clear(); //clears stack
	public int size(); //returns size of stack
	public boolean isEmpty(); //check whether stack is empty
	public E pop(); //pops off top node
	public void push(E element); //pushed element on top of stack
}