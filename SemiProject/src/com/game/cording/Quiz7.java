package com.game.cording;


import javax.swing.*;
import javax.swing.border.LineBorder;

import com.game.cording.Quiz6.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Quiz7 {
	static int time = 60;
	JProgressBar timeP; // 타이머 바
	JFrame frame;
	JPanel bar;
	Timer timer;
	JTextArea answerArea;
	String finalAnswer;
	
	
	public void Quiz7() {

		JFrame frame = new JFrame("Quiz7");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Font font = new Font("arian", Font.BOLD, 15);
		frame.setLayout(null);
		
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
		//바에 타이머바 삽입
		frame.add(bar);

		//정답 버튼 생성
		JButton jButton = new JButton("Check the answer!");
		jButton.setBounds(290, 605, 100, 50);
		frame.add(jButton);

		//퀴즈 띄울 공간 생성
		JTextArea quizArea = new JTextArea();
		quizArea.setFont(font);
		quizArea.setEditable(false);
		quizArea.setBounds(0, 30, 700, 370);
		quizArea.setBackground(new Color(238, 238, 238));
		frame.add(quizArea);

		//퀴즈 읽어오는 경로
		File file = new File("Quiz7.txt");
		String ls = "\n";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			
			while ((line = reader.readLine()) != null){
				stringBuilder.append(line);
				stringBuilder.append(ls);
				quizArea.setText(stringBuilder.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//답안 읽어오는 경로
		File file2 = new File("Q7Answer.txt");
		String answer = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file2));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();

			while ((line = reader.readLine()) != null){
				stringBuilder.append(line);
				stringBuilder.append(ls);
				answer = stringBuilder.toString();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String finalAnswer = answer;

		
		//스크롤 추가
		JScrollPane scrollP = new JScrollPane(answerArea);
		scrollP.setBounds(0, 420, 680, 180);

		answerArea.setBorder(new LineBorder(Color.BLACK, 3));
		answerArea.setFont(font);
		answerArea.setLineWrap(true);

		frame.add(scrollP);
		frame.setVisible(true);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerArea.getText().trim().equals(finalAnswer.trim())) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					int rnum = (int)(Math.random() * 3) + 8;
					if (rnum == 8){
						Quiz8 q8 = new Quiz8();
						q8.Quiz8();
					}else if (rnum == 9){
						Quiz9 q9 = new Quiz9();
						q9.Quiz9();
					}else if (rnum == 10){
						Quiz10 q10 = new Quiz10();
						q10.Quiz10();
					}
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
				if(answerArea.getText().trim().equals(finalAnswer.trim())){
					break;
				}
				// 0초일때 게임 종료
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
