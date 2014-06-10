package htmlunit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import com.gargoylesoftware.htmlunit.javascript.*;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.eclipse.jetty.http.*;
public class Test {
	public static void main(String[] args) {

		try {
			
			WebClient wc = new WebClient(BrowserVersion.CHROME);
			wc.getOptions().setJavaScriptEnabled(false);
			HtmlPage pa = wc.getPage("http://10.0.33.93:8181/webapps.hostbundle/userlogin");
//			System.out.println(pa.get);
			
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
