package in.sp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemo {

	public static void main(String[] args) throws Exception {
		
		String city = "pune";
		String email = "priya@gmail.com";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Shivam@2365");
		PreparedStatement ps = con.prepareStatement("update register set city=? where email=? ");
		ps.setString(1, city);
		ps.setString(2, email);
		int i = ps.executeUpdate();
		if(i> 0 ) {
			System.out.print("success");
		}else {
			System.out.print("false");
		}		
		
	}
}
