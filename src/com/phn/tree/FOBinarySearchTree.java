package com.phn.tree;

/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ���������
 * @date 2015��7��27��
 */
public class FOBinarySearchTree<E extends Comparable<E>> {
	//����������ĸ����
	private FOBinarySearchTreeNode<E> root;

	/**
	 * TODO �޲ι��캯������ʼ������������
	 */
	public FOBinarySearchTree() {
		this.root = null;
	}
	/**
	 * @TODO ����Ԫ��e�Ƿ�����ڸö�����������
	 * @param e ����Ԫ��
	 * @return true or false
	 */
	public boolean contains(E e) {
		return this.contains2(e, root);
	}

	/**
	 * @TODO �����������Ƿ����ĳ��Ԫ�صľ���ʵ��
	 * @param e ����Ԫ��
	 * @param node ���ĸ����
	 * @return true or false
	 */
	private boolean contains2(E e, FOBinarySearchTreeNode<E> node) {
		if (node == null)
			return false;
		else {
			int result = e.compareTo(node.getE());
			if (result < 0) {
				return contains2(e, node.getLeftChild());
			} else if (result > 0) {
				return contains2(e, node.getRightChild());
			} else {
				return true;
			}
		}
	}

	/**
	 * @TODO ������������������Ԫ�������еĽ����Ϣ
	 * @param e ����Ԫ��
	 * @return ������Ԫ�������еĽ����Ϣ
	 */
	public FOBinarySearchTreeNode<E> search(E e) {
		if (root == null) {
			throw new RuntimeException("����Ϊ�գ�");
		}
		FOBinarySearchTreeNode<E> tempNode = root;
		while (tempNode != null) {
			int result = e.compareTo(tempNode.getE());
			if (result == 0) {
				return tempNode;
			} else if (result < 0) {
				tempNode = tempNode.getLeftChild();
			} else {
				tempNode = tempNode.getRightChild();
			}
		}
		return null;

	}

	/**
	 * @TODO ��������������Ԫ��(�ǵݹ鷽��)
	 * @param e ��Ҫ�����Ԫ��
	 * @return true or false
	 */
	public boolean add(E e) {
		if (root == null) {
			root = new FOBinarySearchTreeNode<E>();
			root.setE(e);
			return true;
		}
		FOBinarySearchTreeNode<E> tempInsertNode = root;
		FOBinarySearchTreeNode<E> insertParentNode = new FOBinarySearchTreeNode<E>();
		int result = 0;
		while (tempInsertNode != null) {
			insertParentNode = tempInsertNode;
			result = e.compareTo(tempInsertNode.getE());
			if (result < 0) {
				tempInsertNode = tempInsertNode.getLeftChild();
			} else if (result > 0) {
				tempInsertNode = tempInsertNode.getRightChild();
			} else {
				return true;
			}
		}
		FOBinarySearchTreeNode<E> insertNode = new FOBinarySearchTreeNode<E>();
		insertNode.setE(e);
		insertNode.setParent(insertParentNode);
		int cmpResult = e.compareTo(insertParentNode.getE());
		if (cmpResult > 0) {
			insertParentNode.setRightChild(insertNode);
		} else {
			insertParentNode.setLeftChild(insertNode);
		}
		return true;
	}
	/**
	 * @TODO ��������������Ԫ��(�ݹ鷽��)
	 * @param e ��Ҫ�����Ԫ��
	 * @return true or false
	 */
	public boolean insert(E e){
		insert(root,e);
		return true;
	}
	/**
	 * @TODO ��������������Ԫ�ص�ʵ��(�ݹ鷽��)
	 * @param node ���������������
	 * @param e ��Ҫ�����Ԫ��
	 * @return true or false
	 */
	private FOBinarySearchTreeNode<E> insert(FOBinarySearchTreeNode<E> node , E e){
		if (node == null) {
			return new FOBinarySearchTreeNode<E>(e,null,null,null);
		}
		int cmpResult = e.compareTo(node.getE());
		if (cmpResult > 0) {
			node.setRightChild(insert(node.getRightChild(),e));
			node.getRightChild().setParent(node);
		} else if(cmpResult < 0){
			node.setLeftChild(insert(node.getLeftChild(),e));
			node.getLeftChild().setParent(node);
		}else{
			;
		}
		return node;
	}

	/**
	 * @TODO ����������ɾ�������е������Ԫ��e
	 * @param e ��Ҫɾ��������Ԫ��
	 * @return true or false
	 */
	public boolean remove(E e) {
		FOBinarySearchTreeNode<E> removeNode = this.search(e);
		if (removeNode == null) {
			return false;
		}
		FOBinarySearchTreeNode<E> preRemoveNode = this.findPreNode(removeNode);
		if (preRemoveNode != null) {
			removeByPreNode(removeNode, preRemoveNode);
			return true;
		}

		FOBinarySearchTreeNode<E> nextRemoveNode = this.findNextNode(removeNode);
		if (nextRemoveNode != null) {
			removeByNextNode(removeNode, nextRemoveNode);
			return true;
		}

		if (removeNode.getParent().getLeftChild() == removeNode) {
			removeNode.getParent().setLeftChild(null);
		} else {
			removeNode.getParent().setRightChild(null);
		}
		return true;
	}

	/**
	 * @TODO ɾ�������������еĽ�����ǰ��������
	 * @param removeNode ��Ҫɾ���Ľ��
	 * @param preRemoveNode ��Ҫɾ���Ľ���ǰ�����
	 */
	private void removeByPreNode(FOBinarySearchTreeNode<E> removeNode,
			FOBinarySearchTreeNode<E> preRemoveNode) {
		if (preRemoveNode.getLeftChild() != null) {
			preRemoveNode.getLeftChild().setParent(preRemoveNode.getParent());
			preRemoveNode.getParent().setRightChild(
					preRemoveNode.getLeftChild());
		} else {
			preRemoveNode.getParent().setRightChild(null);
		}

		preRemoveNode.setParent(removeNode.getParent());
		if (removeNode.getParent().getLeftChild() == removeNode) {
			removeNode.getParent().setLeftChild(preRemoveNode);
		} else {
			removeNode.getParent().setRightChild(preRemoveNode);
		}

		preRemoveNode.setLeftChild(removeNode.getLeftChild());
		if (removeNode.getLeftChild() != null) {
			removeNode.getLeftChild().setParent(preRemoveNode);
		}
		preRemoveNode.setRightChild(removeNode.getRightChild());
		if (removeNode.getRightChild() != null) {
			removeNode.getRightChild().setParent(preRemoveNode);
		}
	}
	/**
	 * @TODO ɾ�������������еĽ������̽�����
	 * @param removeNode ��Ҫɾ���Ľ��
	 * @param nextRemoveNode ��Ҫɾ���Ľ��ĺ�̽��
	 */
	private void removeByNextNode(FOBinarySearchTreeNode<E> removeNode,
			FOBinarySearchTreeNode<E> nextRemoveNode) {
		if (nextRemoveNode.getRightChild() != null) {
			nextRemoveNode.getRightChild()
					.setParent(nextRemoveNode.getParent());
			nextRemoveNode.getParent().setLeftChild(
					nextRemoveNode.getRightChild());
		} else {
			nextRemoveNode.getParent().setLeftChild(null);
		}
		nextRemoveNode.setParent(removeNode.getParent());
		if (removeNode.getParent().getLeftChild() == removeNode) {
			removeNode.getParent().setLeftChild(nextRemoveNode);
		} else {
			removeNode.getParent().setRightChild(nextRemoveNode);
		}

		nextRemoveNode.setLeftChild(removeNode.getLeftChild());
		if (removeNode.getLeftChild() != null) {
			removeNode.getLeftChild().setParent(nextRemoveNode);
		}
		nextRemoveNode.setRightChild(removeNode.getRightChild());
		if (removeNode.getRightChild() != null) {
			removeNode.getRightChild().setParent(nextRemoveNode);
		}
	}

	/**
	 * @TODO ��ȡ�������ǰ�����
	 * @param node ����Ľ��
	 * @return �������ǰ�����
	 */
	public FOBinarySearchTreeNode<E> findPreNode(FOBinarySearchTreeNode<E> node) {
		if (node == null) {
			throw new RuntimeException("������Ϊ�գ�");
		}
		FOBinarySearchTreeNode<E> tempNode = node.getLeftChild();
		if (tempNode == null) {
			// throw new RuntimeException("��������ǰ���ڵ㣡");
			return null;
		}
		FOBinarySearchTreeNode<E> preNode = tempNode;
		tempNode = tempNode.getRightChild();
		while (tempNode != null) {
			preNode = tempNode;
			tempNode = tempNode.getRightChild();
		}
		return preNode;
	}

	/**
	 * @TODO ��ȡ������ĺ�̽��
	 * @param node ������
	 * @return ������ĺ�̽��
	 */
	public FOBinarySearchTreeNode<E> findNextNode(FOBinarySearchTreeNode<E> node) {
		if (node == null) {
			throw new RuntimeException("������Ϊ�գ�");
		}
		FOBinarySearchTreeNode<E> tempNode = node.getRightChild();
		if (tempNode == null) {
			// throw new RuntimeException("�������޺�̽ڵ㣡");
			return null;
		}
		FOBinarySearchTreeNode<E> nextNode = tempNode;
		tempNode = tempNode.getLeftChild();
		while (tempNode != null) {
			nextNode = tempNode;
			tempNode = tempNode.getLeftChild();
		}
		return nextNode;
	}

	/**
	 * @TODO ��ȡ�ö��������������Ԫ��
	 * @return �ö��������������Ԫ��
	 */
	public E getMaxE(){
		return this.getMaxE(root);
	}
	
	/**
	 * @TODO ��ȡ������������������Ԫ�صľ���ʵ��
	 * @param node ��������������ĸ���� 
	 * @return ��������������������Ԫ��
	 */
	private E getMaxE(FOBinarySearchTreeNode<E> node) {
		if(node ==null){
			return null;
		}
		while(node.getRightChild()!=null){
			node = node.getRightChild();
		}
		return node.getE();
	}
	/**
	 * @TODO ��ȡ�ö�������������СԪ��
	 * @return �ö�������������СԪ��
	 */
	public E getMinE(){
		return this.getMinE(root);
	}

	/**
	 * @TODO ��ȡ�����������������СԪ�صľ���ʵ��
	 * @param node ��������������ĸ���� 
	 * @return �������������������СԪ��
	 */
	private E getMinE(FOBinarySearchTreeNode<E> node) {
		if(node ==null){
			return null;
		}
		while(node.getLeftChild()!=null){
			node = node.getLeftChild();
		}
		return node.getE();
	}

	/**
	 * @TODO ǰ��������������������Ԫ��
	 * @return ������������Ԫ�ص��ַ�����ʽ
	 */
	public String preOrderPrint() {
		StringBuffer sb = new StringBuffer("[");
		this.preOrder(root, sb);
		sb.replace(sb.length() - 2, sb.length() - 1, "]");
		return sb.toString();
	}
	/**
	 * @TODO ǰ��������������������Ԫ�صľ���ʵ��
	 * @param node �����������ĸ����
	 * @param sb ��������������Ԫ�صı������������sb��
	 * @return ������������Ԫ�ص��ַ�����ʽ
	 */
	private String preOrder(FOBinarySearchTreeNode<E> node, StringBuffer sb) {
		if (node != null) {
			sb.append(node + ", ");
			preOrder(node.getLeftChild(), sb);
			preOrder(node.getRightChild(), sb);
		} 
		return sb.toString();
	}
	/**
	 * @TODO ����������������������Ԫ��
	 * @return ������������Ԫ�ص��ַ�����ʽ
	 */
	public String inOrderPrint() {
		StringBuffer sb = new StringBuffer("[");
		this.inOrder(root, sb);
		sb.replace(sb.length() - 2, sb.length() - 1, "]");
		return sb.toString();
	}
	/**
	 * @TODO ����������������������Ԫ�صľ���ʵ��
	 * @param node �����������ĸ����
	 * @param sb ��������������Ԫ�صı������������sb��
	 * @return ������������Ԫ�ص��ַ�����ʽ
	 */
	private String inOrder(FOBinarySearchTreeNode<E> node, StringBuffer sb) {
		if (node != null) {
			inOrder(node.getLeftChild(), sb);
			sb.append(node + ", ");
			inOrder(node.getRightChild(), sb);
		}
		return sb.toString();
	}
	/**
	 * @TODO ����������������������Ԫ��
	 * @return ������������Ԫ�ص��ַ�����ʽ
	 */
	public String postOrderPrint() {
		StringBuffer sb = new StringBuffer("[");
		this.postOrder(root, sb);
		sb.replace(sb.length() - 2, sb.length() - 1, "]");
		return sb.toString();
	}
	/**
	 * @TODO ����������������������Ԫ�صľ���ʵ��
	 * @param node �����������ĸ����
	 * @param sb ��������������Ԫ�صı������������sb��
	 * @return ������������Ԫ�ص��ַ�����ʽ
	 */
	private String postOrder(FOBinarySearchTreeNode<E> node, StringBuffer sb) {
		if (node != null) {
			postOrder(node.getLeftChild(), sb);
			postOrder(node.getRightChild(), sb);
			sb.append(node + ", ");
		}
		return sb.toString();
	}

}
