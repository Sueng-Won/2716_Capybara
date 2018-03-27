package com.game.textquiz;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.game.textquiz.MainFrame.Timer;





public class Quiz01 extends JPanel{
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	
	
	

	public Quiz01(QuizPanel p){
		
		MainFrame m = MainFrame(); 
		P = p;
		m.time =20;
	setLayout(null);
	qLabel = new JLabel();
	qLabel.setText("다음 중 기본형(primitive type)이 아닌 것은?");
	qLabel.setBounds(30, 70, 450, 50);
	
	
	
	JRadioButton check1 = new JRadioButton
			("1. int");
	check1.setBounds(30, 160, 450, 30);
	
	JRadioButton check2 = new JRadioButton
			("2. Byte");
	check2.setBounds(30,190,450,30);
	
	JRadioButton check3 = new JRadioButton
			("3. double");
	check3.setBounds(30,220,450,30);

	JRadioButton check4 = new JRadioButton
			("4. boolean");
	check4.setBounds(30,250,450,30);
	
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
			
			
            if(check2.isSelected()){
            	
            	m.wait = true; // 타임 감소 멈춤
            	JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
						JOptionPane.INFORMATION_MESSAGE);
            	P.pointBo = true;
            	P.changePanel();
            	
			}else if(check1.isSelected()||check3.isSelected()||check4.isSelected()){
				
				m.wait = true;
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
	



	


