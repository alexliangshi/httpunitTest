package sr;

import java.util.Random;
import java.util.regex.Pattern;

public class RandomCreateString {
	
	/**
	 * 随机生成字符串
	 * 
	 * @param mask 取值范围
	 * @param shuziNotStart  控制数字是否在随机字符串的第一位出现。当为true时，不会在第一位出现；反之可能会出现。
	 * @param booWord 包含中文
	 * @param minLength 最小字符串长度
	 * @param maxLength 最大字符串长度
	 * @return String
	 */
	public static String randString(String mask,boolean shuziNotStart,boolean booWord, int minLength,int maxLength)
	{
	
		if ( mask == null || mask.trim().equals("") )
		{
			mask = "qwertyuiopasdfghjklzxcvbnm_0123456789";
		}
		
		if(booWord)
		{
			//随机生成20个汉字追加到mask上
			StringBuffer nbuf = new StringBuffer();
			for (int i=0;i<20;i++)
			{
				nbuf.append( getRandomChar(2) );
			}
			mask += nbuf.toString();
			nbuf = null;
		}
		
		Random rand = new Random();
		
		// 先确定名称字符长度
		int charlen = maxLength - minLength + 1;		
		int[] lens = new int[ charlen ];
		for (int i=0;i<charlen;i++)
		{
			lens[ i ] = minLength + i;
		}
		
		int len = lens[ rand.nextInt(lens.length) ];
				
		//再确定名称的组合
		char[] secs = mask.toCharArray();
				
		StringBuffer buf = new StringBuffer();
		//从字符数组中随机搞出 len 个字符
		
		for (int i=0;i<len;)
		{
			char sec = secs[ rand.nextInt(secs.length) ];
						
			if ( shuziNotStart )
			{			
				// 屏蔽数字不能排在最前面
				if ( i == 0 )
				{				
					if ( Pattern.matches("[0-9]", String.valueOf(sec)) )
					{
						continue;
					}
				}
			}
			
			buf.append( sec );
			i++;
		}
		 		
		return buf.toString();
	}
	
	/**
	 * 随机生成汉字
	 * @return
	 */
	public static String getRandomChar(int num)
    {   
		StringBuffer buf = new StringBuffer();
		
		for(int i=0;i<num;i++){
			char word = (char)(0x4e00+(int)(Math.random()*(0x9fa5-0x4e00+1)));
			
			buf.append( word );	
		
		}
			
		return buf.toString();
    }
	
	/**
	 * 随机生成Email地址
	 * @return
	 */
	public static String getRandomEmail()
	
	{
		String part = randString(null,false,false,3,5); 
		String part1 = randString(null,false,false,3,5);
		String email =part+"@" + part1 + ".com";
		return email;
		
	}
	/**
	 * 随机生成手机号码
	 * @return
	 */
	public static String getPhoneNum()
	
	{
		String part = getRandomString(9); 
		String phoneNum ="13"+ part;
		return phoneNum;
		
	}
	
	/**
	 * 随机生成一定长度的数字
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
	/**
	 * 随机生成特殊字符串
	 * @param length
	 * @return
	 */
	public static String getSpecialString(int length) { //length表示生成字符串的长度
	    String base = "~!@#$%^&*()_+|?><,./\\=-`:\";''：“”~！@#￥%……&*（）——+|？》《，。、、=-·"; 
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();
	}
	
	
}