package com.phn.tree;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ƽ����������
 * @date 2015��7��30��
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
