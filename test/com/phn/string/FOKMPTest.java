/**
 * 
 */
package com.phn.string;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015��7��26��
 */
public class FOKMPTest {
	public static void main(String[] args) {
		String S = "aaaabaaaaaxaaaaaxcde";
		String T = "aaaaax";
		int  k = FOKMP.indexKMP(S, T);
		System.out.println(k);
	}
}
