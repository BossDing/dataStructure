package com.phn.stack;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ��ջ����
 * @date 2015��7��20��
 */
public class FOLinkedStackTest {
	public static void main(String[] args) {
		FOLinkedStack<String> fols = new FOLinkedStack<String>();
		System.out.println(fols.isEmpty());
		fols.push("Ԫ��1");
		System.out.println(fols);
		System.out.println(fols.size());
		System.out.println(fols.peek());
		System.out.println(fols);
		System.out.println(fols.pop());
		System.out.println(fols.isEmpty());
		System.out.println(fols);
		System.out.println(fols.size());
		fols.push("Ԫ��4");
		fols.push("Ԫ��2");
		fols.push("Ԫ��5");
		fols.push("Ԫ��3");
		fols.push("Ԫ��6");
		System.out.println(fols);
		System.out.println(fols.size());
		System.out.println(fols.isEmpty());
	}

}
