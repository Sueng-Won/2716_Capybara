package com.game.textquiz;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class QuizPanel  extends JPanel {
	
	int count =0;
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
			switch (numArr[count++]) {
			
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
		
		
		
		card.next(this);   //다음 패널로 이동
	}

}
