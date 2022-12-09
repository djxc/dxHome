package com.djxc.study.common.DataStructure.sort.refType;
/**
 * ���ղ��������ҵ���� ������
 * @author Administrator
 *
 */
public class GoodsFavComp implements java.util.Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		return o1.getFav()-o2.getFav();
	}

}
