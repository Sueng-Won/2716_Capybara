package com.global.login;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataIo {
	static String id;
	
	Properties prop = new Properties();
	
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
}
