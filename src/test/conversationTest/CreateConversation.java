package test.conversationTest;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CreateConversation {
	public void setup(){
		WebConversation wc = new WebConversation();
		 
		try {
		 WebRequest req = new GetMethodWebRequest(
		 "http://10.0.31.46:6080/login/loginAuth.action");
		 req.setParameter("strUserName", "optadmin");
		 req.setParameter("strPassword", "1111111");
		 req.setParameter("strUserType", "gridview");
//		 logger.trace("Entering application.....");
		 WebResponse resp = wc.getResponse(req);
		 System.out.println(resp.getText());
		 System.out.println(resp.getResponseMessage());
		 System.out.println(resp.getURL());
		 System.out.println(resp.getResponseCode());
		 System.out.println(req.getMethod());
		} catch (IOException e) {
		 e.printStackTrace();
		 } catch (SAXException e) {
		
		 e.printStackTrace();
		 }
	}
}
