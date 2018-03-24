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


public class Quiz07 extends JPanel{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	
	boolean stop = false;
	
	

	public Quiz07(QuizPanel p){
		
		MainFrame m = MainFrame();
		P = p;
		
		setLayout(null);
		qLabel = new JLabel();
		JLabel qLabel = new JLabel();
		qLabel.setText(" 다음 중 지역변수에 대한 설명으로 옳지 않은 것은?");
		qLabel.setBounds(30,70,400,50);

		
		JRadioButton check1 = new JRadioButton
				("1. 스택(stack)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.");
		check1.setBounds(30,160,400,30);
		
		JRadioButton check2 = new JRadioButton
				("2. 지역변수가 선언된 메소드가 종료되면 지역변수도 함께 소멸된다.");
		check2.setBounds(30,190,450,30);
		
		JRadioButton check3 = new JRadioButton
				("3. 메소드의 매개변수로 선언된 변수도 지역변수이다.");
		check3.setBounds(30,220,400,30);

		JRadioButton check4 = new JRadioButton
				("4. 자동 초기화되므로 별도의 초기화가 필요없다.");
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
					
					
		            
		            if(check4.isSelected()){
					
		            	JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);
		            	stop = true;
		            	m.time =20;
		            	P.changePanel();
		            	
					}else if(check1.isSelected()||check3.isSelected()||check2.isSelected()){
							
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
