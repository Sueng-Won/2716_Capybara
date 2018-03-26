package com.game.cording;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class QuizManager {
	//public int[] value = { 0, 0, 0, 0, 0, 0, 0 }; // 값을 반환하는 정수배열 5번째는 피로도, 6번째는 성취도
	public void QuizManager() {
		if (Main.count < 5) {
			switch (Main.rArr[Main.count++]) {
				case 1:
					Quiz1 q1 = new Quiz1();
					q1.quiz1();
					break;
				case 2:
					Quiz2 q2 = new Quiz2();
					q2.quiz2();
					break;
				case 3:
					Quiz3 q3 = new Quiz3();
					q3.quiz3();
					break;
				case 4:
					Quiz4 q4 = new Quiz4();
					q4.quiz4();
					break;
				case 5:
					Quiz5 q5 = new Quiz5();
					q5.quiz5();
					break;
				case 6:
					Quiz6 q6 = new Quiz6();
					q6.quiz6();
					break;
				case 7:
					Quiz7 q7 = new Quiz7();
					q7.quiz7();
					break;
				case 8:
					Quiz8 q8 = new Quiz8();
					q8.quiz8();
					break;
				case 9:
					Quiz9 q9 = new Quiz9();
					q9.quiz9();
					break;
				case 10:
					Quiz10 q10 = new Quiz10();
					q10.quiz10();
					break;
			}
		}
		else if(Main.count==5) {
			JOptionPane.showMessageDialog(null, "게임이 종료되었습니다!");
			Main.count=0;
			try (BufferedReader br =new BufferedReader(new FileReader("Sender.dat"))) {
			
				String[] tempStr = new String[7];
				String temp;
				int check = 0;
				int[] valueArr = new int[7];
				while ((temp = br.readLine()) != null) {
					tempStr[check++] = temp;
				}
				for (int i = 0; i < 7; i++) {
					valueArr[i] = Integer.parseInt(tempStr[i]);
				}
//				valueArr[0] += -10;
//				valueArr[1] += -10;
//				valueArr[2] += -10;
//				valueArr[3] += -10;
//				valueArr[4] += -10;
//			valueArr[5] += +30;
//				valueArr[6] += 0;
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sender.dat"))) {
					for (int i = 0; i < 7; i++) {
						bw.write(String.valueOf(valueArr[i]));
						bw.newLine();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
