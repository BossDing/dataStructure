package com.phn.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO
 ��ȡԭ���PECS����

�ܽ� ? extends �� the ? super ͨ��������������ǿ��Եó����½��ۣ�

��������һ�������������ȡ���ݣ�ʹ�� ? extends ͨ���
�������Ѷ���д��һ�����ݽṹ�ʹ�� ? super ͨ���
��������棬����ȡ���Ǿͱ���ͨ�����
 * @date 2015��9��17��
 */
public class Test {
	public static void main(String[] args) {
		List<Student> stus = new ArrayList<Student>();
		stus.add(new Student());
		
		List<People> peos = new ArrayList<People>();
		peos.add(new Student());
		// peos = stus;//���벻ͨ��
		
		List<? extends People> test1 = new ArrayList<Student>();
//		test1.add(new Student());//���벻ͨ��
		test1.add(null);
//		test1.add(new People());//���벻ͨ��
		System.out.println(test1);
		List<? extends People> test11 = stus;
		System.out.println(test11);
		
		List<? super Student> test2 = new ArrayList<Student>();
		test2.add(new Student());
		test2.add(new SmallStudent());
//		test2.add(new People());//���벻ͨ��
		
		List<? super People> test3 = new ArrayList<People>();
		test3.add(new Student());
		test3.add(new SmallStudent());
		test3.add(new People());
		
		List<? super Student> test4 = new ArrayList<People>();
//		List<? super Student> test5 = new ArrayList<SmallStudent>();//���벻ͨ��
	}
}
