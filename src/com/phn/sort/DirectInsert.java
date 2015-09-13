package com.phn.sort;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015年9月13日
 */
public class DirectInsert {
	public static int[] directInsert(int[] array) {
		if (null == array) {
			return null;
		}
		int temp;
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			temp = array[i];
			for (; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
		return array;

	}

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12};
		int a1[] = directInsert(a);
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]+ ",");
		}
	}
}
