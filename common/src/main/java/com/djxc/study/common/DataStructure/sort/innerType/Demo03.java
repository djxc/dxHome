package com.djxc.study.common.DataStructure.sort.innerType;

import java.util.Arrays;
import java.util.Date;

public class Demo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date[] arr =new Date[3];
		arr[0] =new Date();
		arr[1] =new Date(System.currentTimeMillis()-1000*60*60);
		arr[2] =new Date(System.currentTimeMillis()+1000*60*60);
		//����
		
		//�Ӵ�С���� ����
			boolean sorted= true;
			int len =arr.length;
			for(int j=0;j<len-1;j++){ //����
				sorted =true; //�ٶ�����
				for(int i=0;i<len-1-j;i++){ //����
					if(((Comparable)arr[i]).compareTo(arr[i+1])<0){
						Date temp = arr[i];
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
