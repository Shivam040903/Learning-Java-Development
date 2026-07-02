package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Shivam@2365");
//		PreparedStatement  ps =  con.prepareStatement("insert into register values('shivam', 'skv040903@gmail.com', 'abc@123', 'male', 'noida')");
		PreparedStatement  ps =  con.prepareStatement("insert into register values(?,?,?,?,?)");
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, gender);
		ps.setString(5, city);

		int i = ps.executeUpdate();
		if(i> 0 ) {
			System.out.print("success");
		}else {
			System.out.print("false");
		}
		}
}
