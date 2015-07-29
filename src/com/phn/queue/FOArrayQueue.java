package com.phn.queue;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 顺序队列
 * @date 2015年7月20日
 */
public class FOArrayQueue<E> {
	//默认队列容量
	private static final int DEFUALT_CAPACITY = 100;
	//队列存储数据元素的数组
	private Object[] data = null;
	//队列的实际大小
	private int size;
	//队列的对首索引
	private int front;
	//队列的队尾索引
	private int rear;
	//队列的实际容量
	private int capacity;

	/**
	 * @TODO 无参构造函数，初始化队列
	 */
	public FOArrayQueue() {
		this(DEFUALT_CAPACITY);
	}

	/**
	 * @param initialCapacity 队列初始化容量
	 */
	public FOArrayQueue(int initialCapacity) {
		this.data = new Object[initialCapacity];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
		this.capacity = initialCapacity;
	}
	/**
	 * @TODO 队列入队操作
	 * @param e 需要入队的数据元素
	 * @return true
	 */
	public boolean enQueue(E e){
		if(this.isFull()){
			throw new RuntimeException("队列已满！最大容量="+this.capacity);
		}
		this.data[this.rear] = e;
//		this.rear = (this.rear+1)%(this.capacity);
		this.rear = this.rear+1;
		this.size++;
		return true;
	}
	/**
	 * @TODO 队列的出队操作
	 * @return e 位于对首的数据元素
	 */
	public E deQueue(){
		if(this.isEmpty()){
			throw new RuntimeException("队列为空！");
		}
		E e = (E)this.data[this.front];
//		this.front = (this.front+1)%(this.capacity);
		this.front = this.front+1;
		this.size--;
		return e;
	}
	/**
	 * @TODO 判断队列是否为空
	 * @return true空 or false不为空
	 */
	public boolean isEmpty(){
		if(this.front==this.size){
			return true;
		}
		return false;
	}
	/**
	 * @TODO 判断队列是否已满
	 * @return true满 or false未满
	 */
	public boolean isFull(){
		//这里不能用size来进行判断，用size会出现假溢出的情况
		if(this.rear==this.capacity-1){
			return true;
		}
		return false;
	}
	/**
	 * @TODO 获取队列的长度
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
