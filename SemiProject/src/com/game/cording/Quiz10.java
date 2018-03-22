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

public class Quiz10 {
	static int time = 60;
	JProgressBar timeP; // 타이머 바
	JFrame frame;
	JPanel bar;
	Timer timer;
	JTextArea answerArea;

	public void Quiz10() {

		//문제창 기본 프레임
		frame = new JFrame("Quiz10");
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
		File file = new File("Quiz10.txt");

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
				if (answerArea.getText().trim().equals("loNum[nextCount] == loNum[j]")) {
					JOptionPane.showMessageDialog(frame, "Correct!");
					frame.setVisible(false);
			
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
				if(answerArea.getText().trim().equals("java.util.Scanner sc = new java.util.Scanner(System.in);")){
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
