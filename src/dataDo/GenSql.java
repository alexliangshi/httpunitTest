package dataDo;

import org.eclipse.jetty.util.log.Log;

public class GenSql {
public void dbLink(){
	
}
/**
 * 根据参数长度，自动生成符合长度的sql查询语句。
 * 
 * @param sql
 *            sql前缀
 * @param a
 *            变长数组
 * @return 返回完整的sql语句
 */
public static String genSqlStament(String sql, String[] a) {

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

}
