package test.basic;


public class GetUrl {
	static String url;

	public GetUrl(String urlnew) {
		url = urlnew;
		
	}

	public String printUrl() {
		String uu =GetUrl.url;
		return uu;
	}
	
}
