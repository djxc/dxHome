package com.djxc.study.common.DataStructure.sort.bubble;

import java.util.Arrays;


public class BubbleSort1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr ={9,8,7,6,5};		
		sort(arr);
		
	}
	//��һ�汾���ܼ�
	public static void sort(int[] arr){
		int len =arr.length;
		for(int j=0;j<len-1;j++){
			System.out.println("��"+(j+1)+"��");
			for(int i=0;i<len-1;i++){
				System.out.print("��"+(i+1)+"��");
				if(arr[i]>arr[i+1]){
					int temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
	public static void sortSecond(int[] arr){
		System.out.println("��һ��");
		for(int i=0;i<arr.length-1;i++){
			System.out.print("��"+(i+1)+"��");
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] =arr[i+1];
				arr[i+1] =temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("�ڶ���");
		for(int i=0;i<arr.length-1;i++){
			System.out.print("��"+(i+1)+"��");
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] =arr[i+1];
				arr[i+1] =temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("������");
		for(int i=0;i<arr.length-1;i++){
			System.out.print("��"+(i+1)+"��");
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] =arr[i+1];
				arr[i+1] =temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("������");
		for(int i=0;i<arr.length-1;i++){
			System.out.print("��"+(i+1)+"��");
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] =arr[i+1];
				arr[i+1] =temp;
			}
			System.out.println(Arrays.toString(arr));
		}
	
	}
	
	
	public static void sortFirst(int[] arr){
		System.out.println("��һ��");
		for(int i=0;i<arr.length-1;i++){
			System.out.print("��"+(i+1)+"��");
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] =arr[i+1];
				arr[i+1] =temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		
		/*
		//��һ�� ��һ��
		System.out.println("��һ�� ��һ��");
		int i=0;
		if(arr[i]>arr[i+1]){
			int temp = arr[i];
			arr[i] =arr[i+1];
			arr[i+1] =temp;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("��һ�� �ڶ���");
		i++;
		if(arr[i]>arr[i+1]){
			int temp = arr[i];
			arr[i] =arr[i+1];
			arr[i+1] =temp;
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("��һ�� ������");
		i++;
		if(arr[i]>arr[i+1]){
			int temp = arr[i];
			arr[i] =arr[i+1];
			arr[i+1] =temp;
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("��һ�� ���Ĵ�");
		i++;
		if(arr[i]>arr[i+1]){
			int temp = arr[i];
			arr[i] =arr[i+1];
			arr[i+1] =temp;
		}
		System.out.println(Arrays.toString(arr));
		
		*/
	}

}
