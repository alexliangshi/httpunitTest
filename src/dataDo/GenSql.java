package dataDo;

import org.eclipse.jetty.util.log.Log;

public class GenSql {
public void dbLink(){
	
}
/**
 * ���ݲ������ȣ��Զ����ɷ��ϳ��ȵ�sql��ѯ��䡣
 * 
 * @param sql
 *            sqlǰ׺
 * @param a
 *            �䳤����
 * @return ����������sql���
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
