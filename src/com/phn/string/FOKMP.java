/**
 * 
 */
package com.phn.string;

import java.util.Arrays;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 模式匹配算法
 * @date 2015年7月26日
 */
public class FOKMP {

	private static int[] getNext(String Str) {
		int[] next = new int[Str.length()];
		int i, j;
		i = 0;
		j = -1;
		next[0] = -1;
		while (i < Str.length() - 1) {
			if (j == -1 || Str.charAt(i) == Str.charAt(j)) {
				i++;
				j++;
				if (Str.charAt(i) != Str.charAt(j)) {
					next[i] = j;
				} else {
					next[i] = next[j];
				}
			} else {
				j = next[j];
			}
		}
		return next;
	}

	public static int indexKMP(String S, String T) {
		int i = 0;
		int j = 0;
		int[] next = getNext(T);
		System.out.println(Arrays.toString(next));
		while (i <= S.length() - 1 && j <= T.length() - 1) {
			if (j == -1 || S.charAt(i) == T.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j >= T.length())
			return i - T.length();
		return -1;
	}
}
