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
public class Quiz3 {
	public void Quiz3() {
		JFrame frame = new JFrame("Quiz3");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font = new Font("arian", Font.BOLD, 15);

		JButton jButton = new JButton("Check the answer!");
		frame.add(jButton, "South");

		JTextArea jTextArea = new JTextArea();
		jTextArea.setFont(font);
		jTextArea.setEditable(false);
		jTextArea.setText("**Enter the Correct code in the Blank**\n\n" + 
		"배열 array에 담긴 모든 값을 더하는 프로그램을 완성하시오 .\n\n"+" public static void main(String[]args){\n"
				+ "     int[][ arr = {10,20,30,40,50};\n" + "     int sum=0;\n"
				+ "     for (int i = 0; i < arr.length; i++) {\n" + "     ____________________\n"
				+ "     }\n" 	+ "     System.out.println(\"sum=\"+sum);\n" + "   }\n" + " }\n" 
		);

		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(0, 420, 680, 200);
		jTextArea1.setBorder(new LineBorder(Color.BLACK, 3));
		jTextArea1.setFont(font);

		frame.add(jTextArea1, "Center");

		frame.add(jTextArea, "Center");

		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jTextArea1.getText().trim().equals("sum+=arr[i];")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					Quiz4 q4 =new Quiz4();
					q4.Quiz4();
				} 
				else if(jTextArea1.getText().trim().equals("sum=sum+arr[i];")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					Quiz4 q4 =new Quiz4();
					q4.Quiz4();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Wrong!");
				}
			}
		});
		frame.setVisible(true);

	}
}
