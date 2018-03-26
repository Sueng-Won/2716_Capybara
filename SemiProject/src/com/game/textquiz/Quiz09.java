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


public class Quiz09 extends JPanel{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	
	boolean stop = false;
	
	

	public Quiz09(QuizPanel p){
		
		MainFrame m = MainFrame();
		P = p;
		m.time =20;
		setLayout(null);
		qLabel = new JLabel();
		qLabel.setText("다음 중 인터페이스에 대한 설명으로 옳지 않은 것은?");
		qLabel.setBounds(30,70,400,50);

		
		JRadioButton check1 = new JRadioButton
				("1. 표준화를 가능하게 해준다.");
		check1.setBounds(30,160,400,30);
		
		JRadioButton check2 = new JRadioButton
				("2. 서로 관계없는 클래스들에게 관계를 맺어줄수 있다.");
		check2.setBounds(30,190,450,30);
		
		JRadioButton check3 = new JRadioButton
				("3. 패키지간의 연결을 도와준다.");
		check3.setBounds(30,220,400,30);

		JRadioButton check4 = new JRadioButton
				("4. 다중상속을 가능하게 해준다.");
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
		            	P.pointBo = true;
		            	P.changePanel();
		            	
					}else if(check1.isSelected()||check2.isSelected()||check4.isSelected()){
							
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);
						stop = true;
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
