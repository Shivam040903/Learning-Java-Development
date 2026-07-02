package in.sp.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {

	public static void main( String[] args) throws Exception {
		String email = "priya@gmail.com";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "Shivam@2365");
		PreparedStatement ps = con.prepareStatement("delete from register where email=?");
		ps.setString(1, email);
		int i = ps.executeUpdate();
	}
}
