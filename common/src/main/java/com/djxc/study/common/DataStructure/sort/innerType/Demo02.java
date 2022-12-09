package com.djxc.study.common.DataStructure.sort.innerType;

import java.util.Arrays;

public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr ={"a","abcd","abc","def"};
		//�ӵ�С���� ����
		boolean sorted= true;
		int len =arr.length;
		for(int j=0;j<len-1;j++){ //����
			sorted =true; //�ٶ�����
			for(int i=0;i<len-1-j;i++){ //����
				if(((Comparable)arr[i]).compareTo(arr[i+1])<0){
					String temp = arr[i];
					arr[i] =arr[i+1];
					arr[i+1] =temp;
					sorted =false; //�ٶ�ʧ��
				}
			}
			if(sorted){ //��������
				break;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
