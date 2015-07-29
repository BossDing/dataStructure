/**
 * 
 */
package com.phn.stack;


/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ˳��ջ
 * @date 2015��7��20��
 */
public class FOArrayStack<E> {
	//��ʼ��Ĭ��ջ�Ĵ洢����
	private static final int DEFUALT_CAPACITY = 100;
	//ջ�д洢����Ԫ�ص�����
	private Object[] data = null;
	//ջ��ʵ�ʴ�С
	private int size;
	//ջ��ջ��ָ��
	private int top;
	//ջ��ʵ������
	private int capacity;
	/**
	 * @TODO �޲ι��캯������ʼ��ջ
	 */
	public FOArrayStack(){
		this(DEFUALT_CAPACITY);
	}

	/**
	 * @TODO ���ι��캯������ʼ��ջ
	 * @param initialCapacity ��ʼ��ջ������
	 */
	public FOArrayStack(int initialCapacity) {
		this.capacity = initialCapacity;
		this.data = new Object[initialCapacity];
		this.size = 0;
		this.top = this.size-1;
	}
	/**
	 * @TODO ѹ������Ԫ�ص�ջ��
	 * @param e ����Ԫ��
	 * @return true
	 */
	public boolean push(E e){
		this.validateCapacity();
		this.top++;
		this.data[top]=e;
		this.size++;
		return true;
	}
	/**
	 * @TODO ��֤ջ��ʵ�ʴ�С�Ƿ��Ѿ�����ջʵ�������ļ���
	 */
	private void validateCapacity() {
		if(this.top==this.capacity-1){
			throw new RuntimeException("��ջ�������������="+this.capacity);
		}
	}
	/**
	 * @TODO ��ȡջ��Ԫ�أ���û�н��䵯��ջ
	 * @return e ����Ԫ��
	 */
	public E peek(){
		if(this.isEmpty()){
			throw new RuntimeException("��ջΪ��ջ��");
		}else{
			Object e = new Object();
			e = this.data[this.top];
			return (E)e;
		}
		
	}
	/**
	 * @TODO ��ȡջ��Ԫ�ز�����ջ
	 * @return e ����Ԫ��
	 */
	public E pop(){
		E e = this.peek();
		this.top--;
		this.size--;
		return e;
	}
	/**
	 * @TODO ���ջ
	 * @return true
	 */
	public boolean clear(){
		while(this.top>=0){
			this.data[this.top]=null;
			this.top--;
			this.size--;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		if(this.top!=-1){
			sb.append(this.data[this.top]);
			int temp = this.top-1;
			while(temp>=0){
				sb.append(", "+this.data[temp]);
				temp--;
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * @TODO �ж�ջ�Ƿ�Ϊ��
	 * @return true�� or false��Ϊ��
	 */
	public boolean isEmpty(){
		//�����ó��ȱ�ʾ
		if(this.top==-1){
			return true;
		}
		return false;
	}
	/**
	 * @TODO ջ��ʵ�ʴ�С
	 * @return
	 */
	public int size(){
		return this.size;
	}
}
