package pa1;

import java.io.IOException;
import java.net.MalformedURLException;
import com.meterware.httpunit.HTMLPage;
import com.meterware.httpunit.GetMethodWebRequest;
//import com.meterware.httpunit.PostMethodWebRequest;   
//import com.meterware.httpunit.TableCell;   
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;
//import com.meterware.httpunit.WebForm;   
//import com.meterware.httpunit.WebLink;   
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebClient;
import com.meterware.httpunit.WebResponse;
//import com.meterware.httpunit.WebTable;   
import java.lang.String;
//import java.net.MalformedURLException;
//import com.meterware.httpunit.*;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) {

		try {
			WebConversation wc = new WebConversation();
			WebRequest req = new GetMethodWebRequest("http://httpunit.sourceforge.net/doc/cookbook.html");
			WebResponse resp= wc.getResponse(req);
			resp.getCharacterSet();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		}  

	}

}
