	import java.util.Scanner;
	import java.util.ArrayList;
	public class SadCycles {

		public static void main(String[] args) {
			Scanner kb = new Scanner(System.in);
			int exp = kb.nextInt();
			kb.nextLine(); //consume nl char
			int baseValue = Integer.parseInt(kb.nextLine().trim());

			ArrayList<Integer> sadCycle = getCycle(baseValue,exp);
			System.out.println(sadCycle);
			
		}

		/*  Takes an integer as its argument and returns an integer 
			array of its digits */
		public static int[] getDigits(int val) {
			int len = String.valueOf(val).length();
			int[] digits = new int[len];
			for(int i = 0; val > 0; i++) {
				digits[i] = val % 10;
				val /= 10;
			}
			return digits;
		}

		public static ArrayList<Integer> getCycle(int startVal, int exp) {
			int[] digits;
			int startIndex;
			int currVal = startVal;
			ArrayList<Integer> cycle = new ArrayList<Integer>();
			boolean continueCycle = true;
			while(continueCycle) {
				digits = getDigits(currVal);
				currVal = getExpSum(digits,exp);
				startIndex = cycle.indexOf(currVal);
				if(startIndex >= 0) {
					continueCycle = false;
					cycle.subList(0,startIndex).clear();
				}
				else {
					cycle.add(currVal);
				}
			}
			return cycle;
		}

		public static int getExpSum(int[] digits,int exp) {
			int result = 0;
			for(int i = 0; i < digits.length; i++) {
				result += Math.pow(digits[i],exp);
			}
			return result;
		}
	}