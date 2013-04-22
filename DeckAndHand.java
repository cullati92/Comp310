
public class DeckAndHand {

	Pile deck = new Pile();
	Pile hand = new Pile();
	Pile stock = new Pile();
	
	
	//deals a card to a player
	public void deal(){
		hand.addFirst(deck.topCard.getNext());
		deck.remove(deck.topCard.getNext().getNext());
		for(int i=0;i<5;i++){
			hand.addAfter(hand.topCard.getNext(),deck.topCard.getNext());
			deck.remove(deck.topCard.getNext().getNext());
		}
		//hand.sort();
	}
	
	//sets a deck to have one of each card
	public void setDeck(){
		Card card[] = new Card[52];
		/*String[] face = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] suit = {"Spades", "Clubs", "Hearts", "Diamonds"};
		for(String f : face){
			for(String s : suit){
				for(int i=0;i<52;i++)
				 card[i] = new Card(f, s, null, null);
			}
		}*/
		
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
		
		hand.addFirst(card[0]);
		hand.addLast(card[51]);
		for(int i=0;i<hand.nCards-2;i++){
			hand.addAfter(card[i], card[i+1]);
		}
		
		//for(int j=0;j<52;j++)
		//	System.out.print(c[j]);
	}
	
	//returns cards in hand
	public String toString(){
		String s = "<Hand(";
		s += hand;
		s += ")";
		return s;
	}
	
	public static void main(String[] args){
		DeckAndHand deck = new DeckAndHand();
		DeckAndHand hand1 = new DeckAndHand();
		deck.setDeck();
		hand1.deal();
			System.out.print(hand1);
	}
}
