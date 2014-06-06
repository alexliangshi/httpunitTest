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
			System.out.println("开始执行创建会话..........");
			WebRequest req = new GetMethodWebRequest(
					"http://10.0.31.46:6080/login/loginAuth.action");//
			System.out.println("传递会话参数..........");

			req.setParameter("strUserName", "optadmin");
			req.setParameter("strPassword", "111111");
			req.setParameter("strUserType", "gridview");
			WebResponse resp = wc.getResponse(req);
			System.out.println("当前URL是: " + resp.getURL());
			System.out.println("参数列表如下: ");
			System.out.println("strUserName: " + "optadmin");
			System.out.println("strPassword: " + "111111");
			System.out.println("strUserType: " + "gridview");
			System.out.println("用例:测试登陆" + "\t执行测试结果如下: ");
			System.out.println("预期结果为："
					+ "{\"errMsg\":\"success\",\"success\":true}");
			System.out.println("实际结果为：" + resp.getText() + "\t登陆成功！");
			Assert.assertEquals("{\"errMsg\":\"success\",\"success\":true}",
					resp.getText());
			sp = resp.getHeaderField("Set-Cookie").split(";");
			System.out.println("获取Cookie信息为:\t" + sp[0]);
			WebRequest req1 = new GetMethodWebRequest(
					"http://10.0.31.46:6080/pageframe/main/queryQuickMenuList.action");//
			req1.setHeaderField("Set-Cookie", sp[0]);
			System.out.println("进入下一条用例......GET(queryQuickMenuList)");
			WebResponse resp1 = wc.getResponse(req1);
			System.out.println(resp1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
