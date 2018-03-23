package com.global.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.game.cording.Quiz1;
import com.game.rhythm.Ex2;
import com.game.textquiz.Quiz;
import com.global.login.DataIo;
import com.global.login.LoginView;

public class StartView {

	int time = 20;
	int part = 1;
	JButton rythmBtn, cordingBtn, textqBtn, changeBtn, startBtn;
	int startIdx = 0;
	int count=0;
	JLabel bubbleLabel1, bubbleLabel2, bubbleLabel3, bubbleLabel4;

	public void gameView(int startIdx) {

		this.startIdx = startIdx;
		JFrame frame = new JFrame("카피바라 강사의 하루");
		frame.setBounds(50, 50, 1220, 700);
		frame.setLayout(null);
		// 파비콘 생성
		ImageIcon icon = new ImageIcon("thumbnail.png");
		frame.setIconImage(icon.getImage());
		// 게임 기본화면 구현
		
		ImageIcon btnStart = new ImageIcon("ButtonImageFolder/StartButton.png");
		startBtn = new JButton();
		startBtn.setBounds(1020, 500, 100, 50);
		startBtn.setContentAreaFilled(false);
		startBtn.setIcon(btnStart);
		startBtn.setBorderPainted(false);
	
		

		ImageIcon startImg = new ImageIcon("startview.png");
		JPanel startView = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startImg.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		startView.setLayout(null);
		startView.setBounds(0, 0, 1220, 700);
		frame.add(startView);
		startView.add(startBtn);

		startBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new LoginView(startView).mainLogin();
		//		startView.setVisible(false);
				startBtn.setVisible(false);
			}
		});
		
		ImageIcon bubblerhythm = new ImageIcon("SpeechBubble/SpeechBubbleRhythm.png");
		bubbleLabel1 = new JLabel();
		bubbleLabel1.setIcon(bubblerhythm);
		bubbleLabel1.setBounds(600,20,400,400);
		bubbleLabel1.setVisible(false);
		
		ImageIcon bubblecording = new ImageIcon("SpeechBubble/SpeechBubbleCording.png");
		bubbleLabel2 = new JLabel();
		bubbleLabel2.setIcon(bubblecording);
		bubbleLabel2.setBounds(600,20,400,400);
		bubbleLabel2.setVisible(false);
		
		ImageIcon bubbleTextq = new ImageIcon("SpeechBubble/SpeechBubbleTextQuiz.png");
		bubbleLabel3 = new JLabel();
		bubbleLabel3.setIcon(bubbleTextq);
		bubbleLabel3.setBounds(600,20,400,400);
		bubbleLabel3.setVisible(false);
		
		ImageIcon bubblechange = new ImageIcon("SpeechBubble/SpeechBubbleChange.png");
		bubbleLabel4 = new JLabel();
		bubbleLabel4.setIcon(bubblechange);
		bubbleLabel4.setBounds(600,20,400,400);
		bubbleLabel4.setVisible(false);
	

		// 학생 각 수치 구현

		// 먼저 마우스이벤트 통해 마우스 찍은부분 좌표 알아낸다음, 그 좌표를 setbounds에 넣어
		// 수치 그림 알맞게 삽입, 수치는 게임이나 이벤트 결과에 따라 조절. 수치 그림 10 단위로 쪼개어 캡쳐하여
		// 덮어쓰는식으로 사용....근데 사진위에 왜 덮어쓰기가 안될까
		// ImageIcon redImg = new ImageIcon("피로도_1.png");
		// JLabel redBar = new JLabel(redImg);
		// redBar.setBounds(30, 480, 700, 30);
		// frame.add(redBar);

		// ImageIcon img = new ImageIcon("startBackground.png");
		ImageIcon btnRythm = new ImageIcon("ButtonImageFolder/RythmButton.png");
		ImageIcon btnCording = new ImageIcon("ButtonImageFolder/CordingButton.png");
		ImageIcon btnTextQuiz = new ImageIcon("ButtonImageFolder/TextQuizButton.png");
		ImageIcon btnChange = new ImageIcon("ButtonImageFolder/ChangeButton.png");

		ImageIcon img = new ImageIcon("startBackground.png");
		// 이름없는생성자로 배경화면삽ㅇ딥
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		background.setBackground(new Color(233,221,198));
		background.setLayout(null);
		background.setBounds(0, 0, 1200, 700);
		
		rythmBtn = new JButton();
		cordingBtn = new JButton();
		textqBtn = new JButton();
		changeBtn = new JButton();
		startBtn = new JButton();

		rythmBtn.setBounds(1020, 10, 150, 50);
		cordingBtn.setBounds(1020, 70, 150, 50);
		textqBtn.setBounds(1020, 130, 150, 50);
		changeBtn.setBounds(1020, 190, 150, 50);

		// 배경 투명
		rythmBtn.setContentAreaFilled(false);
		cordingBtn.setContentAreaFilled(false);
		textqBtn.setContentAreaFilled(false);
		changeBtn.setContentAreaFilled(false);
		startBtn.setContentAreaFilled(false);

		rythmBtn.setIcon(btnRythm);
		cordingBtn.setIcon(btnCording);
		textqBtn.setIcon(btnTextQuiz);
		changeBtn.setIcon(btnChange);
		startBtn.setIcon(btnStart);

		rythmBtn.setBorderPainted(false);
		cordingBtn.setBorderPainted(false);
		textqBtn.setBorderPainted(false);
		changeBtn.setBorderPainted(false);
		startBtn.setBorderPainted(false);

		// 리듬게임 실행
		rythmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Ex2(3, 0, 1, 20).gameRun();
				count++;
				endGame();
			}
		});
		
		//리듬게임 설명 말풍선
		rythmBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel1.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel1.setVisible(true);
			}

		});

		// 코딩게임 실행
		cordingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Quiz1().Quiz1();
				count++;
				endGame();
			}
		});
		
		//코딩게임  설명 말풍선
		cordingBtn.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel2.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel2.setVisible(true);
			}

		});

		// 이론게임 실행
		textqBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Quiz().randomOutput();
				count++;
				endGame();
			}
		});
		
		//이론게임  설명 말풍선
		textqBtn.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel3.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel3.setVisible(true);
			}

		});

		// 자리바꾸기
		changeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				endGame();
			}
		});
		
		// 자리바꾸기 설명 말풍선
		changeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel4.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				bubbleLabel4.setVisible(true);
			}

		});
		


		// 백그라운드 배경패널에 버튼삽입
		background.add(rythmBtn);
		background.add(cordingBtn);
		background.add(textqBtn);
		background.add(changeBtn);
		background.add(startBtn);
		
		//말풍선
		background.add(bubbleLabel1);
		background.add(bubbleLabel2);
		background.add(bubbleLabel3);
		background.add(bubbleLabel4);

		// Vo 데이타를 배경패널에 입력
		StudentVo sv = new StudentVo();
		background.add(sv.setConcentrationStu1());
		background.add(sv.setConcentrationStu2());
		background.add(sv.setConcentrationStu3());
		background.add(sv.setConcentrationStu4());
		background.add(sv.setConcentrationStu5());
		background.add(sv.setStress());
		background.add(sv.setAchievementLabel());
		background.add(sv.setAchivementCount());
		sv.setConcentrationStu1().setValue(22); // 테스트 벨류셋
		System.out.println("성취도:" + sv.setAchivementCount().getText());

		frame.add(background);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (startIdx == 1) {
			new GlobalEventThread().start();
		}
		
		
	}
	
	public void endGame(){
		if(count==5){
			count=0;
			new DataIo().saveAchievement(new StudentVo().getAchievement());
		}
	}

	

	class GlobalEventThread extends Thread {
		@Override
		public void run() {
			// 랜덤으로 숫자 받기
			int num = (int) (Math.random() * 10) + 1;
			// 7일때 팝업창 띄우기
			if (num == 7) {
				int ratio = (int) (Math.random() * 40) + 10; // 10초에서 50초 사이 중
																// 하나
				try {
					Thread.sleep(ratio * 1000);
					JOptionPane.showMessageDialog(null, "훈련보상비 지급일!");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
