package com.phn.tree;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 二叉树结点
 * @date 2015年7月27日
 */
public class FOBinarySearchTreeNode<E extends Comparable<E>>{
	private E e ;
	private FOBinarySearchTreeNode<E> parent;
	private FOBinarySearchTreeNode<E> leftChild;
	private FOBinarySearchTreeNode<E> rightChild;
	
	
	public FOBinarySearchTreeNode() {
		super();
	}
	/**
	 * @param e
	 * @param parent
	 * @param leftChild
	 * @param rightChild
	 */
	public FOBinarySearchTreeNode(E e, FOBinarySearchTreeNode<E> parent,
			FOBinarySearchTreeNode<E> leftChild, FOBinarySearchTreeNode<E> rightChild) {
		super();
		this.e = e;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	public E getE() {
		return e;
	}
	public void setE(E e) {
		this.e = e;
	}
	public FOBinarySearchTreeNode<E> getParent() {
		return parent;
	}
	public void setParent(FOBinarySearchTreeNode<E> parent) {
		this.parent = parent;
	}
	public FOBinarySearchTreeNode<E> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(FOBinarySearchTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}
	public FOBinarySearchTreeNode<E> getRightChild() {
		return rightChild;
	}
	public void setRightChild(FOBinarySearchTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}
	@Override
	public String toString() {
		return e.toString();
	}
	
}
