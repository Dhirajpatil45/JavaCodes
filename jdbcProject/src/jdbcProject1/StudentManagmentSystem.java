package jdbcProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManagmentSystem {
	 static Connection con=null;

	public static void main(String[] args) {
		
		String str="";
		try {
			String name,address,email,course,mob_no;
			int fee;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "root");
			Scanner sc= new Scanner(System.in);
			System.out.println("...........Welcome to Itpreneur...........");
			System.out.println("Select Option : ");
			System.out.println("1.New Student login");
			System.out.println("2.Admin login");
			System.out.println("Enter your choice : ");
			int choice= sc.nextInt();
			if(choice==1||choice==2) {
			switch(choice) {
			case 1:
					String query="insert into student values(?,?,?,?,?,?)";
					PreparedStatement stmt= con.prepareStatement(query);
					System.out.println("Enter Your Name: ");
					name=sc.next();
					System.out.println("Enter Your Mobile number: ");
					mob_no=sc.next();
					System.out.println("Enter Your Address: ");
					address=sc.next();
					System.out.println("Enter Your email: ");
					email=sc.next();									
//					System.out.println("Enter Your Course from below : ");
//					System.out.println("1.Java \t\t\t2.Python\n3.DotNetDeveloer\t4.Power_BI\n5.BA\t\t\t6.Salesforce");
					System.out.println("Select the course that you want to apply : ");
					course=sc.next();					
					System.out.println("Enter Your fee: ");
					fee=sc.nextInt();	
					
					stmt.setString(1,name);
					stmt.setString(2,mob_no);
					stmt.setString(3,address);
					stmt.setString(4,email);
					stmt.setString(5,course);
					stmt.setInt(6,fee);	
					
					
					stmt.executeUpdate();
					System.out.println("Record updated successfully......");
					break;
				
			case 2:
				do {
					System.out.println("1.Show all the records of students");
					System.out.println("2.Update student information");
					System.out.println("3.Remove Students from database");
					System.out.println("4.Arrange the records of Students");
					System.out.println("5.Students with pending fees");
					System.out.println("Enter your choice");
					choice=sc.nextInt();
					
					
					
					System.out.println("Do You Want to add More Records:(YES/NO):");
					str = sc.next().toUpperCase();
					}while(str.equals("YES"));
							break;
			}
		}
			else {
				System.out.println("please enter valid choice");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
