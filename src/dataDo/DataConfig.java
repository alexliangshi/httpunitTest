package dataDo;

import java.io.IOException;
import java.sql.Connection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class DataConfig {
	protected String driver = null;
	protected String jdbc = null;
	protected String DML[] = { "insert", "select", "update", "delete" };
	protected String charSet = null;
	protected String url = null;
	protected String user = null;
	protected String passwd = null;
	protected String DBname = null;
	protected String Tablename = null;
	protected Connection conn = null;

	/*public static void main(String[] args) {
		DataConfig dc = new DataConfig();
		try {
			System.out.println(dc.parseConfigFile("charSet"));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(dc.returnCharSet());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public String parseConfigFile(String s)
			throws ParserConfigurationException, SAXException, IOException {
		String rs = "test";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("dataDoConfig.xml");
		NodeList nl = doc.getElementsByTagName(s);
		Node n1 = nl.item(0);
		rs = n1.getFirstChild().getNodeValue();
		return rs;

	}

	public String returnDriver() {
		String t=null;
		try {
			t=this.parseConfigFile("driver");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnJdbc() {
		String t=null;
		try {
			t=this.parseConfigFile("jdbc");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnDml(int i) {
		return this.DML[i];
	}

	public String returnCharSet() {
		String t=null;
		try {
			t=this.parseConfigFile("charSet");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnUrl() {
		String t=null;
		try {
			t=this.parseConfigFile("url");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnUser() {
		String t=null;
		try {
			t=this.parseConfigFile("user");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnPasswd() {
		String t=null;
		try {
			t=this.parseConfigFile("passwd");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnDBname() {
		String t=null;
		try {
			t=this.parseConfigFile("DBname");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public String returnTablename() {
		String t=null;
		try {
			t=this.parseConfigFile("Tablename");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
