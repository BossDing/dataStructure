/**
 * 
 */
package com.phn.list;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015��7��19��
 */
public class FOStaticListTest {
	public static void main(String[] args) {
		FOStaticList<String> fosl = new FOStaticList<String>(5);
		fosl.add("Ԫ��1");
		System.out.println(fosl);
		fosl.add("Ԫ��2");
		fosl.add("Ԫ��3");
		System.out.println(fosl);
		fosl.add("Ԫ��4");
		System.out.println(fosl);
		System.out.println(fosl.size());
		fosl.remove(2);
		System.out.println(fosl);
		System.out.println(fosl.size());
		fosl.add("Ԫ��22222");
		System.out.println(fosl);
		System.out.println(fosl.size());
	}
}
