package com.phn.tree;

/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 二叉查找树
 * @date 2015年7月27日
 */
public class FOBinarySearchTree<E extends Comparable<E>> {
	//二叉查找树的根结点
	private FOBinaryTreeNode<E> root;

	/**
	 * TODO 无参构造函数，初始化二叉排序树
	 */
	public FOBinarySearchTree() {
		this.root = null;
	}
	/**
	 * @TODO 输入元素e是否包含在该二叉排序树中
	 * @param e 输入元素
	 * @return true or false
	 */
	public boolean contains(E e) {
		return this.contains2(e, root);
	}

	/**
	 * @TODO 二叉排序树是否包含某个元素的具体实现
	 * @param e 输入元素
	 * @param node 树的根结点
	 * @return true or false
	 */
	private boolean contains2(E e, FOBinaryTreeNode<E> node) {
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
	 * @TODO 二叉排序树查找输入元素在树中的结点信息
	 * @param e 输入元素
	 * @return 该输入元素在树中的结点信息
	 */
	public FOBinaryTreeNode<E> search(E e) {
		if (root == null) {
			throw new RuntimeException("该树为空！");
		}
		FOBinaryTreeNode<E> tempNode = root;
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
	 * @TODO 二叉排序树插入元素
	 * @param e 需要插入的元素
	 * @return true or false
	 */
	public boolean add(E e) {
		if (root == null) {
			root = new FOBinaryTreeNode<E>();
			root.setE(e);
			return true;
		}
		FOBinaryTreeNode<E> tempInsertNode = root;
		FOBinaryTreeNode<E> insertParentNode = new FOBinaryTreeNode<E>();
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
		FOBinaryTreeNode<E> insertNode = new FOBinaryTreeNode<E>();
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
	 * @TODO 二叉排序树删除在数中的输入的元素e
	 * @param e 将要删除的输入元素
	 * @return true or false
	 */
	public boolean remove(E e) {
		FOBinaryTreeNode<E> removeNode = this.search(e);
		if (removeNode == null) {
			return false;
		}
		FOBinaryTreeNode<E> preRemoveNode = this.findPreNode(removeNode);
		if (preRemoveNode != null) {
			removeByPreNode(removeNode, preRemoveNode);
			return true;
		}

		FOBinaryTreeNode<E> nextRemoveNode = this.findNextNode(removeNode);
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
	 * @TODO 删除二叉排序树中的结点后将其前驱结点替代
	 * @param removeNode 将要删除的结点
	 * @param preRemoveNode 将要删除的结点的前驱结点
	 */
	private void removeByPreNode(FOBinaryTreeNode<E> removeNode,
			FOBinaryTreeNode<E> preRemoveNode) {
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
	 * @TODO 删除二叉排序树中的结点后将其后继结点替代
	 * @param removeNode 将要删除的结点
	 * @param nextRemoveNode 将要删除的结点的后继结点
	 */
	private void removeByNextNode(FOBinaryTreeNode<E> removeNode,
			FOBinaryTreeNode<E> nextRemoveNode) {
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
	 * @TODO 获取输入结点的前驱结点
	 * @param node 输入的结点
	 * @return 输入结点的前驱结点
	 */
	public FOBinaryTreeNode<E> findPreNode(FOBinaryTreeNode<E> node) {
		if (node == null) {
			throw new RuntimeException("传入结点为空！");
		}
		FOBinaryTreeNode<E> tempNode = node.getLeftChild();
		if (tempNode == null) {
			// throw new RuntimeException("传入结点无前驱节点！");
			return null;
		}
		FOBinaryTreeNode<E> preNode = tempNode;
		tempNode = tempNode.getRightChild();
		while (tempNode != null) {
			preNode = tempNode;
			tempNode = tempNode.getRightChild();
		}
		return preNode;
	}

	/**
	 * @TODO 获取输入结点的后继结点
	 * @param node 输入结点
	 * @return 输入结点的后继结点
	 */
	public FOBinaryTreeNode<E> findNextNode(FOBinaryTreeNode<E> node) {
		if (node == null) {
			throw new RuntimeException("传入结点为空！");
		}
		FOBinaryTreeNode<E> tempNode = node.getRightChild();
		if (tempNode == null) {
			// throw new RuntimeException("传入结点无后继节点！");
			return null;
		}
		FOBinaryTreeNode<E> nextNode = tempNode;
		tempNode = tempNode.getLeftChild();
		while (tempNode != null) {
			nextNode = tempNode;
			tempNode = tempNode.getLeftChild();
		}
		return nextNode;
	}

	/**
	 * @TODO 获取该二叉排序树的最大元素
	 * @return 该二叉排序树的最大元素
	 */
	public E getMaxE(){
		return this.getMaxE(root);
	}
	
	/**
	 * @TODO 获取输入二叉排序树的最大元素的具体实现
	 * @param node 输入二叉排序树的根结点 
	 * @return 该输入二叉排序树的最大元素
	 */
	private E getMaxE(FOBinaryTreeNode<E> node) {
		if(node ==null){
			return null;
		}
		while(node.getRightChild()!=null){
			node = node.getRightChild();
		}
		return node.getE();
	}
	/**
	 * @TODO 获取该二叉排序树的最小元素
	 * @return 该二叉排序树的最小元素
	 */
	public E getMinE(){
		return this.getMinE(root);
	}

	/**
	 * @TODO 获取输入二叉排序树的最小元素的具体实现
	 * @param node 输入二叉排序树的根结点 
	 * @return 该输入二叉排序树的最小元素
	 */
	private E getMinE(FOBinaryTreeNode<E> node) {
		if(node ==null){
			return null;
		}
		while(node.getLeftChild()!=null){
			node = node.getLeftChild();
		}
		return node.getE();
	}

	/**
	 * @TODO 前序遍历输出二叉排序树中元素
	 * @return 二叉排序树中元素的字符串形式
	 */
	public String preOrderPrint() {
		StringBuffer sb = new StringBuffer("[");
		this.preOrder(root, sb);
		sb.replace(sb.length() - 2, sb.length() - 1, "]");
		return sb.toString();
	}
	/**
	 * @TODO 前序遍历输出二叉排序树中元素的具体实现
	 * @param node 二叉排序树的根结点
	 * @param sb 将二叉排序树中元素的遍历结果保存在sb中
	 * @return 二叉排序树中元素的字符串形式
	 */
	private String preOrder(FOBinaryTreeNode<E> node, StringBuffer sb) {
		if (node != null) {
			sb.append(node + ", ");
			preOrder(node.getLeftChild(), sb);
			preOrder(node.getRightChild(), sb);
		} 
		return sb.toString();
	}
	/**
	 * @TODO 中序遍历输出二叉排序树中元素
	 * @return 二叉排序树中元素的字符串形式
	 */
	public String inOrderPrint() {
		StringBuffer sb = new StringBuffer("[");
		this.inOrder(root, sb);
		sb.replace(sb.length() - 2, sb.length() - 1, "]");
		return sb.toString();
	}
	/**
	 * @TODO 中序遍历输出二叉排序树中元素的具体实现
	 * @param node 二叉排序树的根结点
	 * @param sb 将二叉排序树中元素的遍历结果保存在sb中
	 * @return 二叉排序树中元素的字符串形式
	 */
	private String inOrder(FOBinaryTreeNode<E> node, StringBuffer sb) {
		if (node != null) {
			inOrder(node.getLeftChild(), sb);
			sb.append(node + ", ");
			inOrder(node.getRightChild(), sb);
		}
		return sb.toString();
	}
	/**
	 * @TODO 后序遍历输出二叉排序树中元素
	 * @return 二叉排序树中元素的字符串形式
	 */
	public String postOrderPrint() {
		StringBuffer sb = new StringBuffer("[");
		this.postOrder(root, sb);
		sb.replace(sb.length() - 2, sb.length() - 1, "]");
		return sb.toString();
	}
	/**
	 * @TODO 中序遍历输出二叉排序树中元素的具体实现
	 * @param node 二叉排序树的根结点
	 * @param sb 将二叉排序树中元素的遍历结果保存在sb中
	 * @return 二叉排序树中元素的字符串形式
	 */
	private String postOrder(FOBinaryTreeNode<E> node, StringBuffer sb) {
		if (node != null) {
			postOrder(node.getLeftChild(), sb);
			postOrder(node.getRightChild(), sb);
			sb.append(node + ", ");
		}
		return sb.toString();
	}

}
