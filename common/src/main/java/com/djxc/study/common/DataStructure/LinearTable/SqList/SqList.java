package com.djxc.study.common.DataStructure.LinearTable.SqList;

public class SqList {
	/**
	 * length��ʾ���Ա�Ԫ�صĸ���
	 * table��ʾ���Ա������
	 */
	private int length;
	private int size;
	private Object table[]; 
	
	/**
	 * ��ʼ��˳�����Ա��ṩ���Ա�Ĵ�Сn
	 * @param n
	 */
	public SqList(int n){
		this.table = new Object[n];
		this.size = n;
		this.length = 0;
	}
	
	public SqList(Object[] os){
		this.table = os;
		this.length = os.length;
	}
	
	/**
	 * ����Ԫ�أ������жϱ��Ƿ����ˣ�Ȼ���жϲ���λ���Ƿ���ȷ
	 * ���Ա��С��һ��index�Ժ��Ԫ������Ժ�һ��λ��
	 * @param index
	 * @param o
	 */
	public void insertSqList(int index, Object o){
		if(!isFull()){			
			if(index <= this.length){
				for(int i = this.length; i >= index ; i--){
					table[i] = table[i - 1];
				}
				this.table[index] = o;
				this.length++;
			} else{
				System.out.println("����ʧ�ܣ������indexλ�ò���");
			}
		}else{
			System.out.println("����ʧ�ܣ����Ա��Ѿ�����");
		}
	}
	
	/**
	 * ����һ��λ�ã�ɾ����λ��Ԫ��
	 * �����ж�index�Ƿ��������0����С��table�ĳ���
	 * @param index
	 */
	public void deleteSqList(int index){
		if(!isEmpty()){			
			if(index >= 0 || index < table.length){			
				for (int i = index; i < this.length; i++){
					table[i] = table[i+1];
				}
				this.length--;
			}else{
				System.out.println("ɾ��Ԫ��ʧ�ܣ�indexλ�ò���");
			}
		}
	}
	
	/**
	 * ����Ԫ�أ��жϲ���λ���Ƿ���ȷ
	 * �жϵ�ǰλ���Ƿ�Ϊ�գ�����ʹ���Ա��С��һ��
	 * @param index
	 * @param o
	 */
	public void setSqList(int index, Object o){			
		if(index < this.table.length){
			if(table[index] == null){					
				this.length++;				
			}
			this.table[index] = o;
		} else{
			System.out.println("����ʧ�ܣ������indexλ�ò���");
		}		
	}
	
	/**
	 * ����Ԫ��
	 * ����һ��Ԫ�أ��������Ա�������Ա�ǰԪ����Ŀ��Ԫ����ȷ���λ��
	 * @param o
	 * @return
	 */
	public int findElement(Object o){
		for (int i = 0; i < table.length;i ++){
			if(table[i] == o){
				return i;
			}
		}
		return -1;
	}
	
	
	public void mergeList(SqList list1, SqList list2, SqList toList){
		int sumLength = list1.getLength() + list2.getLength();
		if(sumLength < toList.getSize()){
			int i = 0, j = 0, m = 0;
			while(i < list1.getLength()){				
				toList.table[m++] = list1.table[i++];
			}
			while(j < list2.getLength()){				
				toList.table[m++] = list2.table[j++];
			}
			
		}else{
			System.out.println("Ŀ�����Ա�̫С���Ų��£�");
		}
	}
	
	/**
	 * �����ж����Ա��Ƿ�����
	 * @return
	 */
	public boolean isFull(){
		return this.length == table.length; 		
	}
	
	/**
	 * �ж����Ա��Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return this.length == 0;
	}
	
	/**
	 * ������Ա��Ԫ�أ��������Ա�ÿ��Ԫ��Ȼ�����
	 */
	public void printSqList(){
		for (int i = 0; i < table.length;i ++){
			System.out.print(table[i] + " ");
		}
		System.out.println("\t");
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
