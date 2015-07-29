package com.phn.stack;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 链栈
 * @date 2015年7月20日
 */
public class FOLinkedStack<E> {
	//栈顶指针
	private FOLinkedNode<E> topNode = null;
	//栈的长度
	private int size;

	/**
	 * @TODO 无参构造函数，初始化链栈
	 */
	public FOLinkedStack() {
		this.size = 0;
	}

	/**
	 * @TODO 获取栈的长度
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @TODO 压入数据元素到栈中
	 * @param e 要压入的数据元素
	 * @return true
	 */
	public boolean push(E e) {
		FOLinkedNode<E> temp = new FOLinkedNode<E>();
		temp.setE(e);
		temp.addNext(this.topNode);
		this.topNode = temp;
		this.size++;
		return true;
	}
	/**
	 * @TODO 获取栈顶元素，并没有弹出，还存在栈中
	 * @return e 获取到的数据元素
	 */
	public E peek(){
		if(this.isEmpty()){
			throw new RuntimeException("链栈为空！");
		}else{
			E e = this.topNode.getE();
			return e;
		}
	}
	/**
	 * @TODO 弹出栈顶数据元素，不在栈中了
	 * @return e 弹出的数据元素
	 */
	public E pop(){
		E e = this.peek();
		this.topNode = this.topNode.next;
		this.size--;
		return e;
	}
	/**
	 * @TODO 栈是否为空
	 * @return true空 or false不为空
	 */
	public boolean isEmpty(){
		if(this.topNode==null){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		if(this.topNode!=null){
			sb.append(this.topNode.getE());
			FOLinkedNode<E> temp =new  FOLinkedNode<E>();
			temp = this.topNode.next;
			while(temp!=null){
				sb.append(","+temp.getE());
				temp = temp.next;
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}
