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

public class Quiz7 {
	static int time = 60;
	JProgressBar timeP; // 타이머 바
	JFrame frame;
	JPanel bar, quiz7; // 타이머 넣을 패널, 퀴즈,답안,버튼 넣을 패널
	Timer timer;
	JTextArea answerArea;
	JTextArea quizArea;
	String finalAnswer;
	boolean stopidx = false;
	TimeOut to = new TimeOut();
	IfCorrect ic = new IfCorrect();
	QuizManager quizManager = new QuizManager();

	public void quiz7() {

		frame = new JFrame("Quiz7");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CardLayout card = new CardLayout();
		Font font = new Font("arian", Font.BOLD, 15);
		frame.setLayout(card);
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

		// 문제 6번 패널
		quiz7 = new JPanel();
		quiz7.setBackground(new Color(233, 221, 198));
		quiz7.setLayout(null);

		// 퀴즈띄울 공간 생성
		quizArea = new JTextArea();
		quizArea.setFont(font);
		quizArea.setEditable(false);
		quizArea.setBounds(0, 30, 700, 370);
		quizArea.setBackground(new Color(233, 221, 198));

		quiz7.add(quizArea);

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

		quiz7.add(bar);

		// 정답버튼 생성
		JButton answerBtn = new JButton();
		ImageIcon btnImg = new ImageIcon("CordingQuiz/OkayButton.png");
		answerBtn.setIcon(btnImg);
		answerBtn.setBounds(290, 605, 100, 50);
		quiz7.add(answerBtn);

		// 문제 읽어오는 경로
		File file = new File("CordingQuiz/Quiz7.txt");
		String ls = "\n";

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = null;
			StringBuilder stringBuilder = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
				quizArea.setText(stringBuilder.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 답안 읽어오는 경로
		File file2 = new File("CordingQuiz/Q7Answer.txt");
		String answer = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {

			String line = null;
			StringBuilder stringBuilder = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
				answer = stringBuilder.toString();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		finalAnswer = answer;

		// 답안 공간 생성
		answerArea = new JTextArea();

		// 스크롤 추가
		JScrollPane scrollP = new JScrollPane(answerArea);
		scrollP.setBounds(0, 420, 680, 180);

		answerArea.setBorder(new LineBorder(Color.BLACK, 3));
		answerArea.setFont(font);
		answerArea.setLineWrap(true);

		quiz7.add(scrollP);

		frame.add(quiz7);

		frame.setVisible(true);

		answerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (answerArea.getText().trim().equals(finalAnswer.trim())) {
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
		timer = new Timer();
		timer.start();

	}

	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000); // 1초
					if (stopidx == true) {
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				// 0초일때 게임 종료
				if (answerArea.getText().trim().equals(finalAnswer.trim())) {
					break;
				}
				else	if (time == 0) {
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
