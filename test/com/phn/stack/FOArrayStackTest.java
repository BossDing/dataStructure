/**
 * 
 */
package com.phn.stack;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 顺序栈测试
 * @date 2015年7月20日
 */
public class FOArrayStackTest {

	public static void main(String[] args) {
		FOArrayStack<String> foas = new FOArrayStack<String>(6);
		foas.push("元素1");
		foas.push("元素2");
		foas.push("元素3");
		foas.push("元素4");
		foas.push("元素5");
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
