package sort;

public class QuickSort {

	public static void main(String[] args) {
		new QuickSort();
	}

	public QuickSort() {
		int A[] = { 2, 6, 4, 9, 1, 3 };
		Util.print(A);
		System.out.println("is Sorted : " + Util.isSorted(A));
		sort(A);
		Util.print(A);
		System.out.println("is Sorted : " + Util.isSorted(A));
	}

	public void sort(int A[]) {
		sort(A, 0, A.length - 1);
	}

	private void sort(int A[], int l, int h) {

		if (l < h) {
			int p = partition(A, l, h);
			sort(A, l, p - 1);
			sort(A, p + 1, h);
		}
	}

	private int partition(int[] A, int l, int h) {

		int pivot = A[l];
		int i = l;
		int j = h;

		while (i < j) {
			while (A[i] <= pivot)
				i++;
			while (A[j] > pivot)
				j--;

			if (i < j)
				swap(A, i, j);

		}
		swap(A, l, j);
		return j;
	}

	private void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
		// TODO Auto-generated method stub

	}
}
