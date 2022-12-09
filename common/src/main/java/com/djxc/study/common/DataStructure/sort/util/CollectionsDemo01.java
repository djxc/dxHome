package com.djxc.study.common.DataStructure.sort.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *1�� binarySearch(List<? extends Comparable<? super T>> list, T key)   ��������
 *2��sort(List<T> list) 
     sort(List<T> list, Comparator<? super T> c) 
 *3��reverse(List<?> list) 
  4��shuffle(List<?> list) ϴ��
  5��swap(List<?> list, int i, int j) 
 * @author Administrator
 *
 */
public class CollectionsDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> cards =new ArrayList<Integer>();
		//shuffle ϴ�� ģ�⶷����
		for(int i=0;i<54;i++){
			cards.add(i); 
		}
		//ϴ��
		Collections.shuffle(cards) ;
		//���η���
		List<Integer> p1 =new ArrayList<Integer>();
		List<Integer> p2 =new ArrayList<Integer>();		
		List<Integer> p3 =new ArrayList<Integer>();
		List<Integer> last =new ArrayList<Integer>();
		for(int i=0;i<51;i+=3){
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));
		}
		//�������Ϊ����
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		
		System.out.println("��һ����:"+p1);
		System.out.println("�ڶ�����:"+p2);
		System.out.println("��������:"+p3);
		System.out.println("����Ϊ:"+last);
		
		
		
		
		
	}
	//��ת
	public static void test1(){
		List<Integer> list =new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("��ת֮��"+list);
	}
}
