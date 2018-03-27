package com.game.textquiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;


public class Quiz05 extends JPanel{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	

	public Quiz05(QuizPanel p){
		
		MainFrame m = MainFrame();
		P = p;
		m.time =20;
		setLayout(null);
		qLabel = new JLabel();
		qLabel.setText("다음은 자바의 예외 처리에 대한 설명이다. 틀린 것은?");
		qLabel.setBounds(30,70,400,50);

		
		JRadioButton check1 = new JRadioButton
				("1. 모든 메소드 마다 예외의 유형을 정의하여야 한다.");
		check1.setBounds(30,160,400,30);
		
		JRadioButton check2 = new JRadioButton
				("2. finally문은 생략 가능하다.");
		check2.setBounds(30,190,400,30);
		
		JRadioButton check3 = new JRadioButton
				("3. try~catch~finally 문에 여러 개의 catch문이 올 수 있다.");
		check3.setBounds(30,220,400,30);

		JRadioButton check4 = new JRadioButton
				("4. 지정하지 않은 예외는 디폴트 예외 처리기가 처리한다.");
		check4.setBounds(30,250,400,30);
		
		ButtonGroup btnGroup = new ButtonGroup();
	
		btnGroup.add(check1);
		btnGroup.add(check2);
		btnGroup.add(check3);
		btnGroup.add(check4);
		
		
		
		Btn = new JButton();
		ImageIcon btnImg = new ImageIcon("CordingQuiz/OkayButton.png");
		Btn.setIcon(btnImg);
		
		Btn.setBounds(100,300,100,50);
	
		Btn.addActionListener(new ActionListener() {
				
				
				@Override
		        public void actionPerformed(ActionEvent arg0) {
					
					JLabel messageLabel1 = new JLabel("정답입니다.");   // AnswerMessage 화면에 표시될 내용
					JLabel messageLabel2 = new JLabel("틀렸습니다.");
					messageLabel1.setFont(f1);
					messageLabel2.setFont(f1);
					m.wait = true;
					
		            
		            if(check1.isSelected()){
		            	JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);
		            	P.pointBo = true;
		            	P.changePanel();
		            	
					}else if(check2.isSelected()||check3.isSelected()||check4.isSelected()){
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);
						P.pointBo = false;
						P.changePanel();
						
					}
					
		        }
		    });
		
		check1.setBackground(new Color(233, 221, 198));
		check2.setBackground(new Color(233, 221, 198));
		check3.setBackground(new Color(233, 221, 198));
		check4.setBackground(new Color(233, 221, 198));
		
		setBackground(new Color(233, 221, 198));

		qLabel.setFont(f1);
		check1.setFont(f1);
		check2.setFont(f1);
		check3.setFont(f1);
		check4.setFont(f1);
		Btn.setFont(f1);
	
		add(qLabel);
		add(check1);
		add(check2);
		add(check3);
		add(check4);
		add(Btn);
		
	
	setVisible(true);
	
	}



	private MainFrame MainFrame() {
		return null;
	}



	
	
	
}
