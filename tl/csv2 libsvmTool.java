package util;


import java.io.BufferedReader;
import java.io.PrintWriter;

public class Csv2LibsvmTool {
	public static void transform(String in, String out, String ClassIndex) throws Exception {
		BufferedReader br = Util.readFile(in);
		PrintWriter pt = Util.writeFile(out);
		String f_name[] = br.readLine().split(",");
		int name[]=new int[f_name.length];
		for(int i=0;i<name.length;i++)
		{
			name[i]=i;
		}
		String line = "";
		int classIndex = ClassIndex.equals("last") ? (f_name.length - 1) : 0;
		if (classIndex == 0) {
			while ((line = br.readLine()) != null) {
				String t[] = line.split(",");
				StringBuffer sb = new StringBuffer(t[classIndex]);
				for (int i = 1; i < t.length; i++) {
					sb.append(" " + name[i] + ":" + t[i]);
				}
				pt.println(sb.toString());
			}
		} else {
			while ((line = br.readLine()) != null) {
				String t[] = line.split(",");
				StringBuffer sb = new StringBuffer(t[classIndex]);
				for (int i = 0; i < classIndex; i++) {
					sb.append(" " + name[i] + ":" + t[i]);
				}
				pt.println(sb.toString());
			}
		}
		br.close();
		pt.close();
	}
	public static void main(String[] args)throws Exception {
		String in="G:\\madelon_1.csv";
		String out="G:\\madelon_1.libsvm";
		transform(in, out, "last");
	}
}
