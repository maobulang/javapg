package lukeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ConnectDatabase {

	public static Connection GetConnection() {

		Connection conn = null;

		String url = "jdbc:postgresql://localhost/exampledb";
		String user = "postgres";
		String password = "root";

		try {

			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {

		}

		return conn;

	}

}
