package com.phn.queue;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO
 * @date 2015��7��20��
 */
public class FOArrayQueueTest<E> {
	public static void main(String[] args) {
		FOArrayQueue<String> foaq = new FOArrayQueue<String>();
		for (int i = 1; i <= 6; i++) {
			foaq.enQueue("Ԫ��"+i);
		}
		System.out.println(foaq);
		System.out.println(foaq.size());
		System.out.println(foaq.deQueue());;
		System.out.println(foaq);
		System.out.println(foaq.size());
	}
}
