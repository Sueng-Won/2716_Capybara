package com.game.cording;

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
	JPanel bar;
	Timer timer;
	JTextArea answerArea;
	

	public void Quiz3() {

		//문제창 기본 프레임
		frame = new JFrame("Quiz3");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(null);
		Font font = new Font("arian", Font.BOLD, 15);

		//타이머 바 넣을 공간 생성
		bar = new JPanel();
		bar.setLayout(null);
		bar.setBounds(0, 0, 700, 30);

		//바에 타이머바 삽입
		bar.add(timeP = new JProgressBar(0,time));
		
		//타이머 바 정보
		timeP.setValue(time);
		timeP.setForeground(Color.DARK_GRAY);
		timeP.setBorderPainted(false);
		timeP.setBounds(0, 0, 700, 30);

		frame.add(bar);
		
		//정답버튼 생성
		JButton answerBtn = new JButton("OK!");
		frame.add(answerBtn);
		answerBtn.setBounds(290, 605, 100, 50);

		//퀴즈띄울 공간 생성
		JTextArea quizArea = new JTextArea();
		quizArea.setBounds(0, 30, 700, 370);
		quizArea.setFont(font);
		quizArea.setEditable(false);
		quizArea.setBackground(new Color(238, 238, 238));
		frame.add(quizArea);


		//문제 파일로 읽어오기
		File file = new File("Quiz3.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
				quizArea.setText(stringBuilder.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		//답안 공간 생성
		answerArea = new JTextArea();
		
		JScrollPane scrollP = new JScrollPane(answerArea);
		scrollP.setBounds(0, 420, 680, 180);

		answerArea.setBorder(new LineBorder(Color.BLACK, 3));
		answerArea.setFont(font);
		answerArea.setLineWrap(true);

		frame.add(scrollP);
		//답안버튼 클릭시 발생하는 이벤트
		answerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerArea.getText().trim().equals("sum += arr[i];")||answerArea.getText().trim().equals("sum = sum + arr[i];")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					//랜덤으로 다음문제 제출
					int rnum = (int) (Math.random() * 7) + 4;
					if (rnum == 4) {
						Quiz4 q4 = new Quiz4();
						q4.Quiz4();
					} else if (rnum == 5) {
						Quiz5 q5 = new Quiz5();
						q5.Quiz5();
					} else if (rnum == 6) {
						Quiz6 q6 = new Quiz6();
						q6.Quiz6();
					} else if (rnum == 7) {
						Quiz7 q7 = new Quiz7();
						q7.Quiz7();
					} else if (rnum == 8) {
						Quiz8 q8 = new Quiz8();
						q8.Quiz8();
					} else if (rnum == 9) {
						Quiz9 q9 = new Quiz9();
						q9.Quiz9();
					} else if (rnum == 10) {
						Quiz10 q10 = new Quiz10();
						q10.Quiz10();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong!");
				}

			}
		});
		frame.setVisible(true);
		//타이머 바 호출
		timer = new Timer();
		timer.start();

	}

	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000); //1초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				if(answerArea.getText().trim().equals("sum += arr[i];")||answerArea.getText().trim().equals("sum = sum + arr[i];")){
					break;
				}
				//0초일때 게임 종료
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

