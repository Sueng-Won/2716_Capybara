package com.global.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


import javax.swing.JOptionPane;

public class DataIo {
	static String id;
	int checkIdx = 0;
	
	Properties prop = new Properties();
	
	public DataIo(){
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
	
	public void saveId(String id){
			this.id = id;
			System.out.println(id);

	}
	
	public void saveAchievement(int achievement){
		String score = String.valueOf(achievement);

		try {
			prop.setProperty(id, score);
			prop.storeToXML(new FileOutputStream("data.xml"), "score");
			System.out.println(this.id+", "+score);
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
	
	public int check(String name){
		
		DataIo data = new DataIo();
		Set<Object> set = data.prop.keySet();
		Iterator<Object> iter = set.iterator();
		
		while(iter.hasNext()){
			if(name.equals(iter.next())){
				checkIdx = -1;
			}
		}
		
		return checkIdx;
	}
}
