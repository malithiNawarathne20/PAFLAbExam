package com.example.db;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection createConnection()
	{
		
		Connection con=null;
		String url="jdbc:mysql://loalhost:3306/studentdb";
		String username="root";
		String password="root";
		
		
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			con=DriverManager.getConnection(url,username,password);
			System.out.print("printing connection object"+con);
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}		
		
	}


