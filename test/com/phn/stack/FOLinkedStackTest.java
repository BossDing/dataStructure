package com.phn.stack;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 链栈测试
 * @date 2015年7月20日
 */
public class FOLinkedStackTest {
	public static void main(String[] args) {
		FOLinkedStack<String> fols = new FOLinkedStack<String>();
		System.out.println(fols.isEmpty());
		fols.push("元素1");
		System.out.println(fols);
		System.out.println(fols.size());
		System.out.println(fols.peek());
		System.out.println(fols);
		System.out.println(fols.pop());
		System.out.println(fols.isEmpty());
		System.out.println(fols);
		System.out.println(fols.size());
		fols.push("元素4");
		fols.push("元素2");
		fols.push("元素5");
		fols.push("元素3");
		fols.push("元素6");
		System.out.println(fols);
		System.out.println(fols.size());
		System.out.println(fols.isEmpty());
	}

}
