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
			System.out.println("请求的URL为: " + httpPost.getURI());
			System.out.println("请求的方法为" + httpPost.getMethod());
			System.out.println("请求的参数：");
			// JOptionPane.showMessageDialog(null, httpPost.getMethod(),"信息",
			// 0);
			nvps.add(new BasicNameValuePair("username", "sugon1111"));
			nvps.add(new BasicNameValuePair("password", "123456"));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			System.out.println("用户名: " + nvps.get(0).getValue());
			System.out.println("密码: " + nvps.get(1).getValue());
			Postres = httpclient.execute(httpPost);
			System.out.println("GET请求状态行:" + Postres.getStatusLine());
			HttpEntity entity = Postres.getEntity();
			txt = EntityUtils.toString(entity);
//			System.out.println("返回的HTML为：" + txt);
			String s = "用户认证失败：用户不存在！";
//			System.out.println(txt);
			// Assert.assertEquals(txt.contains(s),true);
			if (txt.contains(s) == true) {
				System.out.println("测试通过");
			} else {
				System.out.println("测试不通过");
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
			System.out.println("请求的URL为: " + httpget.getURI());
			System.out.println("请求的方法为" + httpget.getMethod());
			System.out.println("请求的参数：");
			Getres = httpclient.execute(httpget);
			System.out.println("GET请求状态行:" + Getres.getStatusLine());
			HttpEntity entity = Getres.getEntity();
			txt = EntityUtils.toString(entity);
			System.out.println("返回的HTML为：" + txt);
			Getres.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
