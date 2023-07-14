package jdbcProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class CreateTable {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "root");
		 		
		    PreparedStatement p=con.prepareStatement("create table student(name varchar(40),mob_no varchar(20),address varchar(30),email varchar(30),course varchar(30),fee int )");
		    
			         p.execute();
			 System.out.println("Table is Created..");
		     
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

