package test.webTest;
import java.io.IOException;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
//import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import java.lang.String;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

class Setup{
//	static final Logger logger = LogManager.getLogger(Setup.class.getName());
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
		 WebRequest req1 = new GetMethodWebRequest("http://10.0.31.46:6080/nisconfig/commonfunc/queryRack.action");
		 WebResponse resp1 = wc.getResponse(req1);
		 System.out.println(resp1.getText());
		} catch (IOException e) {
		 e.printStackTrace();
		 } catch (SAXException e) {
		
		 e.printStackTrace();
		 }
	}
	
}
public class GETtest{

	public static void main(String[] args) {
		
		Setup st = new Setup();
		st.setup();
		 

	}

}
