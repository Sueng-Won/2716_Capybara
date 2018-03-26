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
import javax.swing.JTextArea;


public class Quiz04 extends JPanel{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	
	boolean stop = false;
	
	

	public Quiz04(QuizPanel p){
		
		MainFrame m = MainFrame();
		P = p;
		m.time =20;
		setLayout(null);
		qLabel = new JLabel();
		qLabel.setText("다음 괄호 안에 들어갈 명칭으로 알맞은 것은?");
		qLabel.setBounds(30,10,300,50);
		JTextArea textArea = new JTextArea(30,50);
		textArea.setText
			("  사용할 클래스가 속한 패키지를 지정하는데 사용.\n"+
				"  (  )문을 사용하면 클래스를 사용할 때 패키지명을 생략.\n"+
				"  java.lang 패키지의 클래스는 JVM이 자동으로 (  )함.\n"+
				"  사용자가 (  )할 필요없음.(String, Object, System…) ");
		textArea.setEditable(false);
		textArea.setBounds(30,65,300,70);
		
		
		JRadioButton check1 = new JRadioButton
				("1. interface");
		check1.setBounds(30,160,250,30);
		
		JRadioButton check2 = new JRadioButton
				("2. abstract");
		check2.setBounds(30,190,350,30);
		
		JRadioButton check3 = new JRadioButton
				("3. extends");
		check3.setBounds(30,220,450,30);

		JRadioButton check4 = new JRadioButton
				("4. import");
		check4.setBounds(30,250,350,30);
		
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
					
					
		            
		            if(check4.isSelected()){
					
		            	JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);
		            	stop = true;
		            	P.pointBo = true;
		            	P.changePanel();
		            	
					}else if(check1.isSelected()||check3.isSelected()||check2.isSelected()){
							
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
		add(textArea);
	
	setVisible(true);
	
	}



	private MainFrame MainFrame() {
		return null;
	}



	
	
	
}
