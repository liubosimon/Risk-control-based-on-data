package com.mj.feature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) throws Exception {

		UserLogInfoFeature uif = new UserLogInfoFeature();
		UserUpdateInfoFeature uuif = new UserUpdateInfoFeature();
		FeatureProcess fp = new FeatureProcess();
		MergeTool mt = new MergeTool();
		mt.mergeRank();

	}

	private static void countFeature(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		Map<String, Float> map1 = new HashMap<>();
		Map<String, Float> map2 = new HashMap<>();
		while ((line = br.readLine()) != null) {
			String splits[] = line.split(",");
			String sheng = splits[37];
			String label = splits[splits.length - 2];
			if (!map1.containsKey(sheng))
				map1.put(sheng, 0.0f);
			if (!map2.containsKey(sheng))
				map2.put(sheng, 0.0f);
			if (label.compareTo("1") == 0) {
				map1.put(sheng, map1.get(sheng) + 1);
			} else if (label.compareTo("0") == 0) {
				map2.put(sheng, map2.get(sheng) + 1);
			}
		}
		for (String key : map1.keySet())
			System.out.println(key + "," + map1.get(key)
					/ (map1.get(key) + map2.get(key)));
		br.close();
	}

	public static void analysis() throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader(
						"E:/mojing/PPD-First-Round-Data-Update/Training Set/PPD_LogInfo_3_1_Training_Set.csv"));
		String line = br.readLine();
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		while ((line = br.readLine()) != null) {
			String splits[] = line.split(",");
			if (map.containsKey(splits[0]))
				map.get(splits[0]).add(splits[1]);
			else {
				Set<String> list = new HashSet<String>();
				list.add(splits[1]);
				map.put(splits[0], list);
			}
		}
		br.close();
		for (String key : map.keySet())
			if (map.get(key).size() > 1)
				System.out.println(key);
	}
}
