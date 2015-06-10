import java.util.Arrays;
import java.util.Random;
public class ShuffleTest {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5};
		ShuffleTest.ShuffleArray(nums);
		System.out.println(Arrays.toString(nums));
	}

	private static void ShuffleArray(int[] array) {
    int index, temp;
    Random random = new Random();
    for (int i = array.length - 1; i > 0; i--) {
        index = random.nextInt(i + 1);
        temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    	}
	}

}