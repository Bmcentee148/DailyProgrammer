/** Represents a Deck of Cards. Will be responsible for shuffling itself, and
	dealing a card off the top **/
import java.util.Random;
import java.util.Arrays;
public class Deck {

	private final int STANDARD_SIZE = 52;
	private final Card[] cardDeck;
	private int numCards;

	public Deck() {
		numCards = STANDARD_SIZE;
		cardDeck = new Card[STANDARD_SIZE];
		int index = 0;
		for(int i = 0; i <= 3; i++) {
			for(int j = 0; j <= 12; j++) {
				cardDeck[index] = new Card(i,j);
				index++;
			}
		}
	}

	public Card dealCard() {
		Card topCard = cardDeck[numCards - 1];
		cardDeck[numCards - 1] = null;
		numCards--;
		return topCard;
	}

	public void shuffle() {
		int index;
		Card temp;
		Random rand = new Random();
		for(int i = numCards - 1; i > 0; i--) {
			index = rand.nextInt(i + 1);
			temp = cardDeck[index];
			cardDeck[index] = cardDeck[i];
			cardDeck[i] = temp;
		}
	}

	public String toString() {
		return Arrays.toString(cardDeck);
	}

	private class Card {
		private final int SUIT; // 0-3 C,D,H,S
		private final int RANK; // 0-12 A,2,3,4,5,6,7,8,9,10,J,Q,K

		public Card(int suit, int rank) {
			this.SUIT = suit;
			this.RANK = rank;
		}

		@Override
		public String toString() {
			String suitName = "", rankName = "";
			switch(SUIT) {
				case 0:
					suitName = "Clubs";
					break;
				case 1:
					suitName = "Diamonds";
					break;
				case 2:
					suitName = "Hearts";
					break;
				case 3:
					suitName = "Spades";
					break;
				default:
					suitName = "No Suit Selected";								
			}
			switch(RANK) {
				case 0:
					rankName = "Ace";
					break;
				case 1:
					rankName = "Two";
					break;
				case 2:
					rankName = "Three";
					break;
				case 3:
					rankName = "Four";
					break;
				case 4:
					rankName = "Five";
					break;
				case 5:
					rankName = "Six";
					break;
				case 6:
					rankName = "Seven";
					break;
				case 7:
					rankName = "Eight";
					break;
				case 8:
					rankName = "Nine";
					break;
				case 9:
					rankName = "Ten";
					break;
				case 10:
					rankName = "Jack";
					break;
				case 11:
					rankName = "Queen";
					break;
				case 12:
					rankName = "King";
					break;
				default:
					rankName = "No Rank Selected";																																																	
			}
			return rankName + " of " + suitName;			
		}

	} // end Card
}