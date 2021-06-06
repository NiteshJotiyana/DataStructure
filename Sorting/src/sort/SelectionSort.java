package sort;

public class SelectionSort {

	public static void main(String[] args) {
		new SelectionSort();
	}

	public SelectionSort() {
		int A[] = { 2, 3, 5, 1, 6, 9, 7 };
		print(A);
		// assert isSorted(A);
		sort(A);
		print(A);
		assert isSorted(A);
	}

	/**
	 * N2 time complexity In place algorithm N2/2 compares N swap
	 * 
	 * @param A
	 */
	public void sort(int A[]) {
		for (int i = 0; i < A.length; i++) {
			int min = i;

			for (int j = i; j < A.length; j++) {
				if (A[min] > A[j])
					min = j;
			}
			swap(A, min, i);
		}
	}

	public void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public boolean isSorted(int A[]) {

		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1])
				return false;
		}
		return true;
	}

	public void print(int A[]) {

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
