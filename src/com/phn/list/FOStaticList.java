package com.phn.list;


/**
 * @author �˺���
 * @Email 1016593477@qq.com
 * @TODO ��̬���� 
 * @date 2015��7��19��
 */
public class FOStaticList<E> {
	//��̬����ĳ���
	private int size;
	//��̬���������,ʵ������Ϊcapacity-2��capacity-ͷ���-����ͷ���=capacity-2
	private int capacity;
	//���������ͷ���
	private FOStaticNode<E> backNode= null;
	//���������������е�λ�ã�Ĭ��Ϊ��һ������Ϊ0
	private int backNodeIndex = 0;
	//��̬�����ͷ��㣬����̬��������Ԫ������ͷ���
	private FOStaticNode<E> headerNode = null;
	//��̬����Ĵ洢����Ԫ�ص�����
	private FOStaticNode<E>[] fosn = null;
	//Ĭ������
	private static final int DEFUALT_CAPACITY = 100;
	
	public FOStaticList(){
		this(DEFUALT_CAPACITY);
	}

	/**
	 * @TODO ���ι��캯����������ʼ����ֵ��̬������������������ʹ�С������
	 * @param initialCapacity ��̬����ĳ�ʼ������ 
	 */
	public FOStaticList(int initialCapacity) {
		this.init(initialCapacity);
		this.setCapacity(initialCapacity);
		this.setSize();
	}

	/**
	 * @TODO ��ʼ����ֵ��̬���������þ�̬�����ͷ���ͱ��������ͷ���
	 * @param initialCapacity
	 */
	private void init(int initialCapacity) {
		//�жϸ����ĳ�ʼ�������Ƿ�Ϸ�
		if (initialCapacity < 0) {
			throw new RuntimeException("�����С����:" + initialCapacity);
		}
		fosn = new FOStaticNode[initialCapacity];
		//����̬����ֵ���ڲ���e=null�����α�����Ϊi+1
		for(int i = 0;i<initialCapacity-1;i++){
			fosn[i]  = new FOStaticNode<E>();
			fosn[i].setCursor(i+1);
		}
		fosn[initialCapacity-1] = new FOStaticNode<E>();
		//���þ�̬�����ͷ���ָ��������������±꣬��initialCapacity-1�Ľڵ���α�Ϊ0
		fosn[initialCapacity-1].setCursor(backNodeIndex);
		//���þ�̬�����ͷ���ΪheaderNode
		this.setHeaderNode(fosn[initialCapacity-1]);
		//���ñ��������ͷ���ΪbackNode
		this.setBackNode(fosn[backNodeIndex]);
	}

	/**
	 * @TODO ��̬����β�巨�������Ԫ��
	 * @param e Ҫ��ӵ�����Ԫ��
	 * @return true
	 */
	public boolean add(E e){
		//����������������������Ӧ������
		this.ensureCapacity(size);
		//����������ͷ���ָ����α꣨����������ĵ�һ��λ�ã���ֵ��oldBackNodeCursor����
		int oldBackNodeCursor = this.backNode.getCursor();
		if(size==0){
			/*��Ŀǰ�������Ԫ��֮ǰ����̬����û������Ԫ�أ��򽫾�̬�����ͷ�����α�ָ��
			 *   ����������ͷ���ָ����α��Ӧ��λ�á�������������ĵ�һ��Ԫ��λ��*/
			this.headerNode.setCursor(oldBackNodeCursor);
		}else{
			//����̬�����ͷ���ָ����α긳ֵ��tempNodeCursor
			int tempNodeCursor = this.headerNode.getCursor();
			//�����ѭ�������ҵ���̬��������Ԫ�����������һ��Ԫ�ؽڵ�lastNode
			FOStaticNode<E> lastNode = new FOStaticNode<E>();
			while(tempNodeCursor!=0){
				lastNode= this.fosn[tempNodeCursor];
				tempNodeCursor= this.fosn[tempNodeCursor].getCursor();
			}
			//��lastNode�ڵ��ָ���α�����ֵΪ��������ĵ�һ��λ��
			lastNode.setCursor(oldBackNodeCursor);
		}
		//����������ĵ�һ��λ����������Ԫ��Ϊe
		this.fosn[oldBackNodeCursor].setE(e);
		//��ȡ��������ĵ�һ��λ��ָ����α꣬�����丳ֵ��newBackNodeCursor����Ϊ�µı�������ͷ���ָ����α꣩���棬
		int newBackNodeCursor = this.fosn[oldBackNodeCursor].getCursor();
		//���ñ�������ĵ�һ��λ�ã���Ŀǰ��Ϊ��̬��������Ԫ���������һ��Ԫ�أ�ָ����α�Ϊ���������ͷ���λ�ã�Ĭ��0λ�ã�
		this.fosn[oldBackNodeCursor].setCursor(backNodeIndex);
		//���ñ�������ͷ���ָ����α�Ϊ�µı�������ͷ���ָ����α�newBackNodeCursor
		this.backNode.setCursor(newBackNodeCursor);
		//�����ȼ�1
		this.size++;
		return true;
	}
	/**
	 * @TODO �����ṩ��index��ɾ����̬�����еĵ�index��Ԫ��
	 * @param index ��̬�����еĵ�index��Ԫ��
	 * @return true or false
	 */
	public boolean remove(int index){
		//�жϸ�����Ԫ��λ���Ƿ�Ϸ���this.capacity-2��ʾ��̬�����ܹ��ﵽ����󳤶ȣ�capacity-ͷ���-����ͷ���=capacity-2
		if(index<1 || index>this.capacity-2){
			System.out.println("�����ڴ�λ�õ�Ԫ��");
			return false;
		}
		//��������preRemoveCursor������Ϊ��Ҫɾ��������Ԫ��������±꣬���߳�Ϊ��Ҫɾ��������Ԫ�ص�ǰһ���ڵ�ָ����αꡣ
		int preRemoveCursor = this.headerNode.getCursor();
		//�����ѭ�������ҳ�ɾ��������Ԫ�ص�ǰһ���ڵ�preRemoveNode�ͽ�Ҫɾ��������Ԫ�ص�ǰһ���ڵ�ָ����α�preRemoveCursor
		FOStaticNode<E> preRemoveNode = new FOStaticNode<E>();
		int tempCount = 0;
		while(tempCount!=index-1){
			preRemoveNode = this.fosn[preRemoveCursor];
			preRemoveCursor = preRemoveNode.getCursor();
			tempCount++;
		}
		//��������oldBackNodeCursor��Ϊ���������ͷ��ָ����α겢��ֵ���档
		int oldBackNodeCursor = this.backNode.getCursor();
		//���ñ��������ͷ���ָ����α�Ϊ ��Ҫɾ��������Ԫ��������±� preRemoveCursor
		this.backNode.setCursor(preRemoveCursor);
		//����Ҫɾ��������Ԫ��ָ����α긳ֵ��removeCursor������
		int removeCursor = this.fosn[preRemoveCursor].getCursor();
		//����Ҫɾ��������Ԫ��ָ����α�����Ϊ���������ͷ��ָ����α�oldBackNodeCursor
		this.fosn[preRemoveCursor].setCursor(oldBackNodeCursor);
		//����Ҫɾ��������Ԫ������Ϊnull����ɾ��
		this.fosn[preRemoveCursor].setE(null);
		//����Ҫɾ��������Ԫ�ص�ǰһ���ڵ�ָ����α�����Ϊ��Ҫɾ��������Ԫ��ָ����α�removeCursor
		preRemoveNode.setCursor(removeCursor);
		//���ȼ�1
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
	 * @TODO �жϾ�̬����������Ƿ񳬹�����������Ӧ�����ݲ�����
	 * ע�⣺��������Ҫ���ǽ���ǰ��̬���������±����һ��λ�õ��α걣������������ͷ���ָ����α걣��������
	 * Ȼ��ֵ���µľ�̬�����ͷ���ָ����αꡣ
	 * @param currentSize ��ǰ����
	 */
	private void ensureCapacity(int currentSize) {
		if(currentSize == this.capacity-2){
			int oldCapacity = this.capacity;
			//�������ǰ���ArrayList�����������еģ�����Լ1.5�����ҡ�
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
