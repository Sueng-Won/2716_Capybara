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
import javax.swing.JTextArea;


public class Quiz10 extends JPanel{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private JLabel qLabel;
	private JButton Btn;
	private QuizPanel P;
	
	

	public Quiz10(QuizPanel p){
		
		MainFrame m = MainFrame();
		P = p;
		m.time =20;
		setLayout(null);
		qLabel = new JLabel();
		qLabel.setText("다음 내용은 무엇에 관한 설명인가?");
		qLabel.setBounds(30,10,300,50);
		JTextArea textArea = new JTextArea(30,50);
		textArea.setText
			("  텍스트 파일로부터 Character 단위로 저장할 때 사용하는\n"+
			 "  스트림 클래스. 텍스트가 아닌 그림 오디오, 비디오 등의\n"+
				"  파일은 저장할 수 없다."
				);
		textArea.setEditable(false);
		textArea.setBounds(30,65,320,70);

		
		JRadioButton check1 = new JRadioButton
				("1. FileIntputStream");
		check1.setBounds(30,160,250,30);
		
		JRadioButton check2 = new JRadioButton
				("2. FileWriter");
		check2.setBounds(30,190,350,30);
		
		JRadioButton check3 = new JRadioButton
				("3. FileReader");
		check3.setBounds(30,220,450,30);

		JRadioButton check4 = new JRadioButton
				("4. BufferedWriter");
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

					m.wait = true;

		            
		            if(check2.isSelected()){
					
		            	JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);
		            	P.pointBo = true;
		            	P.changePanel();
		            	
					}else if(check1.isSelected()||check3.isSelected()||check4.isSelected()){
							
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
		add(textArea);
	
	setVisible(true);
	
	}



	private MainFrame MainFrame() {
		return null;
	}



	
	
	
}
