package sort;

public class InsertionSort {

	public static void main(String[] args) {
		new InsertionSort();
	}

	public InsertionSort() {
		int A[] = null;
		Util.print(A);
		System.out.println("is Sorted : " + Util.isSorted(A));
		sort(A);
		Util.print(A);
		System.out.println("is Sorted : " + Util.isSorted(A));

	}

	public void sort(int A[]) {

		if (A == null)
			return;

		for (int i = 0; i < A.length; i++) {

			for (int j = i; j > 0; j--) {
				if (A[j] < A[j - 1]) {
					swap(A, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	private void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
