package com.phn.list;


/**
 * @author 潘海南
 * @Email 1016593477@qq.com
 * @TODO 无环单链表
 * @date 2015年7月18日
 */
public class FOLinkedList<E> {
	//	单链表的头结点
	private FOLinkedNode<E> header = null;
	//	单链表的长度
	private int size;

	/**
	 * @TODO 默认的无参构造函数
	 */
	public FOLinkedList() {
		super();
		this.header = new FOLinkedNode<E>();
		this.setSize();
	}
	/**
	 * @TODO 单链表添加元素,尾插法
	 * @param e 数据元素
	 * @return true
	 */
	public boolean add(E e) {
		FOLinkedNode<E> node = new FOLinkedNode<E>(e);
		if (header.getE() == null) {
			header.setE(e);
		} else {
			FOLinkedNode<E> lastNode = this.last(this.header);
			lastNode.addNext(node);
		}

		this.size++;
		return true;
	}
	/**
	 * @TODO 单链表添加元素,头插法
	 * @param e 数据元素
	 * @return true
	 */
	public boolean addFirst(E e){
		FOLinkedNode<E> node = new FOLinkedNode<E>(e);
		if (header.getE() == null) {
			header.setE(e);
		}else{
			node.addNext(header);
			header=node;
		}
		this.size++;
		return true;
	}
	/**
	 * @TODO 单链表插入元素
	 * @param index 插入位置
	 * @param e 数据元素类型
	 * @return true
	 */
	public boolean insert(int index,E e) {
		FOLinkedNode<E> node = new FOLinkedNode<E>(e);
		FOLinkedNode<E> preNode = this.get(index - 1);
		node.addNext(preNode.next);
		preNode.addNext(node);
		this.size++;
		return true;
	}
	/**
	 * @TODO 单链表删除元素
	 * @param index 将要删除的元素的索引位置
	 * @return E 删除的元素
	 */
	public FOLinkedNode<E> remove(int index){
		FOLinkedNode<E> preNode = this.get(index-1);
		FOLinkedNode<E> node = preNode.next;
		preNode.addNext(preNode.next.next);
		node.addNext(null);
		this.size--;
		return node;
	}
	/**
	 * @TODO 重复节点的删除
	 * @param foll 需要删除重复节点的单链表
	 * @return foll 删除重复节点后的单链表
	 */
	public static FOLinkedList removeRepeatElement(FOLinkedList foll){
		FOLinkedNode p = foll.header;
		if(foll.header==null){
			return foll;
		}
		while(p.next!=null){
			FOLinkedNode q = p.next;
			while(q.next!=null){
				if(q.next.getE().equals(p.getE())){
					q.addNext(q.next.next);
					foll.size--;
				}else{
					q = q.next;
				}
			}
			p=p.next;
		}
		return foll;
	}
	/**
	 * @TODO 两个数据元素类型为“整型”的递增（或者递减）单链表合并，由a单链表调用
	 * @param bFoll 单链表b
	 * @return c 单链表c
	 * （合并结果为非递减（或者非递增），取决于a,b链表的递增递减性质和合并函数的插入方法的选取）
	 */
	public FOLinkedList<Integer> merge(FOLinkedList<Integer> bFoll){
		FOLinkedList<Integer> c = new FOLinkedList<Integer>();
		FOLinkedNode<Integer> a = (FOLinkedNode<Integer>) this.header;
		FOLinkedNode<Integer> b = bFoll.header;
		Integer eTemp = new Integer(0);
		while(a != null && b != null){
			if(a.getE()<=b.getE()){
				eTemp = a.getE();
				a = a.next;
			}else{
				eTemp = b.getE();
				b = b.next;
			}
			//这里可以采用头插法，或者尾插法
			c.add(eTemp);
//			c.addFirst(eTemp);
		}
		if(a == null){
			a = b;
		}
		while(a != null){
			c.add(a.getE());
			a = a.next;
		}
		return c;
	}
	/**
	 * @TODO 设置成循环链表
	 */
	public void setLoop(){
		FOLinkedNode<E> p = new FOLinkedNode<E>();
		p=this.header;
		FOLinkedNode<E> q = new FOLinkedNode<E>();
		q = this.last(p);
		q.addNext(p);
	}
	/**
	 * @TODO 指定某个位置来设置链表还有环
	 * @param index 链表的某个位置
	 */
	public void setIndexLoop(int index){
		validateIndex(index);
		FOLinkedNode<E> p = new FOLinkedNode<E>();
		p=get(index);
		FOLinkedNode<E> q = new FOLinkedNode<E>();
		q=last(this.header);
		q.addNext(p);
	}
	
	/**
	 * @TODO 判断链表是否含有环(快慢指针法)
	 * @return true or false
	 */
	public boolean hasLoop(){
		FOLinkedNode<E> p = new FOLinkedNode<E>();
		FOLinkedNode<E> q = new FOLinkedNode<E>();
		p=this.header;
		if(p!=null){
			q = p.next;
			while(p!=null && q!=null && q.next!=null){
				if(p==q || p==q.next){
					return true;
				}
				q =q.next.next;
				p = p.next;
			}
		}
		return false;
	}
	/**
	 * @TODO 利用环的顶点数和边数相等的关系进行判断是否含有环
	 * @return true or false
	 */
	public boolean hasLoop2(){
		FOLinkedNode<E> temp = new FOLinkedNode<E>();
		temp = this.header.next;
		int tempSize = this.size();
		while (temp != null) {
			tempSize--;
			if(tempSize<=0){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	/**
	 * @TODO 根据元素索引位置获取元素
	 * @param index 元素的索引位置
	 * @return E 元素e
	 */
	public FOLinkedNode<E> get(int index) {
		validateIndex(index);
		FOLinkedNode<E> temp = this.header;
		int i = 0;
		while (i < index - 1) {
			if (temp != null) {
				temp = temp.next;
				i++;
			} else {
				throw new RuntimeException("节点空值错误");
			}
		}
		return temp;
	}
	/**
	 * @TODO 将单链表中索引位置为i的元素修改为元素e
	 * @param index 元素的索引位置
	 * @param e 需要修改成的元素
	 * @return true 修改成功标志
	 */
	public boolean set(int index, E e){
		validateIndex(index);
		FOLinkedNode<E> oldNode = this.get(index);
		oldNode.setE(e);
		return true;
	}
	/**
	 * @TODO 验证所给索引位置是否合法
	 * @param index 给出的索引位置
	 */
	private void validateIndex(int index) {
		if (index > this.size || index < 0) {
			throw new RuntimeException("索引错误：" + index);
		}
	}
	/**
	 * @TODO 获取单链表的最后一个节点
	 * @param header 单链表的头结点
	 * @return node 单链表的最后一个节点
	 */
	private FOLinkedNode<E> last(FOLinkedNode<E> header) {
		FOLinkedNode<E> temp = header;
		while (true) {
			if (temp.next == null) {
				return temp;
			}
			temp = temp.next;
		}
	}

	@Override
	public String toString() {
		return "[" + this.NodesToString(this) + "]";
	}
	/**
	 * @param foLinkedList 
	 * @TODO 设置单链表的长度
	 * @return 单链表的节点字符串序列
	 */
	private String NodesToString(FOLinkedList<E> foll) {
		StringBuffer sb = new StringBuffer();
		if (foll.header != null) {
			sb.append(foll.header.getE());
			FOLinkedNode<E> temp = new FOLinkedNode<E>();
			temp = foll.header.next;
			int tempSize = foll.size() - 1;
			while (temp != null && tempSize!=0) {
				sb.append(", " + temp.getE());
				temp = temp.next;
				tempSize--;
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * @TODO 设置单链表的长度
	 */
	private void setSize() {
		this.size = 0;
	}
	/**
	 * @TODO 获取单链表的长度
	 * @return size 单链表的长度
	 */
	public int size() {
		return this.size;
	}

}
