package com.phn.tree;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 平衡二叉查找树
 * @date 2015年7月30日
 */
public class FOAVLTree<E extends Comparable<E>> {
	private FOAVLTreeNode<E> root;
	
	public FOAVLTree(){
		root = null;
	}
	
	public boolean add(E e){
		if(this.root == null){
			root = new FOAVLTreeNode<E>(e,null,null);
			root.setE(e);
			root.setHeight(1);
			return true;
		}
		int cmpResult = e.compareTo(root.getE());
		if(cmpResult == 0){
			return true;
		}
		else if(cmpResult>1){
			
		}
		FOAVLTreeNode<E> node = new FOAVLTreeNode<E>(e,null,null);
		
		return false;
	}
}
