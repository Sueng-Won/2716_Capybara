package com.game.textquiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;


public class Quiz08 extends JPanel{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	
	boolean stop = false;
	
	

	public Quiz08(QuizPanel p){
		
		MainFrame m = MainFrame();
		P = p;
		
		setLayout(null);
		qLabel = new JLabel();
		qLabel.setText("자바의 상속 특징 중에서 틀린 것은?");
		qLabel.setBounds(30,70,400,50);

		
		JRadioButton check1 = new JRadioButton
				("1. 클래스의 다중 상속을 지원하지 않는다.");
		check1.setBounds(30,160,400,30);
		
		JRadioButton check2 = new JRadioButton
				("2. 상속의 횟수에 제한이 없다.");
		check2.setBounds(30,190,400,30);
		
		JRadioButton check3 = new JRadioButton
				("3. 모든 클래스의 최상위 슈퍼 클래스는 java.lang.System 클래스이다.");
		check3.setBounds(30,220,450,30);

		JRadioButton check4 = new JRadioButton
				("4. 상속을 표현하는 키워드는 extends이다.");
		check4.setBounds(30,250,400,30);
		
		ButtonGroup btnGroup = new ButtonGroup();
	
		btnGroup.add(check1);
		btnGroup.add(check2);
		btnGroup.add(check3);
		btnGroup.add(check4);
		
		
		
		Btn = new JButton("정답 확인");
		Btn.setBounds(100,300,100,30);
	
		Btn.addActionListener(new ActionListener() {
				
				
				@Override
		        public void actionPerformed(ActionEvent arg0) {
					
					JLabel messageLabel1 = new JLabel("정답입니다.");   // AnswerMessage 화면에 표시될 내용
					JLabel messageLabel2 = new JLabel("틀렸습니다.");
					messageLabel1.setFont(f1);
					messageLabel2.setFont(f1);
					
					
		            
		            if(check3.isSelected()){
					
		            	JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);
		            	stop = true;
		            	m.time =20;
		            	P.changePanel();
		            	
					}else if(check1.isSelected()||check2.isSelected()||check4.isSelected()){
							
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);
						stop = true;
						m.time =20;
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
