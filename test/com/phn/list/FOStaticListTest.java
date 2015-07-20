/**
 * 
 */
package com.phn.list;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015年7月19日
 */
public class FOStaticListTest {
	public static void main(String[] args) {
		FOStaticList<String> fosl = new FOStaticList<String>(5);
		fosl.add("元素1");
		System.out.println(fosl);
		fosl.add("元素2");
		fosl.add("元素3");
		System.out.println(fosl);
		fosl.add("元素4");
		System.out.println(fosl);
		System.out.println(fosl.size());
		fosl.remove(2);
		System.out.println(fosl);
		System.out.println(fosl.size());
		fosl.add("元素22222");
		System.out.println(fosl);
		System.out.println(fosl.size());
	}
}
