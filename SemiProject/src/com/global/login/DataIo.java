package com.global.login;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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
			String copyArr[] = new String[readProp.size()];
			int count = 0;
			for (String key : readProp.stringPropertyNames()) {
				String value = readProp.getProperty(key);
				copyArr[count++] = value + "/" + key + "/";
				System.out.println(copyArr[count - 1]);
			}
			System.out.println("----------------------");
			Arrays.sort(copyArr);
			Collections.reverse(Arrays.asList(copyArr));
			String copyStr = "";
			for (String str : copyArr) {
				copyStr += str;
			}
			System.out.println(copyStr);
			String[] result = new String[readProp.size() * 2];
			result = copyStr.split("/");
			int check = 1;
			for (int i = 0; i<result.length;i++) {
				
				System.out.print(result[i]+ " ");
				if(check%2==0) {
					System.out.println();
				}
				check++;
			}
			// Map mapReverse = new TreeMap(Collections.reverseOrder());
			//
			//
			// Set<Object> keySet = readProp.keySet();
			// Iterator<Object> iterator = keySet.iterator();
			// List<Object> keyList = new ArrayList<Object>();
			//
			//
			// while(iterator.hasNext()){
			// String key = (String)iterator.next();
			// mapReverse.put(readProp.getProperty(key), key);
			// keyList.add(readProp.getProperty(key));
			// }
			// Collections.reverse(keyList);
			// System.out.println(mapReverse);
			// System.out.println(keyList);
			//
			//
			// for(int i=0; i<5; i++){
			// String score = (String) keyList.get(i);
			// String id = (String) mapReverse.get(keyList.get(i));
			// scoreboard.add(new JLabel(i+1+"등!!"+" "+id+" "+score)).setFont(new
			// Font("맑은고딕", Font.BOLD, 30));
			// }
			//
			//
			// scoreboard.setVisible(true);
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
