package sort;

public class Util {

	public static void print(int A[]) {

		if (A == null)
			return;

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();

	}

	public static boolean isSorted(int A[]) {

		if (A == null)
			return false;

		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1])
				return false;
		}
		return true;

	}
}
