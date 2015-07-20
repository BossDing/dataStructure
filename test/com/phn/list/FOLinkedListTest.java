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
public class FOLinkedListTest {
	public static void main(String[] args) {
		FOLinkedList<String> fol = new FOLinkedList<String>();
		for (int i = 1; i <= 8; i++) {
			fol.add("元素"+i);
		}
		fol.add("元素"+2);
		fol.add("元素"+7);
		fol.add("元素"+2);
		fol.add("元素"+2);
		fol.add("元素"+3);
		fol.add("元素"+11);
		fol.add("元素"+1);
		fol.add("元素"+9);
		System.out.println(fol);
		fol = FOLinkedList.removeRepeatElement(fol);
		System.out.println(fol);
		System.out.println(fol.size());
		fol.insert( 9,"xxx");
		System.out.println(fol);
		System.out.println(fol.size());
		fol.set(9,"元素9");
		System.out.println(fol);
		FOLinkedNode<String> e = fol.remove(6);
		System.out.println(e);
		System.out.println(fol);
		System.out.println(fol.size());
		FOLinkedList<String> newFol = new FOLinkedList<String>();
		for (int i = 1; i <= fol.size(); i++) {
			newFol.addFirst(fol.get(i).getE());
		}
		System.out.println(newFol);
		FOLinkedList<Integer> a = new FOLinkedList<Integer>();
		FOLinkedList<Integer> b = new FOLinkedList<Integer>();
		for (int i = 0,j=1; i < 10; i++,j=j+2) {
			a.add(j);
		}
		for (int i = 0,j=0; i < 10; i++,j=j+3) {
			b.add(j);
		}
		System.out.println(a);
		System.out.println(b);
		FOLinkedList<Integer> c = a.merge(b);
		System.out.println(c);
		
		//测试链表是否含有环
		FOLinkedList<Integer> x = new FOLinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			x.add(i);
		}
		System.out.println(x);
		System.out.println(x.size());
		System.out.println("hasLoop2:"+x.hasLoop2());
		System.out.println("hasLoop:"+x.hasLoop());
		x.setIndexLoop(10);
		System.out.println(x);
		System.out.println(x.size());
		System.out.println("hasLoop2:"+x.hasLoop2());
		System.out.println("hasLoop:"+x.hasLoop());
	}
}
