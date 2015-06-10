import java.util.Scanner;
import java.util.Arrays;

public class SadCyclesDraft {

    public static void main(String[] agrs) {
        Scanner kb = new Scanner(System.in);

        int exp = kb.nextInt();
        kb.nextLine(); //consume nl character
        // get starting value and create array of same length to store digits
        String startNum = kb.nextLine().trim();
        int[] digits = new int[startNum.length()];
        int val = Integer.parseInt(startNum);

        int index = 0;
        while(val > 0) {
            digits[index] = val % 10;
            val /= 10;
            index++;
        }
        
    }
}