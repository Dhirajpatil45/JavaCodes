

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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/connectionjava", "root", "root");
		 		
		    PreparedStatement p=con.prepareStatement("CREATE TABLE customer ( \r\n"
		    		+ " \r\n"
		    		+ " ac_no int NOT NULL AUTO_INCREMENT, \r\n"
		    		+ " \r\n"
		    		+ " cname varchar(45) DEFAULT NULL, \r\n"
		    		+ " \r\n"
		    		+ " balance varchar(45) DEFAULT NULL, \r\n"
		    		+ " \r\n"
		    		+ " pass_code int DEFAULT NULL, \r\n"
		    		+ " \r\n"
		    		+ " PRIMARY KEY (`ac_no`), \r\n"
		    		+ " \r\n"
		    		+ " UNIQUE KEY cname_UNIQUE (`cname`) \r\n"
		    		+ " \r\n"
		    		+ ") ;");
		    
			         p.execute();
			 System.out.println("Table is Created..");
		     
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

