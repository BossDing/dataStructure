package com.phn.stack;
public class FOLinkedNode<E> {
		private E e;// 结点中存放的数据

		FOLinkedNode() {
		}

		FOLinkedNode(E e) {
			this.e = e;
		}

		FOLinkedNode<E> next;// 用来指向该结点的下一个结点

		// 设置下一节点的值
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
			return e.toString();
		}

	}