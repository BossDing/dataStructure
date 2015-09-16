package com.phn.sort;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015年9月13日
 */
public class BubbleSort {
	public static int[] bubbleSort0(int[] array) {
		boolean flag = true;
		for(int i=0;i<array.length-1 && flag;i++){
			flag = false;
			for(int j=0;j<array.length-1-i;j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = true;
				}
			}
//			for (int k = 0; k < array.length; k++) {
//				System.out.print(array[k]+",");
//			}
//			System.out.println();
		}
		return array;
	}
	public static void main(String[] args) {
		int []array = {26,53,48,11,13,48,32,15};
		int []result = bubbleSort0(array);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+",");
		}
	}
}
