package com.phn.list;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ˳���
 * @date 2015��7��16��
 */
public class FOArrayList<E> {
	// ˳�����
	private int size;
	// ˳���Ĭ������Ϊnull
	private Object[] data = null;
	// ˳���������ĳ�ʼ������,Ҳ��˳��������
	private int capacity;
	// ˳���Ĭ�ϳ�ʼ������
	private static final int DEFUALT_INITIAL_SIZE = 0;

	/**
	 * Ĭ���޲ι��캯��
	 */
	public FOArrayList() {
		this(DEFUALT_INITIAL_SIZE);
	}

	/**
	 * @TODO ���ι��캯��
	 * @param initialCapacity ��ʼ��˳�������
	 */
	public FOArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new RuntimeException("�����С����:" + initialCapacity);
		}
		this.data = new Object[initialCapacity];
		this.capacity = initialCapacity;
		this.setSize();
	}

	/**
	 * @TODO ����˳���ĳ���
	 */
	private void setSize() {
		this.size = 0;
	}

	/**
	 * @TODO ��ȡ˳���ĳ���
	 * @return size ˳���ĳ���
	 */
	public int size() {
		return this.size;
	}

	/**
	 * @TODO ˳������Ԫ��
	 * @param e ����Ԫ������
	 * @return true
	 */
	public boolean add(E e) {
		ensureCapacity(size);
		this.data[size] = e;
		this.size++;
		return true;
	}

	/**
	 * @TODO ˳������Ԫ��
	 * @param index ����λ��
	 * @param e ����Ԫ������
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
			throw new RuntimeException("�����±����" + index);
		}
		return true;
	}

	/**
	 * @TODO ˳���ɾ��Ԫ��
	 * @param index ��Ҫɾ����Ԫ�ص�����λ��
	 * @return E ɾ����Ԫ��
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
	 * @TODO ����Ԫ������λ�û�ȡԪ��
	 * @param index Ԫ�ص�����λ��
	 * @return E Ԫ��e
	 */
	public E get(int index) {
		validateIndex(index);
		return (E) this.data[index];
	}

	/**
	 * @TODO ��˳���������λ��Ϊi��Ԫ���޸�ΪԪ��e
	 * @param index Ԫ�ص�����λ��
	 * @param e ��Ҫ�޸ĳɵ�Ԫ��
	 * @return true �޸ĳɹ���־
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
	 * @TODO ��ȡ�ַ�����ʽ��˳����е���������
	 * @param a ˳����е�����
	 * @return String �ַ�����ʽ��˳����е���������
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
	 * @TODO ��֤��������λ���Ƿ�Ϸ�
	 * @param index ����������λ��
	 */
	private void validateIndex(int index) {
		if (index >= this.size || index <= 0) {
			throw new RuntimeException("�����±����" + index);
		}
	}

	/**
	 * @TODO �ж��Ƿ���Ҫ����˳�������
	 * @param currentSize ��ǰ˳���Ĵ�С
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
