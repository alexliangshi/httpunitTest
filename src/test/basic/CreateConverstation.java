package test.basic;

import java.io.IOException;
import org.xml.sax.SAXException;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CreateConverstation {
	public void newone(String uu) {
		String url = uu;

		try {
			WebConversation wc = new WebConversation();
			WebRequest req = new GetMethodWebRequest(url);
			WebResponse resp = wc.getResponse(req);
			System.out.println(resp.getContentLength());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		String url = "http://www.baidu.com";
		// GetUrl gu=new GetUrl(url);
		CreateConverstation cc = new CreateConverstation();
		cc.newone(url);
	}
	
	
//	public static void main(String[] args) {
//		GetUrl gu = new GetUrl("www.baidu.com");
//		gu.printUrl();
//		String url ="http://httpunit.sourceforge.net/doc/cookbook.html";
//		try {
//			
//			WebConversation wc = new WebConversation();
//			WebRequest req = new GetMethodWebRequest(url);
//			WebResponse resp = wc.getResponse(req);
//			System.out.println(resp.getContentLength());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//
//			e.printStackTrace();
//		}
//	}
}
