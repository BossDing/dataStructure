package com.phn.queue;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015年7月20日
 */
public class FOArrayQueueTest<E> {
	public static void main(String[] args) {
		FOArrayQueue<String> foaq = new FOArrayQueue<String>();
		for (int i = 1; i <= 6; i++) {
			foaq.enQueue("元素"+i);
		}
		System.out.println(foaq);
		System.out.println(foaq.size());
		System.out.println(foaq.deQueue());;
		System.out.println(foaq);
		System.out.println(foaq.size());
	}
}
