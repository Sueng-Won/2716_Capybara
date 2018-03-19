package com.game.textquiz;


import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class check {

	public static void main(String[] args) {
		JFrame frame = new JFrame("체크 박스 연습");
		frame.setBounds(200, 200, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);
		JLabel aLabel = new JLabel();
		aLabel.setText("다음 설명 중 틀린 것을 고르시오.");
		aLabel.setBounds(30,20,250,50);
//		JTextArea chatArea = new JTextArea(30,50);
//		chatArea.setText(" ");
//		chatArea.setEditable(false);
//		chatArea.setBounds(30,20,220,120);

		
		JRadioButton check1 = new JRadioButton("answer1");
		check1.setBounds(30,160,250,30);
		
		JRadioButton check2 = new JRadioButton("answer2");
		check2.setBounds(30,190,150,30);

		JRadioButton check3 = new JRadioButton("answer3");
		check3.setBounds(30,220,150,30);

		JRadioButton check4 = new JRadioButton("answer4");
		check4.setBounds(30,250,150,30);
		
		JButton Btn = new JButton("정답 확인");
		Btn.setBounds(100,300,100,30);

		ButtonGroup btnGroup = new ButtonGroup();

		
		btnGroup.add(check1);
		btnGroup.add(check2);
		btnGroup.add(check3);
		btnGroup.add(check4);
		
		frame.add(aLabel);
		
		frame.add(check1);
		frame.add(check2);
		frame.add(check3);
		frame.add(check4);
		frame.add(Btn);
//		frame.add(chatArea);
		frame.setVisible(true);
		
		
		
		

	}

}
