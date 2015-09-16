package com.phn.sort;

public class ShellSort {
	public static void main(String[] args) {
		int a[] = { 57, 68, 59, 52, 72, 28, 96, 33, 24, 19 };
		a = shellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public static int[] shellSort(int[] a) {
		if(a==null || a.length<=1)
			return a;
		int temp = 0;
		int d = a.length;
		do {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}

		} while (d != 1);
		return a;

	}
}
