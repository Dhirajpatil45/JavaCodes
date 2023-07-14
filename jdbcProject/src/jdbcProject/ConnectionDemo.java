package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//loading the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "root");
		System.out.println("Connected : "+con);
		
		String readAllBooks="select * from book";
		Statement stmt= con.createStatement();
		ResultSet resultSet=stmt.executeQuery(readAllBooks);
		while(resultSet.next()) {
			int id=resultSet.getInt(1);
			String name=resultSet.getString(2);
			String author=resultSet.getNString(3);
			int price=resultSet.getInt(4);
			
			System.out.println(id+","+name+","+author+","+price );
		}
		con.close();
	}

}

