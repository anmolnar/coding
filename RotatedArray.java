import java.util.*;

public class RotatedArray {
  public static void main(String[] args) {
    System.out.println("Rotated Array demo");

    Random rand = new Random();
    int[] randomInts = new int[25];

    for (int i = 0; i < randomInts.length; i++) {
      randomInts[i] = rand.nextInt(50);
    }

    Arrays.sort(randomInts);
    System.out.println("Sorted: " + Arrays.toString(randomInts));

	rotateArray(randomInts, rand.nextInt(randomInts.length));
	System.out.println("Rotated: " + Arrays.toString(randomInts));

  	findReset(randomInts, 0, randomInts.length - 1);
  }

  private static void findReset(int[] input, int i, int j) {
	int m = i + (j - i) / 2;
	System.out.printf("i = %d, m = %d, j = %d\n", i, m, j);
	if (input[m] > input[m + 1]) {
		System.out.printf("Rotated by: %d\n", input.length - m - 1);
		return;
	}
	if (i == j - 1) {
		System.out.println("Array is not rotated");
		return;
	}
	if (input[i] <= input[m]) {
		findReset(input, m, j);
	} else {
		findReset(input, i, m);
	}
  }

  private static void rotateArray(int[] input, int times) {
	System.out.printf("Rotating with: %d\n", times);
	for (int j = 0; j < times; j++) {
		int first = input[0];
		for (int i = 0; i < input.length - 1; i++) {
			int keep = input[i];		
			input[i] = input[i + 1];
			input[i+1] = keep;
		}
		input[input.length - 1] = first;
	}
  }
}
