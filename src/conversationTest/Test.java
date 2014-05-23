package conversationTest;
import java.io.IOException;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
//import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import java.lang.String;
import org.xml.sax.SAXException;
//import junit.framework.TestCase;

public class Test{

	WebConversation conversation;

	

	public static void main(String[] args) {
		
		
		 WebConversation wc = new WebConversation();
		 try {
		 WebRequest req = new GetMethodWebRequest(
		 "http://httpunit.sourceforge.net/doc/cookbook.html");
		 WebResponse resp = wc.getResponse(req);
		 System.out.println(resp.getText());
		 } catch (IOException e) {
		 e.printStackTrace();
		 } catch (SAXException e) {
		
		 e.printStackTrace();
		 }

	}

}
