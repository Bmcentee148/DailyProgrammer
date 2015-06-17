import java.util.Scanner;

public class LumberPiles {

	private int logsToPlace;
	private int[][] pile;
	
	public LumberPiles(int size, int logsToPlace) {
		pile = new int[size][size];
		this.logsToPlace = logsToPlace;
	}

	public void setPiles(int[][] initialPile) {
		for(int i = 0; i < pile.length; i++) {
			for(int j = 0; j < pile[0].length; j++) {
				pile[i][j] = initialPile[i][j];
			}
		}
	}

	public void placeLogs() {
		int minPileSize = getMinimumPileSize();
		while(logsToPlace > 0) {
			for(int i = 0; i < pile.length; i++) {
				for(int j = 0; j < pile[0].length; j++) {
					if(pile[i][j] == minPileSize && logsToPlace > 0) {
						pile[i][j]++;
						logsToPlace--;
					}
				}
			}
			minPileSize++;
		}
	}

	private int getMinimumPileSize() {
		int minSize = pile[0][0];
		for(int i = 0; i < pile.length; i++) {
			for(int j = 0; j < pile[0].length; j++) {
				if(pile[i][j] < minSize) {
					minSize = pile[i][j];
				}
			}
		}
		return minSize;
	}

	public void showPiles() {
		for(int i = 0; i < pile.length; i++) {
			for(int j = 0; j < pile[0].length; j++) {
				System.out.print(pile[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int size = kb.nextInt();
		int logs = kb.nextInt();

		int[][] inputPiles = new int[size][size];

		for(int i = 0; i < inputPiles.length; i++) {
			for(int j = 0; j < inputPiles.length; j++) {
				inputPiles[i][j] = kb.nextInt();
			}
		}

		LumberPiles lumber = new LumberPiles(size,logs);
		lumber.setPiles(inputPiles);
		lumber.placeLogs();
		System.out.println("===========");
		lumber.showPiles();
	}

}