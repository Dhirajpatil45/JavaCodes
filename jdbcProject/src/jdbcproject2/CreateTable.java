package jdbcproject2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
public static void main(String args[]) throws SQLException {
	CreateConnection c = CreateConnection.getInstance();
	
	Connection con = c.getConnection();
	PreparedStatement p=con.prepareStatement("CREATE TABLE customer5 ( \r\n"
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
    
}
}
