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

public class Quiz1 {
	public void Quiz1() {

		JFrame frame = new JFrame("Quiz1");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font = new Font("arian", Font.BOLD, 15);

		JButton jButton = new JButton("Check the answer!");
		frame.add(jButton, "South");

		JTextArea jTextArea = new JTextArea();
		jTextArea.setFont(font);
		jTextArea.setEditable(false);
		jTextArea.setText("**Enter the Correct code in the Blank**\n\n" + "public class Main {\n" + "\n"
				+ "    public static void main(String[] args) {\n" + "        JFrame frame = new JFrame(\"Test\");\n"
				+ "        frame.setBounds(200, 200, 300, 300);\n" + "        frame.setVisible(true);\n"
				+ "        _____.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);\n" + "\n"
				+ "        JButton jButton = new JButton(\"ok!\");\n" + "        frame.add(jButton, \"South\");\n"
				+ "\n" + "        JTextArea jTextArea = new JTextArea();\n" + "        jTextArea.setText(\"\");\n"
				+ "        frame.add(jTextArea, \"Center\");\n" + "\n" + "\n" + "    }\n" + "}");

		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(0, 420, 680, 200);
		jTextArea1.setBorder(new LineBorder(Color.BLACK, 3));
		jTextArea1.setFont(font);

		frame.add(jTextArea1, "Center");

		frame.add(jTextArea, "Center");

		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jTextArea1.getText().trim().equals("frame")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					Quiz2 q2 =new Quiz2();
					q2.Quiz2();
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong!");
				}
				
			}
		});
		frame.setVisible(true);
	}
}
