
public class Card {
	Card next;
	Card previous;
	private String face, suit;
	//constructor
	public Card(String initialFace, String initialSuit, Card n, Card p){
		face = initialFace;
		suit = initialSuit;
		next = n;
		previous = p;
	}
	//accessor
	public String getFace(){
		return face;
	}
	//accessor
	public String getSuit(){
		return suit;
	}
	//accessor
	public Card getNext(){
		return next;
	}
	//accessor
	public Card getPrev(){
		return previous;
	}
	//mutator
	public void setNext(Card newNext){
		next = newNext;
	}
	//mutator
	public void setPrev(Card newPrevious){
		previous = newPrevious;
	}
	
	//mutator
	public void setSuit(String newSuit){
		suit = newSuit;
	}
	//mutator
	public void setFace(String newFace){
		face = newFace;
	}
	//returns string representation of objects
	public String toString(){
		return "[" + face + " " + suit + "]";
	}
	
	public static void main(String[] args){
		Card[] card = new Card[2];
		card[0] = new Card("Nine", "Hearts", null, null);//creates cards
		card[1] = new Card("Nine", "Diamonds", null, null);
		
		card[0].setNext(card[1]);
		card[1].setPrev(card[0]);
		System.out.println(card[0].getNext());
		System.out.println(card[1].getPrev());
	}
	
	
}
