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
			System.out.println("开始执行创建会话..........");
			HttpUnitOptions.setExceptionsThrownOnScriptError(false);
			WebClient ww =wc;
			WebRequest req = new GetMethodWebRequest(
					"http://10.0.33.93:8181/webapps.hostbundle/login");//
			System.out.println("传递会话参数..........");
			req.setParameter("password", "123456");
			req.setParameter("username", "sugon1111");
			WebResponse resp = wc.getResponse(req);
			System.out.println("当前URL是: " + resp.getURL());
			System.out.println("参数列表如下: ");
			System.out.println("username: " + "sugon");
			System.out.println("strPassword: " + "123456");
			System.out.println("用例:测试登陆" + "\t执行测试结果如下: ");
			System.out.println("预期结果为：" + "登  录");
			CharSequence aa = "登  录";
			// System.out.println(resp.getText());
			if (resp.getText().contains(aa) == true) {
				System.out.println("测试通过");
			} else {
				System.out.println("测试失败");
			}
			String s[] = resp.getHeaderFields("Set-Cookie");
			for (int i = 0; i < s.length; i++) {
				System.out.println(s[i] + "   ");
			}
			sp = resp.getHeaderField("Set-Cookie").split(";");
			System.out.println("获取Cookie信息为:\t" + sp[0]);
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
