package com.djxc.study.common.DataStructure.Stack;

public class Stack {
	private Object[] data = null;
	private int size = 0;
	private int MaxSize;
	
	
	public Stack(int max)
	{
		data = new Object[max];
		this.MaxSize = max;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public boolean isFull(){
		return size == MaxSize;
	}
	
	/**
	 * ��ջ������Ԫ��
	 * @param o
	 */
	public void push(Object o){
		if(!isFull()){			
			data[size++] = o;
		}else{
			System.err.println("�Բ���,ջ����,�޷���ջ");
		}
	}
	
	public Object pop(){
		if(!isEmpty()){
			size--;
			return data[size];			
		}else{
			return null;
		}
	}
	
	public Object getTop(){
		if(!isEmpty()){
			return data[size];			
		}else{
			return null;
		}
	}
	
	public void display(){
		for(int i=0;i<size;i++){
			System.out.print(data[i] + " ");			
		}
		System.out.println();
	}
	
	public int size(){
		return size;
	}
	
}
