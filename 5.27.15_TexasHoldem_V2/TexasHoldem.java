import java.util.Scanner;
public class TexasHoldem {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("How many players (2-8) ?");
		int numPlayers = kb.nextInt();

		Deck gameDeck = new Deck();
		gameDeck.shuffle();

		for(int i = 0; i < numPlayers; i++) {
			if(i == 0) System.out.print("Your hand: ");
			else { System.out.print("CPU " + i + " hand: "); }
			System.out.print(gameDeck.dealCard() + ", ");
			System.out.println(gameDeck.dealCard());
		}

		System.out.print("Flop: ");
		System.out.print(gameDeck.dealCard() + ", ");
		System.out.print(gameDeck.dealCard() + ", ");
		System.out.println(gameDeck.dealCard());

		System.out.print("Turn: ");
		System.out.println(gameDeck.dealCard());

		System.out.print("River: ");
		System.out.println(gameDeck.dealCard());





	}
}