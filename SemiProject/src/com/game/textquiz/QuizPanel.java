package com.game.textquiz;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class QuizPanel  extends JPanel {
	
	int count =0;
	int quizNum = 0;
	int[] numArr = new int[5];
	
//  카드레이아웃 패널
	private CardLayout card = new CardLayout();
	private MainFrame F;
	
	public QuizPanel(MainFrame f){
		
		setLayout(card);
		
		F=f;  // 메인프레임에 패널 불러옴
		
		setVisible(true);
		
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
		
		if(count==5){
			F.dispose();
			}
		else{
		quizNum = numArr[count++];  
		}
		
		
		//changePanel()을 불러올 때마다 quizNum 숫자와 같은 패널 전환
		
		if(quizNum==1){
			add(new Quiz01(this));
			}
			if(quizNum==2){
			add(new Quiz02(this));
			}
			if(quizNum==3){
			add(new Quiz03(this));
			}
			if(quizNum==4){
			add(new Quiz04(this));
			}
			if(quizNum==5){
			add(new Quiz05(this));
			}
			if(quizNum==6){
			add(new Quiz06(this));
			}
			if(quizNum==7){
			add(new Quiz07(this));
			}
			if(quizNum==8){
			add(new Quiz08(this));
			}
			if(quizNum==9){
			add(new Quiz09(this));
			}
			if(quizNum==10){
			add(new Quiz10(this));
			}
		
		
		
		card.next(this);   //다음 패널로 이동
	}

}
