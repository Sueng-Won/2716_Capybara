package com.game.cording;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

		File file = new File("Quiz3.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null){
				stringBuilder.append(line);
				stringBuilder.append(ls);

				jTextArea.setText(stringBuilder.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

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

