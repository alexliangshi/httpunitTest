package test.conversationTest;

import java.io.IOException;
import org.xml.sax.SAXException;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebClient;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CloudviewCreatePOSTConversation {
	public void setup() {
		WebConversation wc = new WebConversation();
		
		String[] sp = null;
		try {
			System.out.println("��ʼִ�д����Ự..........");
			HttpUnitOptions.setExceptionsThrownOnScriptError(false);
			WebClient ww =wc;
			WebRequest req = new GetMethodWebRequest(
					"http://10.0.33.93:8181/webapps.hostbundle/login");//
			System.out.println("���ݻỰ����..........");
			req.setParameter("password", "123456");
			req.setParameter("username", "sugon1111");
			WebResponse resp = wc.getResponse(req);
			System.out.println("��ǰURL��: " + resp.getURL());
			System.out.println("�����б�����: ");
			System.out.println("username: " + "sugon");
			System.out.println("strPassword: " + "123456");
			System.out.println("����:���Ե�½" + "\tִ�в��Խ������: ");
			System.out.println("Ԥ�ڽ��Ϊ��" + "��  ¼");
			CharSequence aa = "��  ¼";
			// System.out.println(resp.getText());
			if (resp.getText().contains(aa) == true) {
				System.out.println("����ͨ��");
			} else {
				System.out.println("����ʧ��");
			}
			String s[] = resp.getHeaderFields("Set-Cookie");
			for (int i = 0; i < s.length; i++) {
				System.out.println(s[i] + "   ");
			}
			sp = resp.getHeaderField("Set-Cookie").split(";");
			System.out.println("��ȡCookie��ϢΪ:\t" + sp[0]);
			WebRequest req1 = new GetMethodWebRequest(
					"http://10.0.33.93:8181/webapps.hostbundle/host/template/toHostTemplatePage");//
			WebResponse resp1 = wc.getResponse(req1);
			ww.addCookie("Set-Cookie", sp[0]);
			System.out.println(resp1.getText());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} 
	}
}
