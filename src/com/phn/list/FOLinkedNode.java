package com.phn.list;
public class FOLinkedNode<E> {
		private E e;// ����д�ŵ�����

		FOLinkedNode() {
		}

		FOLinkedNode(E e) {
			this.e = e;
		}

		FOLinkedNode<E> next;// ����ָ��ý�����һ�����

		// ������һ�ڵ��ֵ
		void addNext(FOLinkedNode<E> node) {
			next = node;
		}

		public E getE() {
			return e;
		}

		public void setE(E e) {
			this.e = e;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", next=" + next + "]";
		}

	}