package sort;

public class MergeSort {

	public static void main(String args[]) {
		new MergeSort();
	}

	public MergeSort() {
		int A[] = { 2, 4, 3, 7, 1, 8 };
		print(A);
		sort(A);
		System.out.println("isSorted : " + isSorted(A));
		print(A);
	}

	public void sort(int A[]) {
		sort(A, 0, A.length - 1);

	}

	private void sort(int A[], int l, int h) {
		if (l < h) {
			int mid = l + ((h - l) / 2);
			sort(A, l, mid);
			sort(A, mid + 1, h);
			merge(A, l, mid, h);
		}

	}

	private void merge(int A[], int l, int m, int h) {

		int aux[] = new int[A.length];

		for (int i = l; i <= h; i++) {
			aux[i] = A[i];
		}
		int i = l;
		int j = m + 1;

		for (int k = l; k <= h; k++) {
			if (i > m) {
				A[k] = aux[j++];
			} else if (j > h) {
				A[k] = aux[i++];

			} else if (aux[i] < aux[j]) {
				A[k] = aux[i++];

			} else {
				A[k] = aux[j++];
			}
		}
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
