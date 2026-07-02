package in.sp.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Shivam@2365");
		
		PreparedStatement ps = con.prepareStatement("Select * From register");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			System.out.println("Name : "+ name);
			String email = rs.getString("email");
			System.out.println("Email : "+ email);
			String password = rs.getString("password");
			System.out.println("Password : "+ password);
			String gender = rs.getString("gender");
			System.out.println("Gender : "+ gender);
			String city = rs.getString("city");
			System.out.println("City : "+ city);
			System.out.println("--------------------------------");
		}
		
		con.close();
	}
}
