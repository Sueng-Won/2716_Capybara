package com.game.cording;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Quiz9 {
	static int time = 60;
	JProgressBar timeP; // 타이머 바
	JFrame frame;
	JPanel bar, quiz9; // 타이머 넣을 패널, 퀴즈,답안,버튼 넣을 패널
	Timer timer;
	JTextArea answerArea;
	boolean stopidx = false;
	TimeOut to = new TimeOut();
	IfCorrect ic = new IfCorrect();
	QuizManager quizManager = new QuizManager();

	public void quiz9() {
		// 문제 기본 프레임
		frame = new JFrame("Quiz9");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CardLayout card = new CardLayout();
		frame.setLayout(card);
		Font font = new Font("arian", Font.BOLD, 15);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stopidx = true;
			}

			@Override
			public void windowClosed(WindowEvent e) {
				stopidx = true;
			}
		});

		// 문제 9번 패널
		quiz9 = new JPanel();
		quiz9.setBackground(new Color(233, 221, 198));
		quiz9.setLayout(null);

		JTextArea textArea = new JTextArea();
		// 문제에 스크롤 추가
		JScrollPane scrollQ = new JScrollPane(textArea);

		scrollQ.setBounds(0, 30, 700, 370);

		textArea.setBounds(0, 30, 700, 370);
		textArea.setEditable(false);
		textArea.setBackground(new Color(233, 221, 198));

		quiz9.add(scrollQ);

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

		quiz9.add(bar);

		// 문제 읽어오는 경로
		File file = new File("CordingQuiz/Quiz9.txt");

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

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

		quiz9.add(scrollP);

		// 정답버튼 생성
		JButton answerBtn = new JButton();
		ImageIcon btnImg = new ImageIcon("CordingQuiz/OkayButton.png");
		answerBtn.setIcon(btnImg);
		answerBtn.setBounds(290, 605, 100, 50);
		quiz9.add(answerBtn);

		frame.add(quiz9);

		answerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (answerArea.getText().trim().equals("15")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					stopidx=true;
					ic.IfCorrect();
					quizManager.QuizManager();

				} else {
					JOptionPane.showMessageDialog(frame, "Wrong!");
					to.TimeOut();
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
					if (stopidx ==true) {
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				// 0초일때 게임 종료
//				if (answerArea.getText().trim().equals("15") && time == 0) {
//					break;
//				}

				if (time == 0) {
//					timeP.setValue(time);
					JOptionPane.showMessageDialog(frame, "시간 초과!");
					to.TimeOut();
					quizManager.QuizManager();
					frame.setVisible(false);
					break;
				}

				timeP.setValue(time);
			}
		}
	}
}
