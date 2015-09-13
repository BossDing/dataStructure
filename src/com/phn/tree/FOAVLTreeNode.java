package com.phn.tree;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 
 * @date 2015年7月30日
 */
public class FOAVLTreeNode<E extends Comparable<E>> {
	private E e;
	private int height;
	private FOAVLTreeNode<E> leftChild;
	private FOAVLTreeNode<E> rightChild;
	
	public FOAVLTreeNode() {
		this(null,null,null);
	}
	/**
	 * @param e
	 * @param height
	 * @param leftChild
	 * @param rightChild
	 */
	public FOAVLTreeNode(E e, FOAVLTreeNode<E> leftChild,
			FOAVLTreeNode<E> rightChild) {
		super();
		this.e = e;
		this.height = 0;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public FOAVLTreeNode<E> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(FOAVLTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}
	public FOAVLTreeNode<E> getRightChild() {
		return rightChild;
	}
	public void setRightChild(FOAVLTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}
	
}
