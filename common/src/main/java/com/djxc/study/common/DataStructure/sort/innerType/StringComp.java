package com.djxc.study.common.DataStructure.sort.innerType;
/**
 * ��������ҵ����
 * @author Administrator
 *
 */
public class StringComp  implements java.util.Comparator<String>{
	
	/**
	 * �����ȱȽϴ�С 
	 * ���� >
	 * ���� <
	 * 0 ==
	 */
	@Override
	public int compare(String o1, String o2) {
		int len1 =o1.length();
		int len2 =o2.length();		
		return -(len1-len2);
	}
	

}
