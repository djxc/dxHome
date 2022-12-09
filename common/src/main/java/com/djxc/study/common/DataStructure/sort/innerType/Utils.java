package com.djxc.study.common.DataStructure.sort.innerType;

import java.util.Comparator;
import java.util.List;


/**
 * ����
 * @author Administrator
 *
 */
public class Utils {
	/**
	 * List������+�Ƚ���
	 * @param list
	 * @param com
	 */
	public static  <T> void sort(List<T> list,Comparator<T> com){
		//��һ��:ת������
		Object[] arr =list.toArray();
		sort(arr,com);
		//�ڶ���:�ı������ж�Ӧ��ֵ
		for(int i=0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		}
	}
	
	
	/**
	 * ��������� ������+Comparator�ӿ�
	 * @param arr
	 */
	public static <T> void sort(Object[] arr,Comparator<T> com){
		//�Ӵ�С���� ����
			boolean sorted= true;
			int len =arr.length;
			for(int j=0;j<len-1;j++){ //����
				sorted =true; //�ٶ�����
				for(int i=0;i<len-1-j;i++){ //����
					if(com.compare((T)arr[i], (T)arr[i+1])<0){
						Object temp = arr[i];
						arr[i] =arr[i+1];
						arr[i+1] =temp;
						sorted =false; //�ٶ�ʧ��
					}
				}
				if(sorted){ //��������
					break;
				}
			}
	}
	
	
	
	/**
	 * �������� (ʹ�÷��ͷ���)
	 */
	public static <T extends Comparable<T>> void sort(List<T> list){
		//��һ��:ת������
		Object[] arr =list.toArray();
		sort(arr);
		//�ڶ���:�ı������ж�Ӧ��ֵ
		for(int i=0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		}
		
	}
	
	
	/**
	 * �������� (ʹ�÷��ͷ���)
	 */
	public static <T extends Comparable<T>> void sort(T[] arr){
		//�Ӵ�С���� ����
		boolean sorted= true;
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //����
			sorted =true; //�ٶ�����
			for(int i=0;i<len-1-j;i++){ //����
				if(((Comparable)arr[i]).compareTo(arr[i+1])<0){
					T temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
					sorted =false; //�ٶ�ʧ��
				}
			}
			if(sorted){ //��������
				break;
			}
		}
	}	
	
	/**
	 * ��������� ������
	 * @param arr
	 */
	public static void sort(Object[] arr){
		//�Ӵ�С���� ����
		boolean sorted= true;
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //����
			sorted =true; //�ٶ�����
			for(int i=0;i<len-1-j;i++){ //����
				if(((Comparable)arr[i]).compareTo(arr[i+1])<0){
					Object temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
					sorted =false; //�ٶ�ʧ��
				}
			}
			if(sorted){ //��������
				break;
			}
		}
		
	}
	
	
}
