package test.DBbase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class LinkMysql extends DBlink {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/faqdb?useUnicode=true&characterEncoding=utf8";
	private String user = "root";
	private String passwd = "1234";

	public Statement createlink(String url, String user, String passwd) {
		Statement statement = null;
		url = this.url;
		user = this.user;
		passwd = this.passwd;
		try {
			Class.forName(this.driver);
			Connection conn = DriverManager.getConnection(url, user, passwd);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			statement = conn.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;

	}
}

public class DBlink {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/faqdb?useUnicode=true&characterEncoding=utf8";
	private String user = "root";
	private String passwd = "1234";

	// private String sql = null;
	static int q = 0;

	public void insert(String[] aa) {

		try {
			q = q + 1;
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, passwd);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement = conn.createStatement();
			String sql1 = "insert into faq (id,product,question,answer,subsystem,source,owner,committime) "
					+ "values (" + "\""
					+ Integer.toString(q)
					+ "\","
					+ "\""
					+ aa[1]
					+ "\""
					+ ","
					+ "\""
					+ aa[3]
					+ "\","
					+ "\""
					+ aa[4]
					+ "\""
					+ ","
					+ "\""
					+ aa[5]
					+ "\","
					+ "\""
					+ aa[6]
					+ "\","
					+ "\""
					+ aa[7]
					+ "\"," + "\"" + aa[8] + "\");";

			System.out.println("********" + sql1);
			statement.executeUpdate(sql1);
			conn.close();

			System.out.println("insert sucessful!");
		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
