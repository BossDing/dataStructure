package com.phn.tree;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 二叉树结点
 * @date 2015年7月27日
 */
public class FOBinaryTreeNode<E extends Comparable<E>>{
	private E e ;
	private FOBinaryTreeNode<E> parent;
	private FOBinaryTreeNode<E> leftChild;
	private FOBinaryTreeNode<E> rightChild;
	
	
	public FOBinaryTreeNode() {
		super();
	}
	/**
	 * @param e
	 * @param parent
	 * @param leftChild
	 * @param rightChild
	 */
	public FOBinaryTreeNode(E e, FOBinaryTreeNode<E> parent,
			FOBinaryTreeNode<E> leftChild, FOBinaryTreeNode<E> rightChild) {
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
	public FOBinaryTreeNode<E> getParent() {
		return parent;
	}
	public void setParent(FOBinaryTreeNode<E> parent) {
		this.parent = parent;
	}
	public FOBinaryTreeNode<E> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(FOBinaryTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}
	public FOBinaryTreeNode<E> getRightChild() {
		return rightChild;
	}
	public void setRightChild(FOBinaryTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}
	@Override
	public String toString() {
		return e.toString();
	}
	
}
