package jdbc1;
import java.util.*;
import java.sql.*;
public class A2 {
	Scanner sc=new Scanner(System.in);
	void fun() {
		System.out.println("HOSTEL RESERVATION SYSTEM");
		System.out.println("1.reserve a room");
		System.out.println("2.view reservation");
		System.out.println("3.get room_num");
		System.out.println("4.update reservations");
		System.out.println("5.delete reservations");
		System.out.println("0.Exit");
		
		}
	    public static void main(String[]args)throws SQLException, ClassNotFoundException, InterruptedException{
		Scanner sc=new Scanner(System.in);
		A2 a=new A2();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/hari";
		String pass="root";
		String user="root";
		Connection c= DriverManager.getConnection(url,user,pass);
		String e="insert into hotel(reservation_id, holder_name, room_num, contact_num)  values(?,?,?,?)";
		String i="select * from hotel";
		String h="select * from hotel where holder_name=? and reservation_id=?";
		String del="delete from hotel where holder_name =?";
		String sq="update hotel set holder_name=?,room_num=?,contact_num=? where  reservation_id=?";
		PreparedStatement s=c.prepareStatement(e);
		PreparedStatement n=c.prepareStatement(i);
		PreparedStatement j=c.prepareStatement(h);
		PreparedStatement k=c.prepareStatement(del);
		PreparedStatement ad=c.prepareStatement(sq);
		do {
		a.fun();
		System.out.println("enter your choice");
		int w=sc.nextInt();
	    switch(w) {
		case 1:
			System.out.println("enter reservation id:");
			int r=sc.nextInt();
		    s.setInt(1, r);
		    System.out.println("enter holder name:");
		    String t=sc.next();
		    s.setString(2, t);
		    System.out.println("enter room number:");
		    int y=sc.nextInt();
		    s.setInt(3, y);
		    System.out.println("enter contact number:");
		    int u=sc.nextInt();
		    s.setInt(4,u);
		    s.executeUpdate();
		break;
		case 2:
			ResultSet o=n.executeQuery();
			while(o.next()) {
				
			System.out.println("-------------------");
			System.out.println("|"+ o.getString(1)+"|"+o.getString(2)+"|"+o.getString(3)+"|"+o.getString(4)+"|");
			System.out.println("-------------------");}
			break;
			case 3:
				System.out.println("enter name:");
				String d=sc.next();
				j.setString(1, d);
				System.out.println("enter reservation id:");
				int g=sc.nextInt();
				j.setInt(2,g);
				ResultSet b=j.executeQuery();
				while(b.next()) {
		   	System.out.println("----");
			System.out.println("|"+ b.getString(3)+"|");
			System.out.println("----");
				}
				break;
			case 5:
				System.out.println("enter name :");
				String er=sc.next();
				k.setString(1,er);
				k.executeUpdate();
				System.out.println("........DELETED.......");
				break;
			case 4:
				System.out.println("enter reservation id:");
				 String rt=sc.next();
				ad.setString(4,rt);
				System.out.println("enter name:");
				String yu=sc.next();
				ad.setString(1, yu);
				System.out.println("enter room num:");
				String i1=sc.next();
				ad.setString(2,i1);
				System.out.println("enter contact:");
				String i2=sc.next();
				ad.setString(3,i2);
				ad.executeUpdate();
				break;
			case 0:
				int fd=6;
				System.out.print("THANK YOU");
				while(fd!=0) {
					System.out.print(".");
					Thread.sleep(235);
					fd--;
				}
			
				return;
				}}while(true);
			
		}
		
		

	}