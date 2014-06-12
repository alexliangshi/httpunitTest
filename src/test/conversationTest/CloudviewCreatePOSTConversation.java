package test.conversationTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
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

	}

	public void Post(String url) {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);
		try {
			CloseableHttpResponse Postres = httpclient.execute(httpPost);
			
			
			txt = null;

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			System.out.println("�����URLΪ: " + httpPost.getURI());
			System.out.println("����ķ���Ϊ" + httpPost.getMethod());
			System.out.println("����Ĳ�����");
			// JOptionPane.showMessageDialog(null, httpPost.getMethod(),"��Ϣ",
			// 0);
			nvps.add(new BasicNameValuePair("username", "sugon1111"));
			nvps.add(new BasicNameValuePair("password", "123456"));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			System.out.println("�û���: " + nvps.get(0).getValue());
			System.out.println("����: " + nvps.get(1).getValue());
			Postres = httpclient.execute(httpPost);
			System.out.println("GET����״̬��:" + Postres.getStatusLine());
			HttpEntity entity = Postres.getEntity();
			txt = EntityUtils.toString(entity);
//			System.out.println("���ص�HTMLΪ��" + txt);
			String s = "�û���֤ʧ�ܣ��û������ڣ�";
//			System.out.println(txt);
			// Assert.assertEquals(txt.contains(s),true);
			if (txt.contains(s) == true) {
				System.out.println("����ͨ��");
			} else {
				System.out.println("���Բ�ͨ��");
			}
			Postres.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Get(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		try {
			CloseableHttpResponse Getres = httpclient.execute(httpget);
			txt = null;
			System.out.println("�����URLΪ: " + httpget.getURI());
			System.out.println("����ķ���Ϊ" + httpget.getMethod());
			System.out.println("����Ĳ�����");
			Getres = httpclient.execute(httpget);
			System.out.println("GET����״̬��:" + Getres.getStatusLine());
			HttpEntity entity = Getres.getEntity();
			txt = EntityUtils.toString(entity);
			System.out.println("���ص�HTMLΪ��" + txt);
			Getres.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
