package com.global.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class StudentVo{
	private JProgressBar concentrationStu[] = new JProgressBar[5];
	private JProgressBar stress;
	private JLabel achievementLabel;
	private JLabel achivementCount;
	private int achievement=25555000;
	
	public StudentVo(){
		//프로그레스바 설정 집중력
		concentrationStu[0] = new JProgressBar(0,100); 
		concentrationStu[0].setStringPainted(true);
		concentrationStu[0].setBounds(50, 500, 200, 40);
		concentrationStu[0].setBackground(Color.BLUE);
		
		concentrationStu[1] = new JProgressBar(0,100); 
		concentrationStu[1].setStringPainted(true);
		concentrationStu[1].setBounds(290, 500, 190, 40);
		concentrationStu[1].setBackground(Color.BLUE);
		
		concentrationStu[2] = new JProgressBar(0,100); 
		concentrationStu[2].setStringPainted(true);
		concentrationStu[2].setBounds(520, 500, 200, 40);
		concentrationStu[2].setBackground(Color.BLUE);
		
		concentrationStu[3] = new JProgressBar(0,100);
		concentrationStu[3].setStringPainted(true);
		concentrationStu[3].setBounds(760, 500, 200, 40);
		concentrationStu[3].setBackground(Color.BLUE);
		
		concentrationStu[4] = new JProgressBar(0,100); 
		concentrationStu[4].setStringPainted(true);
		concentrationStu[4].setBounds(1020, 500, 180, 40);
		concentrationStu[4].setBackground(Color.BLUE);
		
		//프로그레스바 설정 스트레스
		stress = new JProgressBar(0,100); 
		stress.setBounds(0, 550, 1200, 50);
		stress.setBackground(Color.PINK);
		stress.setStringPainted(true);
		
		//라벨 설정 성취도글자
		achievementLabel = new JLabel("성취도: "); 
		achievementLabel.setBounds(400, 610, 400, 50);
		achievementLabel.setFont(new Font("맑은고딕", Font.BOLD, 30));
		
		//라벨 설정 성취도 값
		achivementCount = new JLabel(String.valueOf(achievement));
		achivementCount.setBounds(600, 610, 400, 50);
		achivementCount.setFont(new Font("맑은고딕", Font.BOLD, 30));
		
	}
	public JProgressBar setConcentrationStu1(){
		return concentrationStu[0];
	}
	public JProgressBar setConcentrationStu2(){
		return concentrationStu[1];
	}
	public JProgressBar setConcentrationStu3(){
		return concentrationStu[2];
	}
	public JProgressBar setConcentrationStu4(){
		return concentrationStu[3];
	}
	public JProgressBar setConcentrationStu5(){
		return concentrationStu[4];
	}
	public JProgressBar setStress(){
		return stress;
	}
	public JLabel setAchievementLabel(){
		return achievementLabel;
	}
	public JLabel setAchivementCount(){
		return achivementCount;
	}
	
}
