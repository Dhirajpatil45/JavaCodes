package jdbcProject;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class employeeApplication {
	public static void main(String[] args) throws IOException {
		Connection con = null;
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "root");
			
		    Scanner sc = new Scanner(System.in);
		
		    System.out.println("1 : Add new Record");
		    System.out.println("2 : Select all records from employee table");
		    System.out.println("3 : Update Specific Record");
		    System.out.println("4 : Delete Specific Record");
		    System.out.println("5 : Select Record which sal >= 10000");
		    System.out.println("6 : Sort Record in Ascending order");
		    
		    String mainString = "";
		    do {
		    	 System.out.print("Enter Your Choice:");
				    int choice = sc.nextInt();
				    
				    switch(choice) {
					case 1 :
						System.out.println();
						String str="";
						String s1,s2;
						int i1,i2,i3;
						do {
							PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?,?)");
							
							System.out.print("Enter Employee Number:");
							i1 = sc.nextInt();
							  
							System.out.print("Enter Employee Name:");
							s1 = sc.next();
							
							System.out.print("Enter Employee Salary:");
							i2 = sc.nextInt();
							
							System.out.print("Enter Employee Dapart Number:");
							i3 = sc.nextInt();
							
							System.out.print("Enter Job Name:");
							s2 = sc.next();
							
							pst.setInt(1, i1);
							pst.setString(2,s1);
							pst.setInt(3,i2);
							pst.setInt(4,i3);
							pst.setString(5,s2);
							
							int result = pst.executeUpdate();
							System.out.println(result+" Record Added");
							
							System.out.println("Do You Want to add More Records:(YES/NO):");
							str = sc.next().toUpperCase();
						}while(str.equals("YES"));
						break;
					case 2 :
						System.out.println();
						Statement stmt = con.createStatement();
						ResultSet rst = stmt.executeQuery("select * from employee");
						
						while(rst.next()) {
							System.out.println(rst.getInt(1)+"\t"+rst.getString(2)+"\t"+rst.getInt(3)+"\t"+rst.getInt(4)+"\t"+rst.getString(5));
						}
						break;
					case 3 :
						System.out.println();
						
						System.out.println("1 : Update Employee Number\t\t6 : Update Employee Number and Employee Name");
						System.out.println("2 : Update Employee Name\t\t7 : Update Employee Name and salary");
						System.out.println("3 : Update Employee salary\t\t8 : Update Employee salary and Dipartment number");
						System.out.println("4 : Update Department Number\t\t9 : Update Department Number and job");
						System.out.println("5 : Update Employee Job:\t\t10 : Update Employee job and Name");
						System.out.println("11 : Update Employee job and salary\t12 :Update Employee number and salary");
						System.out.println("13 :Update Employee number,name,salary,department number and job");
						System.out.println();
						String stringChoice="";
						do {
							System.out.print("Enter Your Choice:");
							int choice1 = sc.nextInt();
				
							switch(choice1) {
							case 1:
								System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber = sc.nextInt();
								

								System.out.print("Enter Employee New Number for Update:");
								int newNumber = sc.nextInt();
								
								PreparedStatement p1 = con.prepareStatement("update employee set empno=? where empno=?");
								
								p1.setInt(1,newNumber);
								p1.setInt(2,empnumber);
								
								int result1 = p1.executeUpdate();
								System.out.println(result1+" Updated");
								break;
							case 2:
			                    System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber1 = sc.nextInt();
								

								System.out.print("Enter Employee Name for Update:");
								String newNumber1 = sc.next();
								
								PreparedStatement p2 = con.prepareStatement("update employee set empname=? where empno=?");
								
								p2.setString(1,newNumber1);
								p2.setInt(2,empnumber1);
								
								int result2 = p2.executeUpdate();
								System.out.println(result2+" Updated");
								break;
							case 3:
			                    System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber2 = sc.nextInt();
								

								System.out.print("Enter Employee salary for Update:");
								int newNumber2 = sc.nextInt();
								
								PreparedStatement p3 = con.prepareStatement("update employee set sal=? where empno=?");
								
								p3.setInt(1,newNumber2);
								p3.setInt(2,empnumber2);
								
								int result3 = p3.executeUpdate();
								System.out.println(result3+" Updated");
								break;
							case 4:
			                    System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber3 = sc.nextInt();
								

								System.out.print("Enter Employee Dapartment Number for Update:");
								int newNumber3 = sc.nextInt();
								
								PreparedStatement p4 = con.prepareStatement("update employee set deptno=? where empno=?");
								
								p4.setInt(1,newNumber3);
								p4.setInt(2,empnumber3);
								
								int result4 = p4.executeUpdate();
								System.out.println(result4+" Updated");
								break;
							case 5:
			                    System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber4 = sc.nextInt();
								

								System.out.print("Enter Employee Job Name for Update:");
								String newNumber4 = sc.next();
								
								PreparedStatement p5 = con.prepareStatement("update employee set job=? where empno=?");
								
								p5.setString(1,newNumber4);
								p5.setInt(2,empnumber4);
								
								int result5 = p5.executeUpdate();
								System.out.println(result5+" Updated");
								break;
							case 6:
								    System.out.println();
									
									System.out.print("Enter Employee Number for Update:");
									int empnumber5 = sc.nextInt();
									
									System.out.print("Enter Employee new Number for Update:");
									int n1 = sc.nextInt();
									
									System.out.print("Enter Employee Name for Update:");
									String newNumber5 = sc.next();
									
									PreparedStatement p6 = con.prepareStatement("update employee set empno=?,empname=? where empno=?");
									
									p6.setInt(1,n1);
									p6.setString(2,newNumber5);
									p6.setInt(3,empnumber5);
									
									int result6 = p6.executeUpdate();
									System.out.println(result6+" Updated");
								break;
							case 7:
								System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber6 = sc.nextInt();
								
								System.out.print("Enter Employee Name for Update:");
								String n2 = sc.next();
								
								System.out.print("Enter Employee Salary for Update:");
								int newNumber6 = sc.nextInt();
								
								PreparedStatement p7 = con.prepareStatement("update employee set empname=?,sal=? where empno=?");
								
								p7.setString(1,n2);
								p7.setInt(2, newNumber6);
								p7.setInt(3,empnumber6);
								
								int result7 = p7.executeUpdate();
								System.out.println(result7+" Updated");
								break;
							case 8:
								System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber7 = sc.nextInt();
								
								System.out.print("Enter Employee salary for Update:");
								int n3 = sc.nextInt();
								
								System.out.print("Enter Employee Department number for Update:");
								int newNumber7 = sc.nextInt();
								
								PreparedStatement p8 = con.prepareStatement("update employee set sal=?,deptno=? where empno=?");
								
								p8.setInt(1, n3);
								p8.setInt(2, newNumber7);
								p8.setInt(3,empnumber7);
								
								int result8 = p8.executeUpdate();
								System.out.println(result8+" Updated");
								break;
							case 9:
			                    System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber8 = sc.nextInt();
								
								System.out.print("Enter Employee Dapartment Number for Update:");
								int n4 = sc.nextInt();
								
								System.out.print("Enter Employee Job name for Update:");
								String newNumber8 = sc.next();
								
								PreparedStatement p9 = con.prepareStatement("update employee set deptno=?,job=? where empno=?");
								
								p9.setInt(1, n4);
								p9.setString(2, newNumber8);
								p9.setInt(3,empnumber8);
								
								int result9 = p9.executeUpdate();
								System.out.println(result9+" Updated");
								break;
							case 10:
								System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber9 = sc.nextInt();
								
								System.out.print("Enter Employee job Name for Update:");
								String n5 = sc.next();
								
								System.out.print("Enter Employee new Name for Update:");
								String newNumber9 = sc.next();
								
								PreparedStatement p10 = con.prepareStatement("update employee set job=?,empname=? where empno=?");
								
								p10.setString(1, n5);
								p10.setString(2, newNumber9);
								p10.setInt(3,empnumber9);
								
								int result10 = p10.executeUpdate();
								System.out.println(result10+" Updated");
								break;
							case 11:
								System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber10 = sc.nextInt();
								
								System.out.print("Enter Employee job Name for Update:");
								String n6 = sc.next();
								
								System.out.print("Enter Employee salary for Update:");
								int newNumber10 = sc.nextInt();
								
								PreparedStatement p11 = con.prepareStatement("update employee set job=?,sal=? where empno=?");
								
								p11.setString(1, n6);
								p11.setInt(2, newNumber10);
								p11.setInt(3,empnumber10);
								
								int result11 = p11.executeUpdate();
								System.out.println(result11+" Updated");
								break;
							case 12:
								System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber11 = sc.nextInt();
								
								System.out.print("Enter Employee new Number for Update:");
								int n7 = sc.nextInt();
								
								System.out.print("Enter Employee salary for Update:");
								int newNumber11 = sc.nextInt();
								
								PreparedStatement p12 = con.prepareStatement("update employee set job=?,sal=? where empno=?");
								
								p12.setInt(1, n7);
								p12.setInt(2, newNumber11);
								p12.setInt(3,empnumber11);
								
								int result12 = p12.executeUpdate();
								System.out.println(result12+" Updated");
								break;
							case 13 :
			                    System.out.println();
								
								System.out.print("Enter Employee Number for Update:");
								int empnumber12 = sc.nextInt();
								
								System.out.print("Enter Employee new Number for Update:");
								int n8 = sc.nextInt();
								
								System.out.print("Enter Employee name for Update:");
								String nst = sc.next();
								
								System.out.print("Enter Employee salary for Update:");
								int newNumber12 = sc.nextInt();
								
								System.out.print("Enter Employee Dapartment Number for Update:");
								int dptnumber = sc.nextInt();
								
								System.out.print("Enter Employee job Name for Update:");
								String jobName = sc.next();
								
								PreparedStatement p13 = con.prepareStatement("update employee set empno=?,empname=?,sal=?,deptno=?,job=? where empno=?");
								
								p13.setInt(1, n8);
								p13.setString(2, nst);
								p13.setInt(3,newNumber12);
								p13.setInt(4, dptnumber);
								p13.setString(5, jobName);
								p13.setInt(6, empnumber12);
								
								int result13 = p13.executeUpdate();
								System.out.println(result13+" Updated");
								break;
								default:
									System.out.println("Invalid Choice!");
							}
							System.out.print("If You Want to Insert More Records:Yes/NO: ");
							stringChoice = sc.next().toUpperCase();
						}while(stringChoice.equals("YES"));
						break;
					case 4 :
						String moreDelete="";
						do {
							System.out.println();
							
							System.out.print("Enter Employee Number for Delete Record:");
							int deleteRecord = sc.nextInt();
							
							PreparedStatement delete1 = con.prepareStatement("delete from employee where empno=?");
							
							delete1.setInt(1, deleteRecord);
							
							int deleteResult = delete1.executeUpdate();
							System.out.println(deleteResult+" Delete Record.");
							System.out.println();
							System.out.print("If You Want to delete More Records:YES/NO:");
							moreDelete = sc.next().toUpperCase();
						}while(moreDelete.equals("YES"));				
						break;
					case 5 :
						System.out.println();
						
						Statement conditionQuery = con.createStatement();
						
						ResultSet conditionResult = conditionQuery.executeQuery("select*from employee where sal >= 10000");
						
						while(conditionResult.next()) {
							int resultNumber = conditionResult.getInt(1);
							String resultName = conditionResult.getString(2);
							int resultSalary = conditionResult.getInt(3);
							int resultDepartment = conditionResult.getInt(4);
							String resultjob = conditionResult.getString(5);
							
							System.out.println(resultNumber+"\t"+resultName+"\t"+resultSalary+"\t"+resultDepartment+"\t"+resultjob);
							
						}
						
						break;
					case 6 :
						System.out.println();
						Statement sortStatement = con.createStatement();
						
						ResultSet setrResult = sortStatement.executeQuery("select * from employee order by empno");
						
						while(setrResult.next()) {
							System.out.println(setrResult.getInt(1)+"\t"+setrResult.getString(2)+"\t"+setrResult.getInt(3)+"\t"+setrResult.getInt(4)+"\t"+setrResult.getString(5));
						}
						break;
						default:
							System.out.println("Invalid Choice!");
					}
				    System.out.println();
		    System.out.println("If You Want To Perform More Operations:YES/NO: ");
		    mainString = sc.next().toUpperCase();
		    }while(mainString.equals("YES"));
		}
		catch(ClassNotFoundException e) {
			
		}
		catch(SQLException e) {
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

