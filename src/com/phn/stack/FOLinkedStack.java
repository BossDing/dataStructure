package com.phn.stack;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ��ջ
 * @date 2015��7��20��
 */
public class FOLinkedStack<E> {
	//ջ��ָ��
	private FOLinkedNode<E> topNode = null;
	//ջ�ĳ���
	private int size;

	/**
	 * @TODO �޲ι��캯������ʼ����ջ
	 */
	public FOLinkedStack() {
		this.size = 0;
	}

	/**
	 * @TODO ��ȡջ�ĳ���
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @TODO ѹ������Ԫ�ص�ջ��
	 * @param e Ҫѹ�������Ԫ��
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
	 * @TODO ��ȡջ��Ԫ�أ���û�е�����������ջ��
	 * @return e ��ȡ��������Ԫ��
	 */
	public E peek(){
		if(this.isEmpty()){
			throw new RuntimeException("��ջΪ�գ�");
		}else{
			E e = this.topNode.getE();
			return e;
		}
	}
	/**
	 * @TODO ����ջ������Ԫ�أ�����ջ����
	 * @return e ����������Ԫ��
	 */
	public E pop(){
		E e = this.peek();
		this.topNode = this.topNode.next;
		this.size--;
		return e;
	}
	/**
	 * @TODO ջ�Ƿ�Ϊ��
	 * @return true�� or false��Ϊ��
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
