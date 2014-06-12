package sr;

public class Split {
	

	public int count(String arg) {
		// TODO Auto-generated method stub
		// String arg = "Q：为什么创建半虚拟化VHD虚拟机模板会失败？M3|A：当前Cloudview系统仅支持VHD全虚拟化。M4";
		// String arg2 = "产品/定制项目/版本范围|CV1.5.1M1|所属子系统/模块|CVM-虚拟化管理"M5;
		// String arg3 = "来源|Cloudview1.5库->25M6|提供人|卢文沛M7|提供时间|2013-10-16M8";
		 int m = 0;
		for (int i = 0; i < arg.length(); i++) {
			String ar = arg.substring(i, i + 1);
			if (ar.equals("|"))
				m++;
			else
				continue;
		}
		return m;
	}

	public String[] n1(String arg) {
		String a[] = new String[200];
		int in = arg.indexOf("|");
		String fa = arg.substring(0, in);
		a[0] = fa;
		a[1] = arg.substring(in + 1, arg.length());
		//System.out.println(a[0]);
		//System.out.println(a[1]);
return a;
	}

	public String[] n3(String arg) {
		String c[] = new String[200];
		int in = arg.indexOf("|");
		String fa = arg.substring(0, in);
		c[0] = fa;
		c[1] = arg.substring(in + 1, arg.length());

		int in1 = c[1].indexOf("|");
		String fb = c[1].substring(0, in1);
		c[2] = fb;
		c[3] = c[1].substring(in1 + 1, c[1].length());

		int in2 = c[3].indexOf("|");
		String fc = c[3].substring(0, in2);
		c[4] = fc;
		c[5] = c[3].substring(in2 + 1, c[3].length());
		//System.out.println(c[2]);
		//System.out.println(c[5]);
		return c;
	}

	public String[] n5(String arg) {
		String b[] = new String[200];
		int in = arg.indexOf("|");
		String fa = arg.substring(0, in);
		b[0] = fa;
		b[1] = arg.substring(in + 1, arg.length());

		int in1 = b[1].indexOf("|");
		String fb = b[1].substring(0, in1);
		b[2] = fb;
		b[3] = b[1].substring(in1 + 1, b[1].length());

		int in2 = b[3].indexOf("|");
		String fc = b[3].substring(0, in2);
		b[4] = fc;
		b[5] = b[3].substring(in2 + 1, b[3].length());

		int in3 = b[5].indexOf("|");
		String fd = b[5].substring(0, in3);
		b[6] = fd;
		b[7] = b[5].substring(in3 + 1, b[5].length());

		int in4 = b[7].indexOf("|");
		String fe = b[7].substring(0, in4);
		b[8] = fe;
		b[9] = b[7].substring(in4 + 1, b[7].length());
		//System.out.println(b[2]);
		//System.out.println(b[6]);
		//System.out.println(b[9]);
		return b;
	}
	// return a;
	// System.out.println(a[0]);
	// System.out.println(a[1]);
	// System.out.println(a[2]);
	// System.out.println(a[3]);
	// System.out.println(a[4]);
	// System.out.println(a[5]);
	// System.out.println(a[6]);
	// System.out.println(a[7]);
	// System.out.println(a[8]);

}
