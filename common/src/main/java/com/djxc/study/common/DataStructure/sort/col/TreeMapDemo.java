package com.djxc.study.common.DataStructure.sort.col;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 =new Person("��",100);
		Person p2 =new Person("���»�",1000);
		Person p3 =new Person("����ΰ",1200);
		Person p4 =new Person("����",50);
		
		TreeMap<Person,String> map =new TreeMap<Person,String>(new java.util.Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				return -(o1.getHandsome()-o2.getHandsome());
			}
			
		} );
		map.put(p1, "bjsxt");
		map.put(p2, "bjsxt");
		map.put(p3, "bjsxt");
		map.put(p4, "bjsxt");
		
		//�鿴��
		Set<Person> persons =map.keySet();
		System.out.println(persons);
	}

}
