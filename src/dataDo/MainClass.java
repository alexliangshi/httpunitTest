package dataDo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import test.DBbase.RandomCreateString;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import dataDo.GenSql;

public class MainClass {
	
	static int q = 0;
	private String driver = null;
	private static String jdbc = null;
	private static String charSet = null;
	private static String url = null;
	private static String user = null;
	private static String passwd = null;
	private static String Tablename= null;
	private static String DBname = null;
	private Connection conn = null;
	Logger lgo;
public MainClass(){
	DataConfig dc = new DataConfig();
	driver = dc.returnDriver();
	jdbc=dc.returnJdbc();
	charSet = dc.returnCharSet();
	url = dc.returnUrl();
	user = dc.returnUser();
	passwd = dc.returnPasswd();
	Tablename= dc.returnTablename();
	DBname = dc.returnDBname();
}
	public void Do(int n) {
		String insertSql = "insert into "+Tablename+" (user_id,username,password) values (";
		String selectSql = "select user_id from "+Tablename+" where user_id=";
		String DBlink = jdbc + DBname + charSet;
		MainClass lmp = new MainClass();
		String t = null;
		String[] a = selectSql.split(" "); // 解析DML标识，是insert还是select
		t = a[0]; // 将解析的DML标识存入临时字符串变量t，暂为实现处理方式
		if (lmp.execCheckDBExsit(DBlink, user, passwd) == true) {
			lmp.createDB(DBlink, user, passwd);
		}
		lmp.roll(DBlink, insertSql, t, n);
	}

	
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

	public Statement createDBlink(String linkSql, String user, String passwd) {
		Statement statement = null;
		this.user = user;
		this.passwd = passwd;
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(linkSql, user, passwd);
			if (!conn.isClosed()) {
//				System.out.println("Succeeded connecting to the Database!");
			}
			statement = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	public void closeLink() throws SQLException {
		this.conn.close();
		// System.out.println("DBlink is closed.");
	}

	public boolean execCheckDBExsit(String DBlinkString, String user,
			String passwd) {
		boolean ret = true;
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(DBlinkString, user, passwd);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
				System.out.println("DataBase " + "[" + DBname + "]"
						+ " exists , no need to create.");
				conn.close();
				ret = false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			if (e.toString().contains("Unknown") == true) {
				System.out.println("Start to create DB ......");
			}
		}
		return ret;
	}

	public void createDB(String DBlinkString, String user, String passwd) {
		Connection conn1 = null;
		final String sql = "CREATE  DATABASE " + DBname;
		// System.out.println("sql is " + sql);
		try {
			String urlo = jdbc + "mysql" + charSet;
			// System.out.println("urlo"+urlo);
			String createtable = "create table mismatch_user ("
					+ "user_id varchar (300) ," + "username varchar (300),"
					+ "password varchar (300))"
					+ "ENGINE= InnoDB CHARACTER SET " + "utf8;";
			conn = DriverManager.getConnection(urlo, user, passwd);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn1 = DriverManager.getConnection(DBlinkString, user, passwd);
			Statement stmt1 = conn1.createStatement();
			stmt1.executeUpdate(createtable);
			stmt.close();
			conn.close();
			stmt1.close();
			conn1.close();
			System.out.println("DB " + "[" + DBname + "]" + " is created.");
			System.out.println("Start to create table >>>>>>>>>>>>>>>>");
			System.out.println("Table " + "[" + "mismatch_user" + "]"
					+ " is created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sql插入语句
	 * 
	 * @param sql
	 */
	public void insert(String DBlinkString, String ExecuteSql) {
		MainClass lmq = new MainClass();
		try {
			Statement smt = lmq.createDBlink(DBlinkString, this.user,
					this.passwd);
			System.out.println("********" + ExecuteSql);
			smt.executeUpdate(ExecuteSql);
			lmq.closeLink();
			System.out.println("insert sucessful!");
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
	public void roll(String DBlinkString, String ii, String t, int n) {
		MainClass cpdb = new MainClass();

		for (int i = 0; i < n; i++) {
			String[] p = { RandomCreateString.getRandomString(10),
					RandomCreateString.getRandomString(10),
					RandomCreateString.getRandomString(10) };
			cpdb.insert(DBlinkString, GenSql.genSqlStament(ii, p));
		}
	}
}
