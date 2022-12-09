package com.djxc.study.web.LearnSpring;

import java.sql.*;

public class connectPG {
	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDB", "dj", "123dj321");
			System.out.println("Opened database successfully");
			 c.setAutoCommit(false);	//�����ֶ��ύ
			stmt = c.createStatement();
//			createTable(stmt);
//			insertTable(stmt);
			selectTable(stmt);
			
			c.commit();
			c.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
	
	
	//��������
	private static void createTable(Statement stmt) {
		String sql = "CREATE TABLE COMPANY (ID INT PRIMARY KEY  NOT NULL,"
				+ " NAME  TEXT    NOT NULL, AGE  INT     NOT NULL, "
				+ " ADDRESS CHAR(50), SALARY  REAL)";
		try {
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("�����ɹ���");
		} catch (SQLException e) {
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e1) {
					
				}
			}
		}
	}
	
	//�������
	private static void insertTable(Statement stmt){
		
         String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
               + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
         try {
			stmt.executeUpdate(sql);
			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
		               + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
	         stmt.executeUpdate(sql);
	
	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
	               + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
	         stmt.executeUpdate(sql);
	
	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
	               + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
	         stmt.executeUpdate(sql);
	
	         stmt.close();
	         System.out.println("�������ݳɹ���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//���ѯ����
	private static void selectTable(Statement stmt){
		 ResultSet rs=null;
		try {
			rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
			while ( rs.next() ) {
	            int id = rs.getInt("id");
	            String  name = rs.getString("name");
	            int age  = rs.getInt("age");
	            String  address = rs.getString("address");
	            float salary = rs.getFloat("salary");
	            System.out.println( "ID = " + id + ";NAME = " + name
	            		+ ";AGE = " + age+";ADDRESS = " + address.trim()+";SALARY = " + salary );
	         }
	         rs.close();
	         stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
}
