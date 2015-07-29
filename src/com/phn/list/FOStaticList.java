package com.phn.list;


/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 静态链表 
 * @date 2015年7月19日
 */
public class FOStaticList<E> {
	//静态链表的长度
	private int size;
	//静态链表的容量,实际容量为capacity-2：capacity-头结点-备用头结点=capacity-2
	private int capacity;
	//备用链表的头结点
	private FOStaticNode<E> backNode= null;
	//备用链表在数组中的位置，默认为第一个，即为0
	private int backNodeIndex = 0;
	//静态链表的头结点，即静态链表数据元素链的头结点
	private FOStaticNode<E> headerNode = null;
	//静态链表的存储数据元素的数组
	private FOStaticNode<E>[] fosn = null;
	//默认容量
	private static final int DEFUALT_CAPACITY = 100;
	
	public FOStaticList(){
		this(DEFUALT_CAPACITY);
	}

	/**
	 * @TODO 带参构造函数，用来初始化赋值静态链表，并进行相关容量和大小的设置
	 * @param initialCapacity 静态链表的初始化容量 
	 */
	public FOStaticList(int initialCapacity) {
		this.init(initialCapacity);
		this.setCapacity(initialCapacity);
		this.setSize();
	}

	/**
	 * @TODO 初始化赋值静态链表，并设置静态链表的头结点和备用链表的头结点
	 * @param initialCapacity
	 */
	private void init(int initialCapacity) {
		//判断给定的初始化参数是否合法
		if (initialCapacity < 0) {
			throw new RuntimeException("数组大小错误:" + initialCapacity);
		}
		fosn = new FOStaticNode[initialCapacity];
		//给静态链表赋值，内部的e=null，而游标设置为i+1
		for(int i = 0;i<initialCapacity-1;i++){
			fosn[i]  = new FOStaticNode<E>();
			fosn[i].setCursor(i+1);
		}
		fosn[initialCapacity-1] = new FOStaticNode<E>();
		//设置静态链表的头结点指向备用链表的数组下标，即initialCapacity-1的节点的游标为0
		fosn[initialCapacity-1].setCursor(backNodeIndex);
		//设置静态链表的头结点为headerNode
		this.setHeaderNode(fosn[initialCapacity-1]);
		//设置备用链表的头结点为backNode
		this.setBackNode(fosn[backNodeIndex]);
	}

	/**
	 * @TODO 静态链表尾插法添加数据元素
	 * @param e 要添加的数据元素
	 * @return true
	 */
	public boolean add(E e){
		//检查链表的容量，并进行相应的扩容
		this.ensureCapacity(size);
		//将备用链表头结点指向的游标（即备用链表的第一个位置）赋值给oldBackNodeCursor保存
		int oldBackNodeCursor = this.backNode.getCursor();
		if(size==0){
			/*若目前（即添加元素之前）静态链表没有数据元素，则将静态链表的头结点的游标指向
			 *   “备用链表头结点指向的游标对应的位置”，即备用链表的第一个元素位置*/
			this.headerNode.setCursor(oldBackNodeCursor);
		}else{
			//将静态链表的头结点指向的游标赋值给tempNodeCursor
			int tempNodeCursor = this.headerNode.getCursor();
			//下面的循环用来找到静态链表（数据元素链）的最后一个元素节点lastNode
			FOStaticNode<E> lastNode = new FOStaticNode<E>();
			while(tempNodeCursor!=0){
				lastNode= this.fosn[tempNodeCursor];
				tempNodeCursor= this.fosn[tempNodeCursor].getCursor();
			}
			//将lastNode节点的指向游标设置值为备用链表的第一个位置
			lastNode.setCursor(oldBackNodeCursor);
		}
		//将备用链表的第一个位置设置数据元素为e
		this.fosn[oldBackNodeCursor].setE(e);
		//获取备用链表的第一个位置指向的游标，并将其赋值给newBackNodeCursor（作为新的备用链表头结点指向的游标）保存，
		int newBackNodeCursor = this.fosn[oldBackNodeCursor].getCursor();
		//设置备用链表的第一个位置（即目前作为静态链表数据元素链的最后一个元素）指向的游标为备用链表的头结点位置（默认0位置）
		this.fosn[oldBackNodeCursor].setCursor(backNodeIndex);
		//设置备用链表头结点指向的游标为新的备用链表头结点指向的游标newBackNodeCursor
		this.backNode.setCursor(newBackNodeCursor);
		//链表长度加1
		this.size++;
		return true;
	}
	/**
	 * @TODO 根据提供的index来删除静态链表中的第index个元素
	 * @param index 静态链表中的第index个元素
	 * @return true or false
	 */
	public boolean remove(int index){
		//判断给出的元素位置是否合法；this.capacity-2表示静态链表能够达到的最大长度：capacity-头结点-备用头结点=capacity-2
		if(index<1 || index>this.capacity-2){
			System.out.println("不存在此位置的元素");
			return false;
		}
		//声明变量preRemoveCursor用来作为将要删除的数据元素数组的下标，或者称为将要删除的数据元素的前一个节点指向的游标。
		int preRemoveCursor = this.headerNode.getCursor();
		//下面的循环用来找出删除的数据元素的前一个节点preRemoveNode和将要删除的数据元素的前一个节点指向的游标preRemoveCursor
		FOStaticNode<E> preRemoveNode = new FOStaticNode<E>();
		int tempCount = 0;
		while(tempCount!=index-1){
			preRemoveNode = this.fosn[preRemoveCursor];
			preRemoveCursor = preRemoveNode.getCursor();
			tempCount++;
		}
		//声明变量oldBackNodeCursor作为备用链表的头结指向的游标并赋值保存。
		int oldBackNodeCursor = this.backNode.getCursor();
		//设置备用链表的头结点指向的游标为 将要删除的数据元素数组的下标 preRemoveCursor
		this.backNode.setCursor(preRemoveCursor);
		//将将要删除的数据元素指向的游标赋值给removeCursor并保存
		int removeCursor = this.fosn[preRemoveCursor].getCursor();
		//将将要删除的数据元素指向的游标设置为备用链表的头结指向的游标oldBackNodeCursor
		this.fosn[preRemoveCursor].setCursor(oldBackNodeCursor);
		//将将要删除的数据元素设置为null，即删除
		this.fosn[preRemoveCursor].setE(null);
		//将将要删除的数据元素的前一个节点指向的游标设置为将要删除的数据元素指向的游标removeCursor
		preRemoveNode.setCursor(removeCursor);
		//长度减1
		this.size--;
		return true;
	}
	
	

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[ ");
		int currentCursor = this.headerNode.getCursor();
		if(currentCursor!=backNodeIndex){
			sb.append(currentCursor+""+this.fosn[currentCursor]);
			currentCursor = this.fosn[currentCursor].getCursor();
			while(currentCursor!=backNodeIndex){
				sb.append(", "+currentCursor+""+this.fosn[currentCursor]);
				currentCursor = this.fosn[currentCursor].getCursor();
			}
		}
		return sb.append(" ]").toString();
	}
	/**
	 * @TODO 判断静态链表的容量是否超过，并进行相应的扩容操作。
	 * 注意：这里最主要的是将当前静态链表数组下标最后一个位置的游标保存起来，即将头结点指向的游标保存起来；
	 * 然后赋值给新的静态链表的头结点指向的游标。
	 * @param currentSize 当前长度
	 */
	private void ensureCapacity(int currentSize) {
		if(currentSize == this.capacity-2){
			int oldCapacity = this.capacity;
			//这里我是按照ArrayList的扩容来进行的，扩大约1.5倍左右。
			this.capacity = (this.capacity * 3) / 2 + 1;
			FOStaticNode<E>[] newData = new FOStaticNode[this.capacity];
			for (int i = 0; i < oldCapacity-1; i++) {
				newData[i] = this.fosn[i];
			}
			newData[capacity-1]  = new FOStaticNode<E>();
			newData[capacity-1].setCursor(this.fosn[oldCapacity-1].getCursor());
			for(int i = oldCapacity-1;i<this.capacity-1;i++){
				newData[i]  = new FOStaticNode<E>();
				newData[i].setCursor(i+1);
			}
			this.fosn = newData;
		}
	}

	/**
	 * @return the size
	 */
	public int size() {
		return size;
	}
	private void setSize() {
		this.size=0;
	}

	/**
	 * @param backNode the backNode to set
	 */
	private void setBackNode(FOStaticNode<E> backNode) {
		this.backNode = backNode;
	}


	/**
	 * @param headerNode the headerNode to set
	 */
	private void setHeaderNode(FOStaticNode<E> headerNode) {
		this.headerNode = headerNode;
	}

	/**
	 * @param capacity the capacity to set
	 */
	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
