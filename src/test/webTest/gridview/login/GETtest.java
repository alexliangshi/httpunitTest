package test.webTest.gridview.login;
import test.conversationTest.CreatePOSTConversation;
public class GETtest{

	public static void main(String[] args) {
		
		CreatePOSTConversation cps = new CreatePOSTConversation();
		for(int i=0;i<100000;i++){
			cps.setup();
		}
		
	}
}
