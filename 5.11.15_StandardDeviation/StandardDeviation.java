import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;
public class StandardDeviation {

    public static void main(String[] args) {
        int[] data = getData();
        int sum = 0, sumOfSquares = 0;
        for(int i = 0; i < data.length; i++) {
            int num = data[i];
            sum+= num;
            sumOfSquares+= (num * num);
        }
        double mean = sum / data.length;
        double squaredMean = (double)sumOfSquares / data.length;
        double sd = Math.sqrt(squaredMean - (mean * mean));
        DecimalFormat deci = new DecimalFormat("0.00##");
        System.out.println(mean);
        System.out.println(sumOfSquares);
        System.out.println(squaredMean);
        System.out.println(sd);
        System.out.println(deci.format(sd));
    }

    public static int[] getData() {
        Scanner kb = new Scanner(System.in);
        String[] str_data = kb.nextLine().split("\\s");
        int[] data = new int[str_data.length];
        for(int i = 0; i < str_data.length; i++) {
            data[i] = Integer.parseInt(str_data[i]);
        }
        return data;
    }
}