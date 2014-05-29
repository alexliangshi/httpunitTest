package test.conversationTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import test.basic.*;
public class Test {

	public static void outGc(String url) {// check output result
		CreateConverstation cc = new CreateConverstation();
		System.out.println(cc.newone(url).getCharacterSet());
	}

	public static String SGC(String url) {
		CreateConverstation cc = new CreateConverstation();
		String s1 = null;
		try {
			s1 = cc.newone(url).getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1;
	}

	public static File CreateLog() {

		File f1 = new File("resource", "log.txt");
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f1;
	}

	public static void main(String[] args) {
		String url = "http://httpunit.sourceforge.net/doc/cookbook.html";
		String s1 = Test.SGC(url);
		File f1 = Test.CreateLog();

		System.out.println("Start running fuction.....");
		try {
			@SuppressWarnings("resource")
			FileOutputStream fo = new FileOutputStream(f1);
			fo.write(s1.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("saving log.....");
	}
}
