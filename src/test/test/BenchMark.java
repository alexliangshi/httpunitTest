package test.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BenchMark extends TestCase {

	WebConversation wc = new WebConversation();
	WebRequest req = null;
	WebResponse resp = null;
	String sResponse = null;
	public String CookieVal;

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

	public static TestSuite suite() {
		return new TestSuite(BenchMark.class);
	}

	public BenchMark(String s) {
		super(s);
	}

	public void testEntry() throws Exception {

		req = new GetMethodWebRequest("http://10.0.31.46:6080");
		resp = wc.getResponse(req);
		sResponse = resp.getText();
		writeToFile(sResponse);
	}

	public void testLogon() throws Exception {

		try {
			req = new GetMethodWebRequest(
					"http://10.0.31.46:6080/login/loginAuth.action?strUserName=optadmin&strPassword=1111111&strUserType=gridview");
			resp = wc.getResponse(req);

			String sHeadernames[] = resp.getHeaderFieldNames();

			String[] CookieVal = resp.getHeaderFields("SET-COOKIE");
			String sessionid = CookieVal[0].substring(0,
					CookieVal[0].indexOf(";"));
			System.out.println("this is sessionid" + sessionid);
			wc.setHeaderField("Cookie", sessionid);
			writeToFile(resp.getText());
		} catch (java.net.MalformedURLException e) {
			writeToFile(resp.getText());
		}
	}

	public void testuDtaProfile() throws Exception {

		try {
			req = new GetMethodWebRequest(
					"http://localhost:8080/arl/udta/profile");
			resp = wc.getResponse(req);
			writeToFile(resp.getText());
		} catch (java.net.MalformedURLException e) {
			writeToFile(resp.getText());
		}
	}

	public void testData() throws Exception {

		try {
			req = new GetMethodWebRequest("http://localhost:8080/arl/bdta/data");
			resp = wc.getResponse(req);
			writeToFile(resp.getText());
		} catch (java.net.MalformedURLException e) {
			writeToFile(resp.getText());
		}
	}

	/*
	 * Dom start Document dom = null; try { dom = resp.getDOM(); } catch
	 * (org.xml.sax.SAXException e) { System.out.println("XML Err: " + e); }
	 * String[] domChildren; domChildren[]=dom.getChildNodes(1);
	 * System.out.println(domChildren[0]); Dom end
	 */

	// Code for writing to file
	public void writeToFile(String sResponse) throws Exception {

		try {
			Writer output = null;
			File file = new File("resource\\" + this.getClass().getName()
					+ this.getName() + "log.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write(sResponse);
			output.close();
			System.out.println("Your file has been written as log");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}