package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	// add static method to get FIXED DB connection from D.M
	public static Connection fetchDBConnection() throws ClassNotFoundException, SQLException {
		return cn;
	}

	public static void createSingletonConnection(String drvr, String url, String userName, String pass)
			throws Exception {
		Class.forName(drvr);
		// cn
		cn = DriverManager.getConnection(url, userName, pass);
		System.out.println("created singleton DB connection");
	}

	public static void cleanUp() throws SQLException {
		if (cn != null)
			cn.close();
		System.out.println("cleaned up DB connection");
	}

}
