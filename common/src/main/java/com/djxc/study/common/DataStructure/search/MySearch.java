package com.djxc.study.common.DataStructure.search;

public class MySearch {
	public int SeqSearch(int[] array, int target) {
		for (int i = array.length-1; i>=0; i--) {
			if(array[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * �۰����
	 * ���ҵı����Ϊ�����
	 * @param array
	 * @param target
	 * @return
	 */
	public int BinSearch(int[] array, int target) {
		int low = 0, hight = array.length-1, mid = -1;
		while(low<=hight) {
			mid = (low + hight)/2;
			if(array[mid] == target) {
				return mid;
			}else if(array[mid]<target) {
				low = mid + 1;
			}else {
				hight = mid - 1;				
			}
		}
		return -1;
	}
	
}
