package LinkedList.LargeData;

import java.util.Arrays;

public class Recursion {

	private static volatile byte equalizer = 0;
	private static volatile byte nonequalizer = 0;

	public static void main(String args[]) {
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 25, 10, 23, 41, 40 };
		Arrays.parallelSort(b);
		print(b, 0);
		compare(a, b, 0);
		System.out.println("Matched Cnt:: " + equalizer);
		System.out.println("NonMatched Cnt :: " + nonequalizer);
	}

	public static void print(int[] clone, int index) {
		if (index < clone.length) {
			System.out.format("Array Element: %d\n", clone[index]);
			++index;
			print(clone, index);
		} else
			System.out.println("Reached the end of the Array Element");
	}

	public static void compare(int[] arr, int[] brr, int ind) {
		if (ind < arr.length) {
			if (arr[ind] == brr[ind]) {
				equalizer++;
				compare(arr, brr, ++ind);
			} else {
				nonequalizer--;
				compare(arr, brr, ++ind);
			}
		} else
			System.out.println("Reached end of Compare Logic");
	}

}