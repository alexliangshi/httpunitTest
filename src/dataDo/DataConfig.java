package dataDo;

import java.sql.Connection;

public class DataConfig {
	protected String driver = "com.mysql.jdbc.Driver";
	protected String jdbc = "jdbc:mysql://127.0.0.1:3306/";
	protected String DML[] = { "insert", "select", "update", "delete" };
	protected String charSet="?useUnicode=true&characterEncoding=utf8";
	protected String url = null;
	protected String user = "root";
	protected String passwd = "1234";
	protected Connection conn = null;

	public String returnDriver() {
		return this.driver;
	}

	public String returnJdbc() {
		return this.jdbc;
	}

	public String returnDml(int i) {
		return this.DML[i];
	}
	public String returnCharSet(){
		return this.charSet;
	}
	public String returnUrl(){
		return this.url;
	}
	public String returnUser(){
		return this.user;
	}
	public String returnPasswd(){
		return this.passwd;
	}
}
