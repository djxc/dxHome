package com.djxc.study.common.DataStructure.sort;


public class MySort {
	
	public MySort() {
	}
	
	/**
	 * ֱ�Ӳ�������
	 * �������Ϊ�����֣�����õ��Լ�û������ģ�
	 * ѡ��û������õĵ�һ��Ԫ�ؼ�Ϊcurrent��������õ����һ����ʼѭ�����бȽϡ�
	 * ���currentС�ڱȽϵ�Ԫ�أ���ǰһ��λ����Ϊ��ǰԪ��ֵ����Ϊ��array[j+1] = array[j];
	 * @param array
	 * @return
	 */
	public void DirInsertsort(int[] array) {
		int a = 0;
		for (int i = 1; i< array.length; i++) {
			int current = array[i];
			int j = i - 1;
			
			while(j>=0 && current<array[j]) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = current;
			
//			for(int j = i - 1; j>=0; j--) {
//				if(current<array[j]) {
//					array[j+1] = array[j];
//					if(j == 0) {
//						array[j] = current;
//					}
//				}else {
//					array[j+1] = current;
//					break;
//				}
//			}
		}
	}

	
	public void ShellSort(int[] array, int[] d) {
		for(int i:d) {
			ShellInsert(array, i);
		}
	}
	
	public void ShellInsert(int[] array, int d) {
		
	}
	
	/**
	 * ð������
	 * ����Ԫ�ؽ��бȽϣ�����С��ǰ�߽��н�����
	 * ѭ��һ�Σ����ֵ�������������һ��λ�á�Ȼ��������ǰn-1��Ԫ�ؽ���ѭ��������
	 * ʹ��swap��¼ѭ��һ���Ƿ�����˽��������û��������ѭ����
	 * @param array
	 */
	public void BubbleSort(int[] array) {
		for(int j = 0; j<array.length; j++) {			
			int current = array[0];
			int swap = 0;
			for (int i = 1; i<array.length-j; i++) {
				if(array[i]<array[i-1]) {
					current = array[i];
					array[i] = array[i-1];
					array[i-1] = current;
					swap = 1;
				}			
			}
			if(swap == 0) {
				break;
			}
		}
	}
	
	/**
	 *  ��������
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	public void FastSort(int[] array, int start, int end) {
		int current = array[start];
		int i=start, j = end;
		while(i<j) {
			while(j>i && array[j]>=current) {
				j--;
			}
			if(i<j) {
				array[i++] = array[j];
			}
			while(j>i && array[i]<=current) {
				i++;
			}
			if(i<j) {
				array[j--] = array[i];
			}			
		}
		array[i] = current;
		if(start<end) {
			FastSort(array, start, i-1);
			FastSort(array, i+1, end);
		}
	}
	
	/**
	 * ѡ������
	 * ѡ���һ����Ϊ��С������Ȼ��������飬�Ƚϵ�ǰ������С���Ĵ�С�����С����С����������С����Ϊ��ǰ����
	 * ������һ���ҳ���С�����������С�������һ��������һ������н�����
	 * Ȼ��ӵڶ�������ʼ�������ϲ�����
	 * @param array
	 */
	public void SelectSort(int[] array) {
		int swap = 0;
		for(int i = 0; i<array.length;i++) {
			int current = i;
			for(int j = i+1; j<array.length; j++) {				
				if(array[current]>array[j]) {
					current = j;
				}
			}
			if(current!=i) {				
				swap = array[i];
				array[i] = array[current];
				array[current] = swap;
			}
		}
	}
	
}
