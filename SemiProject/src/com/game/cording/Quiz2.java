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

public class Quiz2 {
	public void Quiz2() {
		JFrame frame = new JFrame("Quiz2");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font = new Font("arian", Font.BOLD, 15);

		JButton jButton = new JButton("Check the answer!");
		frame.add(jButton, "South");

		JTextArea jTextArea = new JTextArea();
		jTextArea.setFont(font);
		jTextArea.setEditable(false);
		jTextArea.setText("**Enter the Correct code in the Blank**\n\n" + " public void Dan(){\n"
				+ "\tint[][] intArr = new int[10][10];\n" + "\tfor (int i = 2; i < intArr.length; i++) {\n"
				+ "\t\tfor (int j = 1; j < ________________; j++) {\n" + "\t\t\tintArr[i][j] = i * j;\n"
				+ "\t\t\tSystem.out.print(i + \"*\" + j + \"=\" + intArr[i][j] + \"\\t\");\n" + "\t\t\tif (j == 9){\n"
				+ "\t\t\tSystem.out.println(\"\");\n" + "\t\t\t}\n" + "\t\t}\n" + "\t}\n" + "}"

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
				if (jTextArea1.getText().trim().equals("intArr[i].length")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					Quiz3 q3 =new Quiz3();
					q3.Quiz3();
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong!");
				}
			}
		});
		frame.setVisible(true);

	}
}
