package com.game.textquiz.question;


import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Quiz3 {

	public static void main(String[] args) {
		
		Font f1 = new Font("맑은 고딕",Font.BOLD, 13);

		JFrame frame = new JFrame("Quiz");
		frame.setBounds(200, 200, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		JLabel qLabel = new JLabel();
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
		
		JButton Btn = new JButton("정답 확인");
		Btn.setBounds(100,300,100,30);
		
		Btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(check4.isSelected()){
					frame.setVisible(false);
					JFrame frame2 = new JFrame("answer");
					frame2.setBounds(300, 300, 200, 120);
					frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame2.setLayout(null);
					frame2.setResizable(false);
					JLabel aLabel = new JLabel();
					aLabel.setText("정답입니다!!");
					aLabel.setFont(f1);
					aLabel.setBounds(55,-5,100,100);
					frame2.add(aLabel);
					frame2.setVisible(true);
					
				}else if(check1.isSelected()||check2.isSelected()||check3.isSelected()){
						frame.setVisible(false);
						JFrame frame2 = new JFrame("Answer");
						frame2.setBounds(300, 300, 200, 120);
						frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame2.setLayout(null);
						frame2.setResizable(false);
						JLabel aLabel = new JLabel();
						aLabel.setText("틀렸습니다.");
						aLabel.setFont(f1);
						aLabel.setBounds(55,-5,100,100);
						frame2.add(aLabel);
						frame2.setVisible(true);

				}
				
			}
		});
		
		qLabel.setFont(f1);
		check1.setFont(f1);
		check2.setFont(f1);
		check3.setFont(f1);
		check4.setFont(f1);
		Btn.setFont(f1);

		ButtonGroup btnGroup = new ButtonGroup();

		
		btnGroup.add(check1);
		btnGroup.add(check2);
		btnGroup.add(check3);
		btnGroup.add(check4);
		
		frame.add(qLabel);

		
		frame.add(check1);
		frame.add(check2);
		frame.add(check3);
		frame.add(check4);
		frame.add(Btn);
		frame.add(textArea);

		frame.setVisible(true);
		
		
		
		

	}

}
