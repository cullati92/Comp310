import java.util.Random;




public class Pile {
		  
	  protected int nCards;   // number of elements
	  protected Card topCard; // sentinels
	  protected Card bottomCard;
	  
	  /** Constructor that creates an empty list */
	  public Pile() { 
		nCards = 0;
	    topCard = new Card(null, null, null, null); // create header
	    bottomCard = new Card(null, null, topCard, null); // create trailer
	    topCard.setNext(bottomCard); // make header and trailer point to each other
	  }
	  
	  /** Returns the number of elements in the list */
	  public int size() { return nCards + 1; }
	  
	  /** Returns whether the list is empty */
	  public boolean isEmpty() { return (nCards == 0); }
	  /** Returns the first node of the list */
	  
	  public Card getFirst() throws IllegalStateException {
	    if (isEmpty()) throw new IllegalStateException("List is empty");
	    return topCard.getNext();
	  }
	  
	  /** Returns the last node of the list */
	  public Card getLast() throws IllegalStateException {
	    if (isEmpty()) throw new IllegalStateException("List is empty");
	    return bottomCard.getPrev();
	  }
	  
	  /** Returns the node before the given node v. An error occurs if v
	    * is the header */
	  public Card getPrev(Card v) throws IllegalArgumentException {
	    if (v == topCard) throw new IllegalArgumentException
	      ("Cannot move back past the header of the list");
	    return v.getPrev();
	  }
	  
	  /** Returns the node after the given node v. An error occurs if v
	    * is the trailer */
	  public Card getNext(Card v) throws IllegalArgumentException {
	    if (v == bottomCard) throw new IllegalArgumentException
	      ("Cannot move forward past the trailer of the list");
	   return v.getNext();
	  }
	  
	  /** Inserts the given node z before the given node v. An error
	    * occurs if v is the header */
	  public void addBefore(Card v, Card z) throws IllegalArgumentException {
	    Card u = getPrev(v); // may throw an IllegalArgumentException
	    z.setPrev(u);
	    z.setNext(v);
	    v.setPrev(z);
	    u.setNext(z);
	    nCards++;
	  }
	
	  /** Inserts the given node z after the given node v. An error occurs
	    * if v is the trailer */
	  public void addAfter(Card v, Card z) {
	    Card w = getNext(v); // may throw an IllegalArgumentException
	    z.setPrev(v);
	    z.setNext(w);
	    w.setPrev(z);
	    v.setNext(z);
	    nCards++;
	  }
	  
	  /** Inserts the given node at the head of the list */
	  public void addFirst(Card v) {
	    addAfter(topCard, v);
	  }
	  
	  /** Inserts the given node at the tail of the list */
	  public void addLast(Card v) {
	    addBefore(bottomCard, v);
	  }
	  
	  /** Removes the given node v from the list. An error occurs if v is
	    * the header or trailer */
	  public void remove(Card v) {
	    Card u = getPrev(v); // may throw an IllegalArgumentException
	    Card w = getNext(v); // may throw an IllegalArgumentException
	    // unlink the node from the list 
	    
	    if(w != null){
		    w.setPrev(u);
		    u.setNext(w);
		    v.setPrev(null);
		    v.setNext(null);
		    nCards--;
	    }
	    
		}
	  
	  /** Returns whether a given node has a previous node */
	  public boolean hasPrev(Card v) { return v != topCard; }
	  
	  /** Returns whether a given node has a next node */
	  public boolean hasNext(Card v) { return v != bottomCard; }
	  
	  /** Returns a string representation of the list */
	  public String toString() {
	    String s = "[";
	    Card v = topCard.getNext();
	    while (v != bottomCard) {
	      s += v.getFace() + " " + v.getSuit();
	      v = v.getNext();
	      if (v != bottomCard)
	        s += ",";
	    }
	    s += "]";
		    return s;
	  }
	  //returns number for face of card
	  public int faceNumber(Card c){
		  if(c.getFace() != null){
		  if(c.getFace().equals("A"))
			  return 1;
		  if(c.getFace().equals("2"))
			  return 2;
		  if(c.getFace().equals("3"))
			  return 3;
		  if(c.getFace().equals("4"))
			  return 4;
		  if(c.getFace().equals("5"))
			  return 5;
		  if(c.getFace().equals("6"))
			  return 6;
		  if(c.getFace().equals("7"))
			  return 7;
		  if(c.getFace().equals("8"))
			  return 8;
		  if(c.getFace().equals("9"))
			  return 9;
		  if(c.getFace().equals("10"))
			  return 10;
		  if(c.getFace().equals("J"))
			  return 11;
		  if(c.getFace().equals("Q"))
			  return 12;
		  if(c.getFace().equals("K"))
			  return 13;
		  }
		  return 0; 
	  }
	  //searches for a specific card
	  public boolean search(Card c){
		  Card current = topCard.getNext();
		  
		  while(current != bottomCard){
			 if(compareTwo(current, c) == 2)
				 return true;
			 current = current.getNext();
		  }
		  
		  return false;
	  }
	  
	  
	  //returns a spcific card
	 public Card getCard(Card c){
		 Card current = topCard.getNext();
		 while(!search(c)){
		 	current = current.getNext();
		 }
		 return current;
	  }
	  //compares two cards using facenumber
	  public int compareTwo(Card c, Card d){
		  if(faceNumber(c) > faceNumber(d)){
			  return 1;
		  }else if(faceNumber(c) == faceNumber(d)){
			  return 2;
		  }
		  return 0;
	  }
	  
	 //swaps faces and suits of two cards. 
	public void swap(Card c, Card d){
		  Card temp = new Card(null, null, null, null);
		  if(c != null && d != null){
			  temp.setFace(c.getFace());
			  c.setFace(d.getFace());
			  d.setFace(temp.getFace());
			  temp.setSuit(c.getSuit());
			  c.setSuit(d.getSuit());
			  d.setSuit(temp.getSuit());
			  
		  }
	  }
	//splits the pile in half
	public void split(){
		Card current = topCard.getNext();
		Card compare = topCard.getNext();
		if(nCards%2 == 0){
			for(int i=0;i<((nCards)/2);i++){
				compare = compare.getNext();
			}
		}else{
			for(int i=0;i<((nCards+1)/2);i++){
				compare = compare.getNext();
			}
		}
		System.out.println(compare);
		//Card middle = compare;
		while(compare != bottomCard){
			swap(current, compare);
			current = current.getNext();
			System.out.println(current);
			compare = compare.getNext();
		}
		
		
		
	}
	  //sorts the deck by faces ex: aces, twos, threes, etc.
	  public void sort(){
		  Card current = topCard.getNext();
		  
		  while(current != bottomCard.getPrev()){
			  Card compare = current.getNext();
			  while(compare != bottomCard.getPrev()){
				  if(compareTwo(current, compare) == 1){
					  swap(current, compare);
				  }else if(compareTwo(current, compare) == 2){
					  swap(compare,current.getNext());
				  }
				  
				  compare = compare.getNext();
			  }
			  
			  current = current.getNext();
		  }
	  }
		  //shuffles the cards randomly
	  public void shuffle(){
		  Random rand = new Random();
		  Card current = topCard.getNext();
		  
		  
		  Card compare = topCard.getNext();
		  
		  
		  for (int j = 0; j < 200; ++j) {
			  for(int i=0; i < rand.nextInt(51);i++){
				  current = current.getNext();
			  }
		  
			  for(int l=0; l < rand.nextInt(51);l++){
				  compare = compare.getNext();
			  }
			  swap(current, compare);
			  
		  }
	  }
	  
	  
	  
	public static void main(String[] args){
		
		Card[] card = new Card[53];//adds all 52 cards to deck
		card[0] = new Card("A", "Spades", null, null);
		card[1] = new Card("2", "Spades", null, null);
		card[2] = new Card("3", "Spades", null, null);
		card[3] = new Card("4", "Spades", null, null);
		card[4] = new Card("5", "Spades", null, null);
		card[5] = new Card("6", "Spades", null, null);
		card[6] = new Card("7", "Spades", null, null);
		card[7] = new Card("8", "Spades", null, null);
		card[8] = new Card("9", "Spades", null, null);
		card[9] = new Card("10", "Spades", null, null);
		card[10] = new Card("J", "Spades", null, null);
		card[11] = new Card("Q", "Spades", null, null);
		card[12] = new Card("K", "Spades", null, null);
		card[13] = new Card("A", "Clubs", null, null);
		card[14] = new Card("2", "Clubs", null, null);
		card[15] = new Card("3", "Clubs", null, null);
		card[16] = new Card("4", "Clubs", null, null);
		card[17] = new Card("5", "Clubs", null, null);
		card[18] = new Card("6", "Clubs", null, null);
		card[19] = new Card("7", "Clubs", null, null);
		card[20] = new Card("8", "Clubs", null, null);
		card[21] = new Card("9", "Clubs", null, null);
		card[22] = new Card("10", "Clubs", null, null);
		card[23] = new Card("J", "Clubs", null, null);
		card[24] = new Card("Q", "Clubs", null, null);
		card[25] = new Card("K", "Clubs", null, null);
		card[26] = new Card ("A", "Hearts", null, null);
		card[27] = new Card ("2", "Hearts", null, null);
		card[28] = new Card ("3", "Hearts", null, null);
		card[29] = new Card ("4", "Hearts", null, null);
		card[30] = new Card ("5", "Hearts", null, null);
		card[31] = new Card ("6", "Hearts", null, null);
		card[32] = new Card ("7", "Hearts", null, null);
		card[33] = new Card ("8", "Hearts", null, null);
		card[34] = new Card ("9", "Hearts", null, null);
		card[35] = new Card ("10", "Hearts", null, null);
		card[36] = new Card ("J", "Hearts", null, null);
		card[37] = new Card ("Q", "Hearts", null, null);
		card[38] = new Card ("K", "Hearts", null, null);
		card[39] = new Card ("A", "Diamonds", null, null);
		card[40] = new Card ("2", "Diamonds", null, null);
		card[41] = new Card ("3", "Diamonds", null, null);
		card[42] = new Card ("4", "Diamonds", null, null);
		card[43] = new Card ("5", "Diamonds", null, null);
		card[44] = new Card ("6", "Diamonds", null, null);
		card[45] = new Card ("7", "Diamonds", null, null);
		card[46] = new Card ("8", "Diamonds", null, null);
		card[47] = new Card ("9", "Diamonds", null, null);
		card[48] = new Card ("10", "Diamonds", null, null);
		card[49] = new Card ("J", "Diamonds", null, null);
		card[50] = new Card ("Q", "Diamonds", null, null);
		card[51] = new Card("K", "Diamonds", null, null);
		
		
		Pile deck = new Pile();
		
		
		deck.addFirst(card[0]);
		deck.addLast(card[51]);

		
		for (int i=0; i< 50;i++) 
			deck.addAfter(card[i], card[i+1]);
		
		
		System.out.println("Here is the pile of cards: " + deck);
		deck.remove(card[50]);//removes a card
		if(deck.search(card[30]))//searches for card 30
			System.out.println("Found");
		System.out.println("Here is the pile of cards: " + deck);
		deck.sort();//sorts deck
		System.out.println("The deck sorted is: " + deck);
		deck.split();//splits deck
		System.out.println("The deck split in half: " + deck);
		deck.shuffle();//shuffles deck
		System.out.println("The deck shuffled is: " + deck);
		
		
	}
}

