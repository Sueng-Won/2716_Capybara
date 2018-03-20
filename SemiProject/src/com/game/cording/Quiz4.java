package com.game.cording;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Quiz4 {
	public void Quiz4(){

	      JFrame frame = new JFrame("Quiz4");
	      frame.setBounds(200, 200, 700, 700);
	      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	      Font font = new Font("arian", Font.BOLD, 15);

	      JButton jButton = new JButton("Check the answer!");
	      frame.add(jButton, "South");

	      JTextArea jTextArea = new JTextArea();
	      jTextArea.setFont(font);
	      jTextArea.setEditable(false);
	      jTextArea.setText("**다음 문장을 import선언하지 않고 사용할 수 있는 구문으로 변경하시오.**\n\n" +
	            "       import javja.util.Scanner;\n" +
	            "       Scanner sc = new Scanner(System.in);\n\n" +
	            "       _________________________________________\n" );

	      JTextArea jTextArea1 = new JTextArea();
	      jTextArea1.setBounds(0, 420, 680, 200);
	      jTextArea1.setBorder(new LineBorder(Color.BLACK, 3));
	      jTextArea1.setFont(font);

	      frame.add(jTextArea1, "Center");

	      frame.add(jTextArea, "Center");

	      jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			       if (jTextArea1.getText().trim().equals("java.util.Scanner sc = new java.util.Scanner(System.in);")){
		               JOptionPane.showMessageDialog(frame, "Correct!");
		               //마지막 문제 일 시 합산한 점수 팝업창 띄움
		               //점수 파일에 업데이트
		            }else {
		               JOptionPane.showMessageDialog(frame, "Wrong!");
		            }
				
			}
		});
	      frame.setVisible(true);
	   }

}
