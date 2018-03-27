package com.game.textquiz;


import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;





public class QuizPanel  extends JPanel {
	
	int count =0;
	int[] numArr = new int[5];
	int[] value = new int[7];
	boolean pointBo = false;  // 정답체크 논리값
	
//  카드레이아웃 패널
	private CardLayout card = new CardLayout();
	private MainFrame F;
	
	public QuizPanel(MainFrame f){
		
		setLayout(card);
		
		F=f;  // 메인프레임에 패널 불러옴
		
		
		if(count==0){   
			// 처음 randomOutput() 실행시 랜덤 번호 5개 저장
			
			
			
		for (int i = 0; i < numArr.length; i++) {

			numArr[i] = (int) (Math.random() * 10) + 1;

			for (int j = 0; j < i; j++) {

				if (numArr[i] == numArr[j]) {
					i--;
					break;
				}
				}
				}
		}

		
		setVisible(true);
		
		changePanel();  // changePanel로 이동하여 퀴즈패널 실행
		
		}
		
		
	public void changePanel(){
		

		
		
		if(count>0){
			
		if(pointBo == true){     // true = 정답 일시

			F.wait=false;  // 타임 감소 시작
			
			try (BufferedReader br = new BufferedReader(new FileReader("Sender.dat")))
			{

				String[] tempStr = new String[7];
				String temp;
				int check = 0;
				
				while ((temp = br.readLine()) != null) {
					tempStr[check++] = temp;
				}
				for (int i = 0; i < 7; i++) {
					value[i] = Integer.parseInt(tempStr[i]);
				}
				value[count-1] =-20;
				value[5] += 5;
				value[6] += 200;
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sender.dat"))) {
					for (int i = 0; i < 7; i++) {
						bw.write(String.valueOf(value[i]));
						bw.newLine();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		if(pointBo == false){    // false = 오답 일시
			F.wait=false;
			try (BufferedReader br = new BufferedReader(new FileReader("Sender.dat")))
			{

				String[] tempStr = new String[7];
				String temp;
				int check = 0;
				
				while ((temp = br.readLine()) != null) {
					tempStr[check++] = temp;
				}
				for (int i = 0; i < 7; i++) {
					value[i] = Integer.parseInt(tempStr[i]);
				}
				value[count-1] =-40;
				value[5] += 10;
				value[6] += 0;
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sender.dat"))) {
					for (int i = 0; i < 7; i++) {
						bw.write(String.valueOf(value[i]));
						bw.newLine();
					}
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		}
		
		if(count==5){
			
			F.dispose();
			
			}
		
		
		else{
			switch (numArr[count]) {
			
			case 1:
				add(new Quiz01(this));
				break;
			case 2:
				add(new Quiz02(this));
				break;
			case 3:
				add(new Quiz03(this));
				break;
			case 4:
				add(new Quiz04(this));
				break;
			case 5:
				add(new Quiz05(this));
				break;
			case 6:
				add(new Quiz06(this));
				break;
			case 7:
				add(new Quiz07(this));
				break;
			case 8:
				add(new Quiz08(this));
				break;
			case 9:
				add(new Quiz09(this));
				break;
			case 10:
				add(new Quiz10(this));
				break;

			}
		}
		
		count++;
		
		card.next(this);   //다음 패널로 이동
	}

}
