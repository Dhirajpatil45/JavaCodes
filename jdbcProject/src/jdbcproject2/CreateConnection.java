package jdbcproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
	
	private static CreateConnection obj = null;
	private static Connection con;
	private CreateConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CreateConnection getInstance() {
		if(obj == null) {
			obj = new CreateConnection();
		}
		return obj;
	}
	
	public Connection getConnection() {
		return con;
	}

}
