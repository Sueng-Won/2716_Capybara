package com.game.cording;

import java.awt.*;
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

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Quiz1 {
	static int time = 60;
	JProgressBar timeP; // 타이머 바
	JFrame frame;
	JPanel bar, quiz1; // 타이머 넣을 패널,   퀴즈,답안,버튼 넣을 패널
	Timer timer;
	JTextArea answerArea;
	int stopidx=0;
	int[] value = { 0, 0, 0, 0, 0, 0, 0 }; // 값을 반환하는 정수배열 5번째는 피로도, 6번째는 성취도

	public void quiz1() {
		//문제 기본 프레임
		frame = new JFrame("Quiz1");
		frame.setBounds(200, 200, 700, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CardLayout card = new CardLayout();
		frame.setLayout(card);
		Font font = new Font("arian", Font.BOLD, 15);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stopidx = -1;
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
		});
		
		

		//문제 1번 패널
		quiz1 = new JPanel();
		quiz1.setBackground(new Color(233, 221, 198));
		quiz1.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 30, 700, 370);
		textArea.setEditable(false);
		textArea.setBackground(new Color(233, 221, 198));
		
		quiz1.add(textArea);
		
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
		
		quiz1.add(bar);

		//문제 읽어오는 경로
		File file = new File("CordingQuiz/Quiz1.txt");

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

		quiz1.add(scrollP);
		quiz1.add(textArea);

		// 정답버튼 생성
		JButton answerBtn = new JButton();
		ImageIcon btnImg = new ImageIcon("CordingQuiz/OkayButton.png");
		answerBtn.setIcon(btnImg);
		answerBtn.setBounds(290, 605, 100, 50);
		quiz1.add(answerBtn);
		
		frame.add(quiz1);

		answerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (answerArea.getText().trim().equals("frame")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
					//
					try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sender.dat"));
							BufferedReader br = new BufferedReader(new FileReader("Sender.dat"))) {
				int result=-1;
				int index=0;
						while((result=br.read())!=-1){
							value[index++]=result;
						}
						
						value[6]+=100;

						for (int num : value) {
							bw.write(String.valueOf(num));
							bw.newLine();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					QuizManager quizManager = new QuizManager();
					quizManager.QuizManager();

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
//					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
//					System.exit(0);
					QuizManager quizManager = new QuizManager();
					quizManager.QuizManager();
					frame.setVisible(false);
					break;
				}else if(stopidx==-1) {
					break;
				}

				timeP.setValue(time);
			}
		}
	}
}
