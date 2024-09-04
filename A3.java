package jdbc1;
import java.sql.*;
import java.util.*;

  public class A3 {
	static void mahi() {
		System.out.println("");
		System.out.println("EMP MANGEMENT SYSTEM");
		System.out.println("1. empolyee details  regestration");
		System.out.println("2.view details");
		System.out.println("3.get salary");
		System.out.println("4.update details");
		System.out.println("5.check salary status");
		System.out.println("6.delete");
		System.out.println("7.change salary status");
		System.out.println("8.Exit");
	}
   public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/hari";
		String pass="harish";
		String user="root";
		Connection c=DriverManager.getConnection(url,user,pass);
		while(true){
			mahi();
			System.out.println("enter the choice :");
		int a=sc.nextInt();
		switch(a) {
		case 1://working
		String d="insert into emp(emp_id, emp_name, dept, salary) values(?,?,?,?)";
		PreparedStatement s=c.prepareStatement(d);
		System.out.println("enter empolyee id");
		int b=sc.nextInt();
	    s.setInt(1,b);
		System.out.println("enter empolyee name");
		String b1=sc.next();
		s.setString(2, b1);
		System.out.println("enter empolyee dept");
		String b2=sc.next();
		s.setString(3, b2);
		System.out.println("enter empolyee salary");
		int b3=sc.nextInt();
		s.setInt(4,b3);
		s.executeUpdate();
		System.out.print("Inserted");
		int y4=5; 
		while(y4!=0){			
		   System.out.print(".");
		Thread.sleep(200);
		y4--;
		}
		break;
		case 2://working
		String d1="select * from emp";
		PreparedStatement s1=c.prepareStatement(d1);
		ResultSet r=s1.executeQuery();
		while(r.next()) {
			System.out.println("--------------------------------------------------------");
			System.out.println("|"+r.getString(1)+"|"+r.getString(2)+"|"+r.getString(3)+"|"+r.getString(4)+"|"+r.getString(5)+"|"+r.getString(6)+"|");
			System.out.println("--------------------------------------------------------");
		}
		break;
		case 3://working
			String d2="select salary from emp where emp_id=? and emp_name=?";
			PreparedStatement s2=c.prepareStatement(d2);
			System.out.println("enter the employee ID");
			int c1=sc.nextInt();
			s2.setInt(1, c1);
			System.out.println("enter the employee NAME");
			String c2=sc.next();
			s2.setString(2, c2);
			ResultSet r1=s2.executeQuery();
			while(r1.next()) {
				System.out.println("-------");
				System.out.println("|"+r1.getString(1)+"|");
				System.out.println("-------");}
				break;
				case 4: 
					System.out.println("enter the employee ID");
					int e1=sc.nextInt();
					System.out.println("what do you want to update?");
					System.out.println("1.empolyee ID");
					System.out.println("2.employee NAME");
					System.out.println("3.dept");
					System.out.println("4.salary");
					System.out.println("enter the choice:");
					int e=sc.nextInt();
		          	switch(e){
					case 1:
						String d3="update emp set emp_id=? where emp_id=?";
						PreparedStatement w1=c.prepareStatement(d3);
						System.out.println("enter new employee id");
						int c4=sc.nextInt();
						w1.setInt(1, c4);
						w1.setInt(2, e1);
						w1.executeUpdate();					
						break;
					case 2:
						String d4="update emp set emp_name=? where emp_id=?";
						PreparedStatement w2=c.prepareStatement(d4);
						System.out.println("enter new employee name");
						String c6=sc.next();
						w2.setString(1, c6);
						w2.setInt(2, e1);
						w2.executeUpdate();	
					break;
					case 3:
						String d5="update emp set dept=? where emp_id=?";
						PreparedStatement w3=c.prepareStatement(d5);
						System.out.println("enter new dept name");
						String c8=sc.next();
						w3.setString(1, c8);
						w3.setInt(2, e1);
						w3.executeUpdate();	
						break;
					case 4:
						String d6="update emp set salary=? where emp_id=?";
						PreparedStatement w4=c.prepareStatement(d6);
						System.out.println("enter new salary");
						int c9=sc.nextInt();
						w4.setInt(1, c9);
						w4.setInt(2, e1);
						w4.executeUpdate();
					    break;
					    }
		          	break;
				case 5://working
					String d7="select checked from emp where emp_id=?";
					PreparedStatement s5=c.prepareStatement(d7);
					System.out.println(" enter the employee ID");
					int g=sc.nextInt();
					s5.setInt(1,g);
					ResultSet r3=s5.executeQuery();
					while(r3.next()){
						System.out.println("-------------------");
						System.out.println("|"+r3.getString("checked")+"|");
						System.out.println("-------------------");
					  }
					break;
				case 6://working
					String d8="delete from emp where emp_id=?;";
					PreparedStatement s6=c.prepareStatement(d8);
					System.out.println("enter the employee id to DELETE");
					int g1=sc.nextInt();
					s6.setInt(1,g1);
					s6.executeUpdate();	
					System.out.print("Deleted");
					int y2=5; 
					while(y2!=0){			
					   System.out.print(".");
					Thread.sleep(200);
					y2--;
					}
					break;
				case 7://working
					String d9="update emp set checked =?,reg_date=now() where emp_id=? and emp_name=?";
					PreparedStatement s7=c.prepareStatement(d9);
					System.out.println("enter the employee id");
					int g2=sc.nextInt();
					s7.setInt(2,g2);
				    System.out.println("enter the employee name");
				    String g3=sc.next();
				    s7.setString(3,g3);
				    System.out.println("enter the salary status");
				    String g4=sc.next();
				    s7.setString(1, g4);
				    s7.executeUpdate();
				    System.out.print("updated");
				    int y1=5; 
					while(y1!=0){			
					   System.out.print(".");
					Thread.sleep(200);
					y1--;
					}
				    break;
				case 8://working
					System.out.print("EXISTING");	
					int y=5; 
					while(y!=0){			
					   System.out.print(".");
					Thread.sleep(200);
					y--;
					}
					return;
		
		}
		}}
		
	}



