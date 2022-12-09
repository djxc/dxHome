package com.djxc.study.common.DataStructure.LinearTable.SqList;

public class LinkList {
	private int size = 0;
	private Node head;
	private Node local;
	
	public LinkList(){
		head = new Node("head");
		local = head;
	}
	
	/**
	 * ��ӽڵ㣬�ı�local��ֵָ�����Ľڵ㣬��size��һ
	 * @param node
	 */
	public void addNode(Node node){
		local.setNext(node);
		local = node;
		this.size++;
	}
	
	/**
	 * ��ӡ�������Ա�ĸ���Ԫ��
	 * �������ӱ����ÿ���ڵ��data
	 */
	public void printLinkList(){
		Node next = this.head.getNext();
		while(next!=null){
			System.out.print(next.getData() + " ");
			next = next.getNext();
		}
		System.out.println();
	}

	/**
	 * ��ȡָ���ڵ��data
	 * ͨ������index��Ȼ���������õ���index�ڵ㷵��data
	 * ���index<0�����size���Խ����ʾ������null
	 * @param index
	 * @return
	 */
	public Object getDataByIndex(int index){
		Node n = getNodeByIndex(index);		
		if(n!=null){				
			return n.getData();
		}else{
			System.out.println("indexԽ��");
			return null;
		}
	}
	
	/**
	 * ����ڵ�
	 * ͨ������λ�ý��ڵ����
	 * @param node
	 * @param index
	 */
	public void insertNode(Node node, int index){
		Node n = getNodeByIndex(index-1);		
		if(n!=null){
			node.setNext(n.getNext());
			n.setNext(node);
			this.size++;
		}else{
			System.out.println("indexԽ��,����ʧ��");
		}		
	}
	
	public void deleteNode(int index){
		if(index<=size){			
			Node node = getNodeByIndex(index-1);
			if(node!=null){			
				Node loc = node.getNext();
				node.setNext(loc.getNext());
				this.size--;
			}else{
				System.out.println("indexԽ��,ɾ��ʧ�ܣ�");
			}
		}else{
			System.out.println("indexԽ��,ɾ��ʧ�ܣ�");
		}
	}
	
	/**
	 * ��ȡָ��λ�õ�node
	 * @param index
	 * @return
	 */
	public Node getNodeByIndex(int index){
		if(index>0 && index<=size){	
			Node next = this.head.getNext();
			int i = 1;
			while(next!=null && i < index){
				next = next.getNext();
				i++;
			}
			return next;
		}else{			
			return null;
		}
	}
	
	public int getSize() {
		return size;
	}
	
}
