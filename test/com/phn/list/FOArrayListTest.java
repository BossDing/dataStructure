/**
 * 
 */
package com.phn.list;



/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015��7��16��
 */
public class FOArrayListTest {
	public static void main(String[] args) {
		FOArrayList<String> foa = new FOArrayList<String>(9);
		for (int i = 1; i <= 8; i++) {
			foa.add("Ԫ��"+i);
		}
		System.out.println(foa);
		System.out.println(foa.get(1));
		foa.set(2,"Ԫ��3��Ϊ��3");
		System.out.println(foa);
		foa.remove(2);
		System.out.println(foa);
		foa.insert(2, "������");
		System.out.println(foa);
		System.out.println(foa.size());
	}
}
