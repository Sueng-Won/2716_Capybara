package com.global.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import com.game.cording.QuizManager;

public class StudentVo{
	private JProgressBar concentrationStu[] = new JProgressBar[5];
	private JProgressBar stress;
	private JLabel achievementLabel;
	private JLabel achivementCount;
	private int achievement=0;
	QuizManager qm = new QuizManager();
	
	public StudentVo(){
		//테두리디자인
	    UIManager.put("ProgressBar.border", BorderFactory.createLineBorder(new Color(251,174,23), 3));
		//프로그레스바 설정 집중력
		concentrationStu[0] = new JProgressBar(0,100); 
		concentrationStu[0].setStringPainted(true);
		concentrationStu[0].setBounds(20, 500, 200, 40);
		concentrationStu[0].setBackground(new Color(255,0,0,0));
		concentrationStu[0].setForeground(new Color(251,174,23));

		
		concentrationStu[1] = new JProgressBar(0,100); 
		concentrationStu[1].setStringPainted(true);
		concentrationStu[1].setBounds(260, 500, 200, 40);
		concentrationStu[1].setBackground(new Color(255,0,0,0));
		concentrationStu[1].setForeground(new Color(251,174,23));
		
		concentrationStu[2] = new JProgressBar(0,100); 
		concentrationStu[2].setStringPainted(true);
		concentrationStu[2].setBounds(500, 500, 200, 40);
		concentrationStu[2].setBackground(new Color(255,0,0,0));
		concentrationStu[2].setForeground(new Color(251,174,23));
		
		concentrationStu[3] = new JProgressBar(0,100);
		concentrationStu[3].setStringPainted(true);
		concentrationStu[3].setBounds(740, 500, 200, 40);
		concentrationStu[3].setBackground(new Color(255,0,0,0));
		concentrationStu[3].setForeground(new Color(251,174,23));
		
		concentrationStu[4] = new JProgressBar(0,100); 
		concentrationStu[4].setStringPainted(true);
		concentrationStu[4].setBounds(980, 500, 200, 40);
		concentrationStu[4].setBackground(new Color(255,0,0,0));
		concentrationStu[4].setForeground(new Color(251,174,23));
		
		for(int i =0; i<concentrationStu.length; i++){
			concentrationStu[i].setValue(100);
		}
		
		
		
		//프로그레스바 설정 스트레스
		UIManager.put("ProgressBar.border", BorderFactory.createLineBorder(new Color(232,74,95), 3));
		stress = new JProgressBar(0,100); 
		stress.setBounds(0, 550, 1200, 50);
		stress.setBackground(new Color(255,0,0,0));
		stress.setForeground(new Color(232,74,95));
		stress.setStringPainted(true);
		stress.setValue(0);
	
		
		
		//라벨 설정 성취도글자
		achievementLabel = new JLabel("성취도: "); 
		achievementLabel.setBounds(400, 610, 400, 50);
		achievementLabel.setFont(new Font("맑은고딕", Font.BOLD, 30));
		
		//라벨 설정 성취도 값
//		achievement+=qm.value[6];
		
		achivementCount = new JLabel(String.valueOf(achievement));
		achivementCount.setBounds(600, 610, 400, 50);
		achivementCount.setFont(new Font("맑은고딕", Font.BOLD, 30));
		
	}
	public JProgressBar getConcentrationStu1(){
		return concentrationStu[0];
	}
	public JProgressBar getConcentrationStu2(){
		return concentrationStu[1];
	}
	public JProgressBar getConcentrationStu3(){
		return concentrationStu[2];
	}
	public JProgressBar getConcentrationStu4(){
		return concentrationStu[3];
	}
	public JProgressBar getConcentrationStu5(){
		return concentrationStu[4];
	}
	
	public void stressV(int stress){
		this.stress.setValue(stress);
	}
	public JProgressBar setStress() {
		return stress;
	}
	public int getStress() {
		return stress.getValue();
	}
	public JLabel setAchievementLabel(){
		return achievementLabel;
	}
	public JLabel setAchivementCount(){
		return achivementCount;
	}
	public void setAchievement(int achievement){
		this.achievement = achievement;
	}
	public int getAchievement(int achievement){
		return this.achievement;
	}

	public int getAchievement(){
		return achievement;
	}
	public void setAchivementCountValue(int value){
		this.achievement +=value;
		this.achivementCount.setText(String.valueOf(this.achievement));
	}
	
	public void addValueAll(int[] value) {
		this.concentrationStu[0].setValue(this.concentrationStu[0].getValue()+value[0]);
		this.concentrationStu[1].setValue(this.concentrationStu[1].getValue()+value[1]);
		this.concentrationStu[2].setValue(this.concentrationStu[2].getValue()+value[2]);
		this.concentrationStu[3].setValue(this.concentrationStu[3].getValue()+value[3]);
		this.concentrationStu[4].setValue(this.concentrationStu[4].getValue()+value[4]);
		this.stress.setValue(this.stress.getValue()+value[5]);
		this.achievement += value[6];
		this.achivementCount.setText(String.valueOf(this.achievement));
	}
	
	public void randomLocation(int[] location) {
		for(int i = 0 ;i<concentrationStu.length;i++) {
			this.concentrationStu[i].setBounds(location[i], 500, 200, 40);
		}
	}
}

