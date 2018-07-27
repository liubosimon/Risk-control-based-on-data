package feature;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import util.Util;

public class OneHot {
	public static void main(String[] args) throws Exception{
		onehot();
	}
	public static void run()throws Exception{
		HashMap<String, String> map1=getmap("G:\\listinfo5.csv");
		HashMap<String, String> map2=getmap("G:\\listinfo10.csv");
		HashMap<String, String> map3=getmap("G:\\listinfo15.csv");
		HashMap<String, String> map4=getmap("G:\\listinfo20.csv");
		HashMap<String, String> map5=getmap("G:\\listinfo25.csv");
		PrintWriter pt=Util.writeFile("G:\\listinfo.csv");
		for(String key:map1.keySet())
		{
			pt.println(key+","+map1.get(key)+","+map2.get(key)+","+map3.get(key)+","+map4.get(key)+","+map5.get(key));
		}
		pt.close();
	}
	public static HashMap<String, String> getmap(String path)throws Exception
	{
		HashMap<String, String> map=new HashMap<>();
		BufferedReader br=Util.readFile(path);
		String line=br.readLine();
		while((line=br.readLine())!=null)
		{
			String t[]=line.split(",");
			map.put(t[0], t[1]);
		}
		br.close();
		return map;
	}
	
	public static String array2string(int a[]){
		StringBuffer sb=new StringBuffer(a[0]+"");
		for(int i=1;i<a.length;i++)
		{
			sb.append(","+a[i]);
		}
		return sb.toString();
	}
	public static void onehot()throws Exception
	{
		BufferedReader br=Util.readFile("G:\\listinfo.csv");
		PrintWriter pt=Util.writeFile("G:\\listinfo_onehot.csv");
		String line=br.readLine();
		int size=line.split(",").length;
		ArrayList<String> list=new ArrayList<>();
		while((line=br.readLine())!=null)
		{
			list.add(line);
		}
		HashMap<String, StringBuffer> map=new HashMap<>();
		for(int i=1;i<size;i++)
		{
			HashSet<String> set=new HashSet<>();
			for(String l:list)
			{
				set.add(l.split(",")[i]);
			}
			System.out.println(set.size());
			HashMap<String, Integer> index=new HashMap<>();//ӳ������
			int ind=0;
			for(String a:set)
			{
				index.put(a, ind);
				ind++;
			}
			for(String l:list)
			{
				int a[]=new int[set.size()];
				String key=l.split(",")[0];
				
				a[index.get(l.split(",")[i])]=1;
				if (map.containsKey(key)) {
					map.get(key).append(","+array2string(a));
				}else {
					StringBuffer sb=new StringBuffer();
					sb.append(","+array2string(a));
					map.put(key, sb);
				}
			}
//			break;
		}
		
		for(String key:map.keySet())
		{
			pt.println(key+map.get(key));
		}
		pt.close();
	}
}
