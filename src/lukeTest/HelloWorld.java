package lukeTest;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloWorld {

	public static void main(String[] arg) {

		/*System.out.print("hello,what the fuck are you doing");
		System.out.println("nice to meeet you");
		System.out.println("i do not think so!");
*/
		// Demo();
		// AccessDataBase();
		// InsertRecord();
		// InsertMultipleRecords();
		//SelectRecord();
		//UpdateRecord();
		
		String s=Access();
		
		System.out.println(s);
	}
	
	public static String Access() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:postgresql://localhost/exampledb";
		String user = "postgres";
		String password = "root";

		String rel = "";

		String[] rels = new String[10];

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String strSql = "select name from authors;";

			rs = st.executeQuery(strSql);

			int i = 0;
			if (rs.next()) {

				// rel=rs.getString(1);

				//rels[i] = rs.getString(0);
				//i++;
				rel+=rs.getString(1);
				
				//System.out.println(rs.getString(1));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(HelloWorld.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}

		return rel;

	}
	
	

	public static void Demo() {

		File f = new File("", "");

	}

	public static void UpdateRecord() {

		Connection conn = ConnectDatabase.GetConnection();
		Statement st = null;

		try {
			st = conn.createStatement();

			String query = "Update authors set name='nobogy' where id=7";
			st.executeUpdate(query);
			System.out.println("update successfully!");

		} catch (SQLException ex) {

		}

	}

	public static void SelectRecord() {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Connection conn = ConnectDatabase.GetConnection();
			pst = conn.prepareStatement("SELECT * FROM authors");
			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(": ");
				System.out.println(rs.getString(2));
			}

		} catch (SQLException ex) {

		}

	}

	public static void InsertMultipleRecords() {

		Connection conn = ConnectDatabase.GetConnection();
		Statement st = null;

		try {
			st = conn.createStatement();
			for (int i = 1; i <= 1000; i++) {
				String query = "INSERT INTO Testing(Id) VALUES(" + 2 * i + ")";
				st.executeUpdate(query);
			}

		} catch (SQLException ex) {

		}

	}

	public static void InsertRecord() {

		Connection conn = null;
		Statement st = null;
		ResultSet res = null;
		PreparedStatement pst = null;

		String url = "jdbc:postgresql://localhost/exampledb";
		String user = "postgres";
		String password = "root";

		try {

			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();

			int id = 7;
			String author = "lukez alpha";
			String strSql = "insert into authors(id,name) values(?,?)";

			pst = conn.prepareStatement(strSql);
			pst.setInt(1, id);
			pst.setString(2, author);
			pst.executeUpdate();

		} catch (SQLException ex) {

			Logger log = Logger.getLogger(HelloWorld.class.getName());
			log.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(HelloWorld.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}

		}

	}

	public static void AccessDataBase() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:postgresql://localhost/exampledb";
		String user = "postgres";
		String password = "root";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String strSql = "select count(1) from test;";
			strSql = "insert into test values ('100');";
			rs = st.executeQuery(strSql);

			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(HelloWorld.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(HelloWorld.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}

	}
}
