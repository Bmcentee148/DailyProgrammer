/** Will take numbers and find their respective palindromic sequence.
	If the number is not a palindrome, it is added to the reverse of itself
	until it is a palindrome. The corresponding palindrome and the number of
	cycles will be reported to the user */

import java.util.Arrays;
import java.util.Scanner;

public class PalindromicNumbers {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		String input = "";
		String nextLine = "";
		do {
			nextLine = kb.nextLine().trim();
			input += nextLine + " ";
		} while(!(nextLine.equals("")));
		
		String[] inputValues = input.split("\\s");

		for(int i = 0; i < inputValues.length; i++) {
			
			String currInputVal = inputValues[i];
			int steps = 0;
			int newVal = Integer.parseInt(currInputVal);
			while(!isPalindrome(String.valueOf(newVal))) {
				int revVal = Integer.parseInt(getReverse(String.valueOf(newVal))); 
				newVal += revVal;
				steps++;
			}
			System.out.println(inputValues[i] + " is palindromic after " + steps + 
				" steps: " + newVal);
		}
		
	}

	public static boolean isPalindrome(String s) {
		boolean status = true;
		for(int i = 0, j = s.length() - 1; i <= j ; i++, j--) {
			if(s.charAt(i) != (s.charAt(j))) {
				status = false;
				break;
			}
		}
		return status;
	}

	public static String getReverse(String s) {
		String reverse = "";
		for(int i = s.length()-1; i>=0; i--) {
			reverse += String.valueOf(s.charAt(i));
		}
		System.out.println(reverse);
		return reverse;
	}

}