package test.webTest.cloudview.login;
import test.conversationTest.CloudviewCreatePOSTConversation;
public class POSTtest{

	public static void main(String[] args) {
		String url = "http://10.0.33.93:8181/webapps.hostbundle/login";
		CloudviewCreatePOSTConversation cps = new CloudviewCreatePOSTConversation();
		
			cps.Post(url);
			cps.Get(url);
	}
}
