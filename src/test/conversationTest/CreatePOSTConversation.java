package test.conversationTest;

import java.io.IOException;

import junit.framework.Assert;

import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CreatePOSTConversation {
	public void setup() {
		WebConversation wc = new WebConversation();
		String[] sp = null;
		try {
			System.out.println("��ʼִ�д����Ự..........");
			WebRequest req = new GetMethodWebRequest(
					"http://10.0.31.46:6080/login/loginAuth.action");//
			System.out.println("���ݻỰ����..........");

			req.setParameter("strUserName", "optadmin");
			req.setParameter("strPassword", "111111");
			req.setParameter("strUserType", "gridview");
			WebResponse resp = wc.getResponse(req);
			System.out.println("��ǰURL��: " + resp.getURL());
			System.out.println("�����б�����: ");
			System.out.println("strUserName: " + "optadmin");
			System.out.println("strPassword: " + "111111");
			System.out.println("strUserType: " + "gridview");
			System.out.println("����:���Ե�½" + "\tִ�в��Խ������: ");
			System.out.println("Ԥ�ڽ��Ϊ��"
					+ "{\"errMsg\":\"success\",\"success\":true}");
			System.out.println("ʵ�ʽ��Ϊ��" + resp.getText() + "\t��½�ɹ���");
			Assert.assertEquals("{\"errMsg\":\"success\",\"success\":true}",
					resp.getText());
			sp = resp.getHeaderField("Set-Cookie").split(";");
			System.out.println("��ȡCookie��ϢΪ:\t" + sp[0]);
			WebRequest req1 = new GetMethodWebRequest(
					"http://10.0.31.46:6080/pageframe/main/queryQuickMenuList.action");//
			req1.setHeaderField("Set-Cookie", sp[0]);
			System.out.println("������һ������......GET(queryQuickMenuList)");
			WebResponse resp1 = wc.getResponse(req1);
			System.out.println(resp1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
