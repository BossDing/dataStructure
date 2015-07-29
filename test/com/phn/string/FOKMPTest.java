/**
 * 
 */
package com.phn.string;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015年7月26日
 */
public class FOKMPTest {
	public static void main(String[] args) {
		String S = "aaaabaaaaaxaaaaaxcde";
		String T = "aaaaax";
		int  k = FOKMP.indexKMP(S, T);
		System.out.println(k);
	}
}
