package com.djxc.study.common.DataStructure.sort.col;

public class Worker implements Comparable<Worker> {
	//����
	private String type;
	//����
	private double salary;
	public Worker() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Worker(String type, double salary) {
		super();
		this.type = type;
		this.salary = salary;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * ����������
	 */
	@Override
	public int compareTo(Worker o) {
		return this.salary>o.salary?1:( this.salary==o.salary?0:-1);
	}
	
	@Override
	public String toString() {
		return "����:"+this.type+",����:"+this.salary+"\n";
	}
	
}
