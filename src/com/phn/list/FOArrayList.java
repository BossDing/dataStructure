package com.phn.list;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 顺序表
 * @date 2015年7月16日
 */
public class FOArrayList<E> {
	// 顺序表长度
	private int size;
	// 顺序表默认数组为null
	private Object[] data = null;
	// 顺序表中数组的初始化长度,也是顺序表的容量
	private int capacity;
	// 顺序表默认初始化长度
	private static final int DEFUALT_INITIAL_SIZE = 0;

	/**
	 * 默认无参构造函数
	 */
	public FOArrayList() {
		this(DEFUALT_INITIAL_SIZE);
	}

	/**
	 * @TODO 带参构造函数
	 * @param initialCapacity 初始化顺序表容量
	 */
	public FOArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new RuntimeException("数组大小错误:" + initialCapacity);
		}
		this.data = new Object[initialCapacity];
		this.capacity = initialCapacity;
		this.setSize();
	}

	/**
	 * @TODO 设置顺序表的长度
	 */
	private void setSize() {
		this.size = 0;
	}

	/**
	 * @TODO 获取顺序表的长度
	 * @return size 顺序表的长度
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @TODO 顺序表添加元素
	 * @param e 数据元素类型
	 * @return true
	 */
	public boolean add(E e) {
		ensureCapacity(size);
		this.data[size] = e;
		this.size++;
		return true;
	}

	/**
	 * @TODO 顺序表插入元素
	 * @param index 插入位置
	 * @param e 数据元素类型
	 * @return true
	 */
	public boolean insert(int index, E e) {
		if (index >= 0 && index <= size) {
			ensureCapacity(size);
			E temp = (E) this.data[index - 1];
			this.data[index - 1] = e;
			this.size++;
			for (int i = index; i <= size; i++) {
				E temp2 = (E) this.data[i];
				this.data[i] = temp;
				temp = temp2;
			}
		} else {
			throw new RuntimeException("数组下标错误：" + index);
		}
		return true;
	}

	/**
	 * @TODO 顺序表删除元素
	 * @param index 将要删除的元素的索引位置
	 * @return E 删除的元素
	 */
	public E remove(int index) {
		validateIndex(index);
		E e = (E) this.data[index];
		for (int i = index; i < size - 1; i++) {
			this.data[i] = this.data[i + 1];
		}
		this.size--;
		return e;
	}

	/**
	 * @TODO 根据元素索引位置获取元素
	 * @param index 元素的索引位置
	 * @return E 元素e
	 */
	public E get(int index) {
		validateIndex(index);
		return (E) this.data[index];
	}

	/**
	 * @TODO 将顺序表中索引位置为i的元素修改为元素e
	 * @param index 元素的索引位置
	 * @param e 需要修改成的元素
	 * @return true 修改成功标志
	 */
	public boolean set(int index, E e) {
		validateIndex(index);
		this.data[index] = e;
		return true;
	}

	@Override
	public String toString() {
		return this.arrayToString(data);
	}

	/**
	 * @TODO 获取字符串形式的顺序表中的数组序列
	 * @param a 顺序表中的数组
	 * @return String 字符串形式的顺序表中的数组序列
	 */
	private String arrayToString(Object[] a) {
		if (a == null)
			return "null";
		int iMax = this.size - 1;
		if (iMax == -1)
			return "[]";
		StringBuilder b = new StringBuilder();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(String.valueOf(a[i]));
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	/**
	 * @TODO 验证所给索引位置是否合法
	 * @param index 给出的索引位置
	 */
	private void validateIndex(int index) {
		if (index >= this.size || index <= 0) {
			throw new RuntimeException("数组下标错误：" + index);
		}
	}

	/**
	 * @TODO 判断是否需要扩充顺序表容量
	 * @param currentSize 当前顺序表的大小
	 */
	private void ensureCapacity(int currentSize) {
		if (currentSize == capacity) {
			this.capacity = (this.capacity * 3) / 2 + 1;
			Object[] newData = new Object[this.capacity];
			for (int i = 0; i < currentSize; i++) {
				newData[i] = this.data[i];
			}
			this.data = newData;
		}
	}
}
