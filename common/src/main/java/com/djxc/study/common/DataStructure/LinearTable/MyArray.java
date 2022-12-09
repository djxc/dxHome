package com.djxc.study.common.DataStructure.LinearTable;

public class MyArray {
	private int length = 0;
	private String [] strArray;
	
	public MyArray(int max){
		strArray = new String[max];
	}
	
	/**
	 * ���ַ������в鿴�Ƿ����ĳ���ַ�
	 * @param str
	 * @return
	 */
	public int contains(String str){
		for(int i = 0; i < length; i++){
			if(strArray[i].equals(str)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * �����ַ�
	 * @param str
	 */
	public void insert(String str){
		strArray[length] = str;
		length ++;
	}
	
	
	public boolean delete(String str){
		for(int i = 0; i < length; i++){
			if(strArray[i].equals(str)){
				replace(i);
				length--;
				return true;
			}
		}
		return false;
	}
	
	public void replace(int i){
		for (int j = i; j < length; j++){
			strArray[j] = strArray[j + 1];
		}
	}
	
	/**
	 * ��ʾ�ַ�
	 */
	public void display(){
		if(length == 0){
			System.out.println("��");
		}else{			
			for(int i = 0; i < length - 1; i++){
				System.out.print(strArray[i] + ", ");
			}		
			System.out.print(strArray[length - 1] + "\n");
		}
	}
	
}
