/**
 * 
 */
package com.phn.list;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO 
 * @date 2015��7��19��
 */
public class FOStaticNode<E> {
	private E e;
	private int cursor;
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	public int getCursor() {
		return cursor;
	}
	public void setCursor(int cursor) {
		this.cursor = cursor;
	}
	@Override
	public String toString() {
		return "[" + e + ", cursor=" + cursor + "]";
	}
	
}
