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

public class Quiz6 {

	public static void main(String[] args) {
		
		Font f1 = new Font("맑은 고딕",Font.BOLD, 13);

		JFrame frame = new JFrame("Quiz");
		frame.setBounds(200, 200, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
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
		
		frame.setVisible(true);
		
		
		
		

	}

}