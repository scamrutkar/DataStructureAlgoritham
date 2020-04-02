package com.sagar.javacase.algorithm.sorting;

public class QuickSort {

	private void sort(int[] arr, int low, int high) {

		if (low < high) {

			int partition = partiton(arr, low, high);
			sort(arr, low, partition - 1);
			sort(arr, partition + 1, high);
		}

	}

	private int partiton(int[] arr, int low, int high) {

		int pivot = arr[high];
		int pIndex = low - 1;
		for (int i = low; i < high ; i++) {
			if (arr[i] < pivot) {
				pIndex++;
				int temp = arr[pIndex];
				arr[pIndex] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[pIndex + 1];
		arr[pIndex + 1] = arr[high];
		arr[high] = temp;

		return pIndex + 1;
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n - 1);

		System.out.println("sorted array");
		printArray(arr);

	}

}
