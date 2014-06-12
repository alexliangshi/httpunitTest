package sr;

import java.lang.Thread.State;
import java.sql.Connection;
//import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class LinkMy {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = null;
	private String user = null;
	private String passwd = null;
	private Connection conn = null;

	/**
	 * 连接数据库
	 * 
	 * @param url
	 *            数据库服务器地址
	 * @param user
	 *            MySQL的用户名
	 * @param passwd
	 *            MySQL的密码
	 * @return
	 */
	public Statement createDBlink(String url, String user, String passwd) {
		Statement statement = null;
		this.url = url;
		this.user = user;
		this.passwd = passwd;
		
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, user, passwd);
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

	public void closeLink() throws SQLException {
		this.conn.close();
		System.out.println("DBlink is closed.");
	}

	public void createDB(String DBlinkString, String DBname, String CharSet,
			String user, String passwd) {
		Connection conn1=null;
		final String sql = "CREATE  DATABASE " + DBname;
		String url = DBlinkString + DBname + CharSet;
		System.out.println("sql is " + sql);
		System.out.println("url is " + url);
		try {

			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, user, passwd);
			if (!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
				System.out.println("DataBase "+"["+DBname+"]"+" exists , no need to create.");
				System.exit(0);
			}
			//
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			if (e.toString().contains("Unknown") == true) {
				System.out.println("Start to Create DB ......");
			}
		}
		try {
			String urlo = DBlinkString + "mysql" + CharSet;
//			System.out.println("urlo"+urlo);
			String createtable = "create table mismatch_user ("
					+ "user_id varchar (300) ," + "username varchar (300),"
					+ "password varchar (300));";
			conn = DriverManager.getConnection(urlo, user, passwd);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn1=DriverManager.getConnection(url, user, passwd);
			Statement stmt1= conn1.createStatement();
			stmt1.executeUpdate(createtable);
			stmt.close();
			conn.close();
			stmt1.close();
			conn1.close();
			System.out.println("DB "+"["+DBname+"]"+" is created.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class CopyOfDBlink {
	static int q = 0;

	/**
	 * 根据参数长度，自动生成符合长度的sql查询语句。
	 * 
	 * @param sql
	 *            sql前缀
	 * @param a
	 *            变长数组
	 * @return 返回完整的sql语句
	 */
	public String genSqlStament(String sql, String[] a) {

		int len = a.length;
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				sql += "\"" + a[i] + "\"";
				continue;
			}
			sql += "," + "\"" + a[i] + "\"";
		}
		sql = sql + ")";
		System.out.println(sql);
		return sql;
	}

	/**
	 * 验证id索引是否唯一
	 * 
	 * @return
	 */
	/**
	 * @param sql
	 *            sql語句
	 * @param t
	 *            參數insert，select，update等等
	 * @param s
	 * @return
	 */
	public boolean checkRepulicate(String sql, String t, String s) {

		boolean hasResultSet = true;
		LinkMy l = new LinkMy();
		ResultSet rs;
		sql = sql + "\"" + s + "\"";

		System.out.println(sql);

		try {
			Statement stmt = l
					.createDBlink(
							"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8",
							"root", "1234");
			hasResultSet = stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			// System.out.println(hasResultSet);
			System.out.println("ResultSet is :" + rs.findColumn("user_id"));
			if (rs != null) {

				while (rs.next()) {
					System.out.println(rs.toString());
					if (rs.toString().contains(s)) {
						hasResultSet = true;
						break;
					} else {
					}
				}
			}
			hasResultSet = false;
			l.closeLink();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasResultSet;
	}

	/**
	 * sql插入语句
	 * 
	 * @param sql
	 */
	public void insert(String sql) {
		LinkMy lmq = new LinkMy();
		try {
			Statement smt = lmq
					.createDBlink(
							"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8",
							"root", "1234");
			String sql1 = sql;
			System.out.println("********" + sql1);
			smt.executeUpdate(sql1);
			lmq.closeLink();
			System.out.println("insert sucessful!");
			lmq.closeLink();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理多条SQL请求
	 * 
	 * @param s
	 *            Sql前缀，如select * from *table....
	 * @param ii
	 *            Sql前缀，如insert * into *table...values ....
	 * @param t
	 *            供判断是那种DML(data manipulation language)，暂不支持
	 * @param n
	 *            要处理的Sql条目数
	 */
	public void roll(String s, String ii, String t, int n) {
		CopyOfDBlink cpdb = new CopyOfDBlink();

		for (int i = 1; i < n; i++) {
			String[] p = { RandomCreateString.getRandomString(10),
					RandomCreateString.getRandomString(10),
					RandomCreateString.getRandomString(10) };
			boolean r = cpdb.checkRepulicate(s, t, p[0]);
			System.out.println(r);
			if (cpdb.checkRepulicate(s, t,
					RandomCreateString.getRandomString(2)) == false) {
				cpdb.insert(cpdb.genSqlStament(ii, p));
			} else {
				continue;
				/*
				 * n = n + 1;
				 */
			}
		}
	}

	public static void main(String[] args) {
		String i ="insert into mismatch_user (user_id,username,password) values (";
		String s = "select user_id from mismatch_user where user_id="; 
		String t = null; 
		String DBname="test";
		String[] a = s.split(" "); 
		LinkMy lmp = new LinkMy();
		lmp.createDB("jdbc:mysql://127.0.0.1:3306/", DBname,
				"?useUnicode=true&characterEncoding=utf8", "root", "1234");
		// demo测试代码
		  CopyOfDBlink cpdb = new CopyOfDBlink(); 
		  t = a[0]; //
		  System.out.println(a[0]);
		  cpdb.roll(s, i, t, 20);

		/*
		 * for (int i = 1; i < 100; i++) { cpdb.insert(
		 * "insert into mismatch_user (user_id,username,password) ",
		 * Integer.toString(i), "test" + i, "test" + i); }
		 */

	}
}
