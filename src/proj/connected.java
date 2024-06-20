package proj;
import java.sql.*;


public class connected {
    public static Connection getcon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","bansal.012345");
			return con;
		}
		catch(Exception ex) {
			return null;
		}
	}
}
