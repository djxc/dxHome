package com.djxc.study.common.DataStructure.sort.bubble;

import java.util.Arrays;

/**
 * ���հ汾�����Ǵ���˳��
 * @author Administrator
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		int[] arr ={1,2,9,3,4};
		sort1(arr);

		System.out.println("==========final============");
		arr =new int[]{9,1,2,3,4};
		sortFinal(arr);
	}
	//�ڶ��汾������ÿһ�˵Ĵ���
	public static void sortFinal(int[] arr){
			boolean sorted= true;
			int len =arr.length;
			for(int j=0;j<len-1;j++){ //����
				sorted =true; //�ٶ�����
				for(int i=0;i<len-1-j;i++){ //����
					if(arr[i]>arr[i+1]){
						int temp = arr[i];
						arr[i] =arr[i+1];
						arr[i+1] =temp;
						sorted =false; //�ٶ�ʧ��
					}
					System.out.println(Arrays.toString(arr));
				}
				if(sorted){ //��������
					break;
				}
			}
		}

	//�ڶ��汾������ÿһ�˵Ĵ���
	public static void sort1(int[] arr){
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
