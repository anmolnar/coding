import java.util.*;

public class mergeSort {
	public static void main(String[] args) {
		Random rand = new Random();
		int size = 31;
		int[] input = new int[size];
		for (int i = 0; i < size; i++) {
			input[i] = rand.nextInt(50);
		}
		
		System.out.println(Arrays.toString(input));

		int[] temp = new int[size];
		mergeSort(input, size, temp);

		System.out.println(Arrays.toString(input));
	}

	private static void mergeSort(int[] A, int n, int[] B) {
		copyArray(A, 0, n, B);
		splitMerge(B, 0, n, A);
	}

	private static void splitMerge(int[] B, int iBegin, int iEnd, int[] A) {
		if (iEnd - iBegin < 2) {
			return;
		}
		int iMiddle = (iEnd + iBegin) / 2;
		splitMerge(A, iBegin, iMiddle, B);
		splitMerge(A, iMiddle, iEnd, B);
		merge(B, iBegin, iMiddle, iEnd, A);
	}

	private static void merge(int[] A, int iBegin, int iMiddle, int iEnd, int[] B) {
		int x = iBegin;
		int y = iMiddle;
		for (int z = iBegin; z < iEnd; z++) {
			if (x < iMiddle && (y >= iEnd || A[x] <= A[y])) {
				B[z] = A[x++];
			} else {
				B[z] = A[y++];
			}
		}
	}

	private static void copyArray(int[] A, int iBegin, int iEnd, int[] B) {
		for (int i = iBegin; i < iEnd; i++) {
			B[i] = A[i];
		}
	}
}
