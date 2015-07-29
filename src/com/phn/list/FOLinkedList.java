package com.phn.list;


/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO �޻�������
 * @date 2015��7��18��
 */
public class FOLinkedList<E> {
	//	�������ͷ���
	private FOLinkedNode<E> header = null;
	//	������ĳ���
	private int size;

	/**
	 * @TODO Ĭ�ϵ��޲ι��캯��
	 */
	public FOLinkedList() {
		super();
		this.header = new FOLinkedNode<E>();
		this.setSize();
	}
	/**
	 * @TODO ���������Ԫ��,β�巨
	 * @param e ����Ԫ��
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
	 * @TODO ���������Ԫ��,ͷ�巨
	 * @param e ����Ԫ��
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
	 * @TODO ���������Ԫ��
	 * @param index ����λ��
	 * @param e ����Ԫ������
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
	 * @TODO ������ɾ��Ԫ��
	 * @param index ��Ҫɾ����Ԫ�ص�����λ��
	 * @return E ɾ����Ԫ��
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
	 * @TODO �ظ��ڵ��ɾ��
	 * @param foll ��Ҫɾ���ظ��ڵ�ĵ�����
	 * @return foll ɾ���ظ��ڵ��ĵ�����
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
	 * @TODO ��������Ԫ������Ϊ�����͡��ĵ��������ߵݼ���������ϲ�����a���������
	 * @param bFoll ������b
	 * @return c ������c
	 * ���ϲ����Ϊ�ǵݼ������߷ǵ�������ȡ����a,b����ĵ����ݼ����ʺͺϲ������Ĳ��뷽����ѡȡ��
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
			//������Բ���ͷ�巨������β�巨
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
	 * @TODO ���ó�ѭ������
	 */
	public void setLoop(){
		FOLinkedNode<E> p = new FOLinkedNode<E>();
		p=this.header;
		FOLinkedNode<E> q = new FOLinkedNode<E>();
		q = this.last(p);
		q.addNext(p);
	}
	/**
	 * @TODO ָ��ĳ��λ�������������л�
	 * @param index �����ĳ��λ��
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
	 * @TODO �ж������Ƿ��л�(����ָ�뷨)
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
	 * @TODO ���û��Ķ������ͱ�����ȵĹ�ϵ�����ж��Ƿ��л�
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
	 * @TODO ����Ԫ������λ�û�ȡԪ��
	 * @param index Ԫ�ص�����λ��
	 * @return E Ԫ��e
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
				throw new RuntimeException("�ڵ��ֵ����");
			}
		}
		return temp;
	}
	/**
	 * @TODO ��������������λ��Ϊi��Ԫ���޸�ΪԪ��e
	 * @param index Ԫ�ص�����λ��
	 * @param e ��Ҫ�޸ĳɵ�Ԫ��
	 * @return true �޸ĳɹ���־
	 */
	public boolean set(int index, E e){
		validateIndex(index);
		FOLinkedNode<E> oldNode = this.get(index);
		oldNode.setE(e);
		return true;
	}
	/**
	 * @TODO ��֤��������λ���Ƿ�Ϸ�
	 * @param index ����������λ��
	 */
	private void validateIndex(int index) {
		if (index > this.size || index < 0) {
			throw new RuntimeException("��������" + index);
		}
	}
	/**
	 * @TODO ��ȡ����������һ���ڵ�
	 * @param header �������ͷ���
	 * @return node ����������һ���ڵ�
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
	 * @TODO ���õ�����ĳ���
	 * @return ������Ľڵ��ַ�������
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
	 * @TODO ���õ�����ĳ���
	 */
	private void setSize() {
		this.size = 0;
	}
	/**
	 * @TODO ��ȡ������ĳ���
	 * @return size ������ĳ���
	 */
	public int size() {
		return this.size;
	}

}
