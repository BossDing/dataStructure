package com.phn.queue;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ˳�����
 * @date 2015��7��20��
 */
public class FOArrayQueue<E> {
	//Ĭ�϶�������
	private static final int DEFUALT_CAPACITY = 100;
	//���д洢����Ԫ�ص�����
	private Object[] data = null;
	//���е�ʵ�ʴ�С
	private int size;
	//���еĶ�������
	private int front;
	//���еĶ�β����
	private int rear;
	//���е�ʵ������
	private int capacity;

	/**
	 * @TODO �޲ι��캯������ʼ������
	 */
	public FOArrayQueue() {
		this(DEFUALT_CAPACITY);
	}

	/**
	 * @param initialCapacity ���г�ʼ������
	 */
	public FOArrayQueue(int initialCapacity) {
		this.data = new Object[initialCapacity];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
		this.capacity = initialCapacity;
	}
	/**
	 * @TODO ������Ӳ���
	 * @param e ��Ҫ��ӵ�����Ԫ��
	 * @return true
	 */
	public boolean enQueue(E e){
		if(this.isFull()){
			throw new RuntimeException("�����������������="+this.capacity);
		}
		this.data[this.rear] = e;
//		this.rear = (this.rear+1)%(this.capacity);
		this.rear = this.rear+1;
		this.size++;
		return true;
	}
	/**
	 * @TODO ���еĳ��Ӳ���
	 * @return e λ�ڶ��׵�����Ԫ��
	 */
	public E deQueue(){
		if(this.isEmpty()){
			throw new RuntimeException("����Ϊ�գ�");
		}
		E e = (E)this.data[this.front];
//		this.front = (this.front+1)%(this.capacity);
		this.front = this.front+1;
		this.size--;
		return e;
	}
	/**
	 * @TODO �ж϶����Ƿ�Ϊ��
	 * @return true�� or false��Ϊ��
	 */
	public boolean isEmpty(){
		if(this.front==this.size){
			return true;
		}
		return false;
	}
	/**
	 * @TODO �ж϶����Ƿ�����
	 * @return true�� or falseδ��
	 */
	public boolean isFull(){
		//���ﲻ����size�������жϣ���size����ּ���������
		if(this.rear==this.capacity-1){
			return true;
		}
		return false;
	}
	/**
	 * @TODO ��ȡ���еĳ���
	 * @return size
	 */
	public int size(){
		return this.size;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		if(this.data[this.front]!=null){
			sb.append(this.data[this.front]);
			for (int i = this.front+1; i < this.rear; i++) {
				sb.append(", "+this.data[i]);
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
