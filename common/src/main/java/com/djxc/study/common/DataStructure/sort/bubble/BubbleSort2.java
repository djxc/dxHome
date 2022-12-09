package com.djxc.study.common.DataStructure.sort.bubble;

import java.util.Arrays;

public class BubbleSort2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr ={9,8,7,6,5};		
		sort(arr);
	}
	//�ڶ��汾������ÿһ�˵Ĵ���
	public static void sort(int[] arr){
			int len =arr.length;
			for(int j=0;j<len-1;j++){ //����
				System.out.println("��"+(j+1)+"��");
				for(int i=0;i<len-1-j;i++){ //����
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

}
