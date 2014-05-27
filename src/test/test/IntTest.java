package test.test;
import com.meterware.httpunit.WebResponse;
import test.basic.*;
public class IntTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url="http://httpunit.sourceforge.net/doc/cookbook.html";
		//GetUrl gu=new GetUrl(url);
		CreateConverstation cc= new CreateConverstation();
		WebResponse wr=cc.newone(url);
		System.out.println(wr.getCharacterSet());
	}

}
