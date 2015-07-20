/**
 * 
 */
package com.phn.list;



/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015年7月16日
 */
public class FOArrayListTest {
	public static void main(String[] args) {
		FOArrayList<String> foa = new FOArrayList<String>(9);
		for (int i = 1; i <= 8; i++) {
			foa.add("元素"+i);
		}
		System.out.println(foa);
		System.out.println(foa.get(1));
		foa.set(2,"元素3改为了3");
		System.out.println(foa);
		foa.remove(2);
		System.out.println(foa);
		foa.insert(2, "哈哈哈");
		System.out.println(foa);
		System.out.println(foa.size());
	}
}
