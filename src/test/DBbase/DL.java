package test.DBbase;

//import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
//import java.util.Iterator;
//import javax.swing.text.TableView.TableCell;
//import org.apache.poi.*;
//import org.apache.poi.hdf.extractor.TableRow;
//import org.apache.poi.hwpf.extractor.WordExtractor;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class DL {
	static String m[] = new String[500];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream in = null;
		java.util.List<String> list = new ArrayList<String>();
		try {
			in = new FileInputStream(new File("C:/Cloudview1.5产品FAQ手册v1.1.doc"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		HWPFDocument hdt = null;
		try {
			hdt = new HWPFDocument(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Range r = hdt.getRange();
		TableIterator it = new TableIterator(r);
		if (it.hasNext()) {
			org.apache.poi.hwpf.usermodel.TableRow tr = null;
			org.apache.poi.hwpf.usermodel.TableCell td = null;
			Paragraph para = null;
			String lineString;
			String cellString;
			Split s1 = new Split();
			int n;
			while (it.hasNext()) {
				int l = 1;
				m[0] = Integer.toString(l);
				Table tb = (Table) it.next();
				for (int i = 0; i < tb.numRows(); i++) {//
					// System.out.println(tb.numRows());
					tr = tb.getRow(i);
					lineString = "";
					for (int j = 0; j < tr.numCells(); j++) {
						td = tr.getCell(j);// 取得单元格
						for (int k = 0; k < td.numParagraphs(); k++) {
							para = td.getParagraph(k);
							cellString = para.text();
							// System.out.println(cellString.toString());
							if (cellString != null
									&& cellString.compareTo("") != 0) { // 如果不trim，取出的内容后会有一个乱码字符
								cellString = cellString.trim() + "|";
							}
							lineString += cellString;
						}
					} // 去除字符串末尾的一个管道符
					if (lineString != null && lineString.compareTo("") != 0) {
						lineString = lineString.substring(0,
								lineString.length() - 1);
					}
					list.add(lineString);
					if (lineString.equals("描述")) {
						continue;
					} else if (lineString.equals("截图")) {
						continue;
					} else if (lineString.equals("")) {
						continue;
					}

					n = s1.count(lineString);
					if (n == 1) {
						String a[] = s1.n1(lineString);
						m[3] = a[0];
						m[4] = a[1];
					}
					if (n == 3) {
						String c[] = s1.n3(lineString);
						m[1] = c[2];
						m[5] = c[5];
					}

					if (n == 5) {
						s1.n5(lineString);
						String b[] = s1.n5(lineString);
						m[6] = b[2];
						m[7] = b[6];
						m[8] = b[9];
					}
				}
				l++;
				DBlink ln = new DBlink();
				ln.insert(m);
			}
			in.close();
		}

	}

}