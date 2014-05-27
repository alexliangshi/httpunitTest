package test.basic;

import java.io.IOException;
import org.xml.sax.SAXException;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class CreateConverstation {
	public WebResponse newone(String uu) {
		String url = uu;
		WebResponse wr = null;
		try {

			WebConversation wc = new WebConversation();
			WebRequest req = new GetMethodWebRequest(url);
			WebResponse resp = wc.getResponse(req);
			//System.out.println(resp.getContentType());
			wr = resp;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		}
		return wr;
	}
/*
 * test main method as below
 
	public static void main(String args[]) {
		String url = "http://httpunit.sourceforge.net/doc/cookbook.html";
		CreateConverstation cc = new CreateConverstation();
		WebResponse wr = cc.newone(url);
		System.out.println(wr.getCharacterSet());

	}
*/
}
