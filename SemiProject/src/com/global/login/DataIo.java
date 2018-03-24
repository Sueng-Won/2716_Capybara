package com.global.login;

import java.awt.Color;
import java.awt.Font;
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

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		scoreboard.setLayout(new GridLayout(6, 3));
		scoreboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel desc1 = new JLabel("순위");
		JLabel desc2 = new JLabel("아이디");
		JLabel desc3 = new JLabel("점수");
		
		desc1.setHorizontalAlignment(JLabel.CENTER);
		desc2.setHorizontalAlignment(JLabel.CENTER);
		desc3.setHorizontalAlignment(JLabel.CENTER);
		
		desc1.setFont(new Font("돋움",Font.BOLD,25));
		desc2.setFont(new Font("돋움",Font.BOLD,25));
		desc3.setFont(new Font("돋움",Font.BOLD,25));
		
		desc1.setBorder(BorderFactory.createLineBorder(new Color(60,30,30)));
		desc2.setBorder(BorderFactory.createLineBorder(new Color(60,30,30)));
		desc3.setBorder(BorderFactory.createLineBorder(new Color(60,30,30)));
		
		desc1.setBackground(new Color(251,174,23));
		desc2.setBackground(new Color(251,174,23));
		desc3.setBackground(new Color(251,174,23));
		
		desc1.setOpaque(true);
		desc2.setOpaque(true);
		desc3.setOpaque(true);
		
		scoreboard.add(desc1);
		scoreboard.add(desc2);
		scoreboard.add(desc3);
		Properties readProp = new Properties();
		try {
			readProp.loadFromXML(new FileInputStream("data.xml"));
			Map<String, String> idSort = new TreeMap<String,String>();

			for (String name : readProp.stringPropertyNames()) {
				idSort.put(name, readProp.getProperty(name));
			}
			
			Iterator<String> iter = sort(idSort).iterator();
			
			for(int i = 0; i<5; i++) {
				String temp = (String) iter.next();
				JLabel tempLabel1 = new JLabel(String.valueOf(i+1));
				JLabel tempLabel2 = new JLabel(temp);
				JLabel tempLabel3 = new JLabel(idSort.get(temp));
				
				tempLabel1.setHorizontalAlignment(JLabel.CENTER);
				tempLabel2.setHorizontalAlignment(JLabel.CENTER);
				tempLabel3.setHorizontalAlignment(JLabel.CENTER);
				
				tempLabel1.setFont(new Font("돋움",Font.PLAIN,20));
				tempLabel2.setFont(new Font("돋움",Font.PLAIN,20));
				tempLabel3.setFont(new Font("돋움",Font.PLAIN,20));
				
				tempLabel1.setBorder(BorderFactory.createLineBorder(new Color(60,30,30)));
				tempLabel2.setBorder(BorderFactory.createLineBorder(new Color(60,30,30)));
				tempLabel3.setBorder(BorderFactory.createLineBorder(new Color(60,30,30)));
				
				tempLabel1.setBackground(new Color(233,221,198));
				tempLabel2.setBackground(new Color(233,221,198));
				tempLabel3.setBackground(new Color(233,221,198));
				
				tempLabel1.setOpaque(true);
				tempLabel2.setOpaque(true);
				tempLabel3.setOpaque(true);
				
				scoreboard.add(tempLabel1);
				scoreboard.add(tempLabel2);
				scoreboard.add(tempLabel3);
			}
			scoreboard.setVisible(true);
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
