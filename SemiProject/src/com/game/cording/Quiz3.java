package com.game.cording;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Quiz3 {
	static int time = 60;
	JProgressBar timeP; // 타이머 바
	JFrame frame;
	JPanel bar, quiz3; // 타이머 넣을 패널,   퀴즈,답안,버튼 넣을 패널
	Timer timer;
	JTextArea answerArea;

	public void quiz3() {
		//문제 기본 프레임
		JFrame frame = new JFrame("Quiz3");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CardLayout card = new CardLayout();
		frame.setLayout(card);
		Font font = new Font("arian", Font.BOLD, 15);

		//문제 3번 패널
		quiz3 = new JPanel();
		quiz3.setBackground(new Color(233, 221, 198));
		quiz3.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 30, 700, 370);
		textArea.setEditable(false);
		textArea.setBackground(new Color(233, 221, 198));
		
		quiz3.add(textArea);
		
		// 타이머 바 넣을 공간 생성
		bar = new JPanel();
		bar.setLayout(null);
		bar.setBounds(0, 0, 700, 30);

		// 바에 타이머바 삽입
		bar.add(timeP = new JProgressBar(0, time));

		// 타이머 바 정보
		timeP.setValue(time);
		timeP.setForeground(Color.DARK_GRAY);
		timeP.setBorderPainted(false);
		timeP.setBounds(0, 0, 700, 30);
		
		quiz3.add(bar);

		//문제 읽어오는 경로
		File file = new File("CordingQuiz/Quiz3.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
				textArea.setText(stringBuilder.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 답쓰는 공간
		answerArea = new JTextArea();

		JScrollPane scrollP = new JScrollPane(answerArea);
		scrollP.setBounds(0, 420, 680, 180);
		answerArea.setBounds(0, 420, 680, 180);
		answerArea.setBorder(new LineBorder(Color.BLACK, 3));
		answerArea.setFont(font);
		answerArea.setLineWrap(true);

		quiz3.add(scrollP);
		quiz3.add(textArea);

		// 정답버튼 생성
		JButton answerBtn = new JButton("OK!");
		answerBtn.setBounds(290, 605, 100, 50);
		quiz3.add(answerBtn);
		
		frame.add(quiz3);

		answerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (answerArea.getText().trim().equals("sum += arr[i];")||answerArea.getText().trim().equals("sum = sum + arr[i];")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong!");
				}
			}
		});

		frame.setVisible(true);
		timer = new Timer();
		timer.start();
	}

	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000); // 1초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				// 0초일때 게임 종료
				if (answerArea.getText().trim().equals("frame") && time == 0) {
					break;
				}

				if (time == 0) {
					timeP.setValue(time);
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					System.exit(0);
					break;
				}

				timeP.setValue(time);
			}
		}
	}
}
