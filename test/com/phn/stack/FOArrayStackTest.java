/**
 * 
 */
package com.phn.stack;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ˳��ջ����
 * @date 2015��7��20��
 */
public class FOArrayStackTest {

	public static void main(String[] args) {
		FOArrayStack<String> foas = new FOArrayStack<String>(6);
		foas.push("Ԫ��1");
		foas.push("Ԫ��2");
		foas.push("Ԫ��3");
		foas.push("Ԫ��4");
		foas.push("Ԫ��5");
		System.out.println(foas);
		foas.pop();
		System.out.println(foas);
		String s = foas.peek();
		System.out.println(s);
		System.out.println(foas);
		foas.clear();
		System.out.println(foas);
		System.out.println(foas.isEmpty());
	}

}
