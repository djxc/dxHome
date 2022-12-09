package com.djxc.study.common.DataStructure.sort.col;

import java.util.TreeSet;

/**
 * �ṩ�� ����ķ�ʽ:ҵ��������
 * @author Administrator
 *
 */
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 =new Person("��",100);
		Person p2 =new Person("���»�",1000);
		Person p3 =new Person("����ΰ",1200);
		Person p4 =new Person("����",50);
		
		//���δ�ŵ�TreeSet������,ʹ�������ҵ����(�����ڲ���)
		TreeSet<Person> persons =new TreeSet<Person>(
					new java.util.Comparator<Person>(){

						@Override
						public int compare(Person o1, Person o2) {
							return -(o1.getHandsome()-o2.getHandsome());
						}
						
					}
				);
		persons.add(p1);
		//TreeSet ���������ʱ����
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		System.out.println(persons);
		
		/*
		//�ı�����
		p4.setHandsome(100);
		p4.setName("��");
		*/ 
		//p4 ��p1 �����ظ� 
		System.out.println(persons);
		
	}

}
