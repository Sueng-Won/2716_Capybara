package com.global.login;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;

public class DataIo {
	static String id;
	int checkIdx = 0;

	Properties prop = new Properties();

	public DataIo() {
		try {
			prop.loadFromXML(new FileInputStream("data.xml"));
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveId(String id) {
		this.id = id;
		System.out.println(id);
	}

	public void saveAchievement(int achievement) {
		String score = String.valueOf(achievement);

		try {
			prop.setProperty(id, score);
			prop.storeToXML(new FileOutputStream("data.xml"), "score");
			System.out.println(this.id + ", " + score);
			prop.load(new FileReader("data.xml"));
			System.out.println(prop);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int check(String name) {

		DataIo data = new DataIo();
		Set<Object> set = data.prop.keySet();
		Iterator<Object> iter = set.iterator();

		while (iter.hasNext()) {
			if (name.equals(iter.next())) {
				checkIdx = -1;
			}
		}

		return checkIdx;
	}

	public void scoreboard() {
		JFrame scoreboard = new JFrame("점수판");
		scoreboard.setBounds(600, 200, 430, 700);
		scoreboard.setLayout(new GridLayout(5, 1));

		Properties readProp = new Properties();
		try {
			readProp.loadFromXML(new FileInputStream("data.xml"));
			Map<String, String> idSort = new TreeMap<String,String>();

			for (String name : readProp.stringPropertyNames()) {
				idSort.put(name, readProp.getProperty(name));
			}
			
			
			Iterator<String> iter = sort(idSort).iterator();
			
			while(iter.hasNext()) {
	            String temp = (String) iter.next();
	            System.out.println(temp + " = " + idSort.get(temp));
	        }
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> sort(Map<String, String> map) {
		List<String> list = new ArrayList<String>();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				int v1 = Integer.parseInt(map.get(o1));
				int v2 = Integer.parseInt(map.get(o2));
				return ((Comparable<Integer>) v2).compareTo(v1);
			}
		});
		return list;
	}
}
