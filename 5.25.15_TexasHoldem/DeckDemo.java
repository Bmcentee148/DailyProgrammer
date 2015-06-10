
public class DeckDemo {

	public static void main(String[] args) {
		Deck testDeck = new Deck();
		System.out.println(testDeck);
		testDeck.shuffle();
		System.out.println(testDeck);
		System.out.println(testDeck.dealCard());
		System.out.println(testDeck);
		for(int i = 0; i < 5; i++) {
			System.out.println(testDeck.dealCard());
		}
		System.out.println(testDeck);
	}
}