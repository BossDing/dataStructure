/**
 * 
 */
package com.phn.stack;


/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 顺序栈
 * @date 2015年7月20日
 */
public class FOArrayStack<E> {
	//初始化默认栈的存储容量
	private static final int DEFUALT_CAPACITY = 100;
	//栈中存储数据元素的数组
	private Object[] data = null;
	//栈的实际大小
	private int size;
	//栈的栈顶指针
	private int top;
	//栈的实际容量
	private int capacity;
	/**
	 * @TODO 无参构造函数，初始化栈
	 */
	public FOArrayStack(){
		this(DEFUALT_CAPACITY);
	}

	/**
	 * @TODO 带参构造函数，初始化栈
	 * @param initialCapacity 初始化栈的容量
	 */
	public FOArrayStack(int initialCapacity) {
		this.capacity = initialCapacity;
		this.data = new Object[initialCapacity];
		this.size = 0;
		this.top = this.size-1;
	}
	/**
	 * @TODO 压入数据元素到栈中
	 * @param e 数据元素
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
	 * @TODO 验证栈的实际大小是否已经到达栈实际容量的极限
	 */
	private void validateCapacity() {
		if(this.top==this.capacity-1){
			throw new RuntimeException("此栈已满！最大容量="+this.capacity);
		}
	}
	/**
	 * @TODO 获取栈顶元素，并没有将其弹出栈
	 * @return e 数据元素
	 */
	public E peek(){
		if(this.isEmpty()){
			throw new RuntimeException("此栈为空栈！");
		}else{
			Object e = new Object();
			e = this.data[this.top];
			return (E)e;
		}
		
	}
	/**
	 * @TODO 获取栈顶元素并弹出栈
	 * @return e 数据元素
	 */
	public E pop(){
		E e = this.peek();
		this.top--;
		this.size--;
		return e;
	}
	/**
	 * @TODO 清空栈
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
	 * @TODO 判断栈是否为空
	 * @return true空 or false不为空
	 */
	public boolean isEmpty(){
		//或者用长度表示
		if(this.top==-1){
			return true;
		}
		return false;
	}
	/**
	 * @TODO 栈的实际大小
	 * @return
	 */
	public int size(){
		return this.size;
	}
}
