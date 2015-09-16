package com.phn.sort;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 
 * @date 2015年9月13日
 */
public class QuickSort {
	private static int []sortArray;
	
	public static int[] quickSort(int []array){
		sortArray = array;
		qSort(0,array.length-1);
		return sortArray;
	}
	private static void qSort(int low,int high){
		int pivot;
		if(low < high){
			pivot = partition(low,high);
			qSort(low,pivot-1);
			qSort(pivot+1,high);
		}
	}
	private static int partition(int low,int high){
		int pivotkey;
		pivotkey = sortArray[low];
		int temp = pivotkey;
		while(low<high){
			while(low<high && sortArray[high]>=pivotkey)
				high--;
			sortArray[low] = sortArray[high];
//			sortArray[high] = pivotkey;
			while(low<high && sortArray[low]<=pivotkey)
				low++;
			sortArray[high] = sortArray[low];
//			sortArray[low] = pivotkey;
		}
		sortArray[low] = temp;
		return low;
	}
	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12};
		int a1[] = quickSort(a);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+ ",");
		}
	}
}

