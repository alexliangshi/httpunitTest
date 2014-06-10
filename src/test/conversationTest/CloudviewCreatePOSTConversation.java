package test.conversationTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
public class CloudviewCreatePOSTConversation {
	private String txt;

	public void setup() {
		String url= "http://10.0.33.93:8181/webapps.hostbundle/login";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		HttpPost httpPost = new HttpPost(url);
		try {
			CloseableHttpResponse Postres = httpclient.execute(httpPost);
			CloseableHttpResponse Getres = httpclient.execute(httpPost);
			System.out.println("GET����״̬��:"+Getres.getStatusLine());	
			txt = null;
			HttpEntity entity= Postres.getEntity();
			List <NameValuePair> nvps = new ArrayList <NameValuePair>();
			System.out.println("�����URLΪ: "+httpget.getURI());
			System.out.println("����ķ���Ϊ"+httpPost.getMethod());
			nvps.add(new BasicNameValuePair("username", "sugon"));
			nvps.add(new BasicNameValuePair("password", "123456"));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			CloseableHttpResponse res2 = httpclient.execute(httpPost);
			
			entity=res2.getEntity();
			txt=EntityUtils.toString(entity,"UTF-8");
			String s = "�û���֤ʧ�ܣ��û������ڣ�";
//			Assert.assertEquals(txt.contains(s),true);
			if(txt.contains(s)==true){
				System.out.println("����ͨ��");
			}else{
				System.out.println("���Բ�ͨ��");
			}
			Postres.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
