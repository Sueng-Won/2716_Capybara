package com.global.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.game.change.Change;
import com.game.cording.Main;
import com.game.rhythm.Ex2;
import com.game.textquiz.MainFrame;
import com.global.login.DataIo;
import com.global.login.LoginView;

public class StartView {

	int time = 20;
	int part = 1;
	JButton rythmBtn, cordingBtn, textqBtn, changeBtn, startBtn;
	int startIdx = 0;
	int count = 0;
	JLabel bubbleLabel1, bubbleLabel2, bubbleLabel3, bubbleLabel4, capybaraLabel, capybaraLabelWithQ,
			capybaraLabelWithN, capybaraLabelWithD, capybaraLabelWithS, student1Label, student2Label, student3Label,
			student4Label, student5Label;
	int overCnt = 0;// 집중력 0인 학생 수
	JFrame frame = new JFrame("카피바라 강사의 하루");
	ImageIcon img = new ImageIcon("Start/startBackground.png");

	// 이름없는생성자로 배경화면삽입
	JPanel background = new JPanel() {
		public void paintComponent(Graphics g) {
			g.drawImage(img.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	};

	StudentVo sv = new StudentVo();

	public void gameView(int startIdx) {

		this.startIdx = startIdx;
		frame.setBounds(50, 50, 1220, 700);
		frame.setLayout(null);
		// 파비콘 생성
		ImageIcon icon = new ImageIcon("Start/thumbnail.png");
		frame.setIconImage(icon.getImage());
		// 게임 기본화면 구현

		ImageIcon btnStart = new ImageIcon("ButtonImageFolder/StartButton.png");
		startBtn = new JButton();
		startBtn.setBounds(1020, 500, 100, 50);
		startBtn.setContentAreaFilled(false);
		startBtn.setIcon(btnStart);
		startBtn.setBorderPainted(false);

		ImageIcon startImg = new ImageIcon("Start/StartView.png");
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
				// startView.setVisible(false);
				startBtn.setVisible(false);
			}
		});
		ImageIcon capybara = new ImageIcon("CapyBara/CapyBara.png");
		capybaraLabel = new JLabel();
		capybaraLabel.setIcon(capybara);
		capybaraLabel.setBounds(200, 20, 400, 400);
		capybaraLabel.setVisible(true);

		ImageIcon capybaraWithQ = new ImageIcon("CapyBara/CapyBaraWithQuestion.png");
		capybaraLabelWithQ = new JLabel();
		capybaraLabelWithQ.setIcon(capybaraWithQ);
		capybaraLabelWithQ.setBounds(200, 20, 400, 400);
		capybaraLabelWithQ.setVisible(false);

		ImageIcon capybaraWithN = new ImageIcon("CapyBara/CapyBaraWithNotice.png");
		capybaraLabelWithN = new JLabel();
		capybaraLabelWithN.setIcon(capybaraWithN);
		capybaraLabelWithN.setBounds(200, 20, 400, 400);
		capybaraLabelWithN.setVisible(false);

		ImageIcon capybaraWithD = new ImageIcon("CapyBara/CapyBaraWithDot.png");
		capybaraLabelWithD = new JLabel();
		capybaraLabelWithD.setIcon(capybaraWithD);
		capybaraLabelWithD.setBounds(200, 20, 400, 400);
		capybaraLabelWithD.setVisible(false);

		ImageIcon capybaraWithS = new ImageIcon("CapyBara/CapyBaraWithSweat.png");
		capybaraLabelWithS = new JLabel();
		capybaraLabelWithS.setIcon(capybaraWithS);
		capybaraLabelWithS.setBounds(200, 20, 400, 400);
		capybaraLabelWithS.setVisible(false);

		ImageIcon bubblerhythm = new ImageIcon("SpeechBubble/SpeechBubbleRhythm.png");
		bubbleLabel1 = new JLabel();
		bubbleLabel1.setIcon(bubblerhythm);
		bubbleLabel1.setBounds(600, 20, 400, 400);
		bubbleLabel1.setVisible(false);

		ImageIcon bubblecording = new ImageIcon("SpeechBubble/SpeechBubbleCording.png");
		bubbleLabel2 = new JLabel();
		bubbleLabel2.setIcon(bubblecording);
		bubbleLabel2.setBounds(600, 20, 400, 400);
		bubbleLabel2.setVisible(false);

		ImageIcon bubbleTextq = new ImageIcon("SpeechBubble/SpeechBubbleTextQuiz.png");
		bubbleLabel3 = new JLabel();
		bubbleLabel3.setIcon(bubbleTextq);
		bubbleLabel3.setBounds(600, 20, 400, 400);
		bubbleLabel3.setVisible(false);

		ImageIcon bubblechange = new ImageIcon("SpeechBubble/SpeechBubbleChange.png");
		bubbleLabel4 = new JLabel();
		bubbleLabel4.setIcon(bubblechange);
		bubbleLabel4.setBounds(600, 20, 400, 400);
		bubbleLabel4.setVisible(false);

		ImageIcon student1 = new ImageIcon("AnimalFolder/Horse.png");
		student1Label = new JLabel();
		student1Label.setIcon(student1);
		student1Label.setBounds(20, 450, 50, 50);
		student1Label.setVisible(true);

		ImageIcon student2 = new ImageIcon("AnimalFolder/Panda.png");
		student2Label = new JLabel();
		student2Label.setIcon(student2);
		student2Label.setBounds(260, 450, 50, 50);
		student2Label.setVisible(true);

		ImageIcon student3 = new ImageIcon("AnimalFolder/Penguin.png");
		student3Label = new JLabel();
		student3Label.setIcon(student3);
		student3Label.setBounds(500, 450, 50, 50);
		student3Label.setVisible(true);

		ImageIcon student4 = new ImageIcon("AnimalFolder/PolarBear.png");
		student4Label = new JLabel();
		student4Label.setIcon(student4);
		student4Label.setBounds(740, 450, 50, 50);
		student4Label.setVisible(true);

		ImageIcon student5 = new ImageIcon("AnimalFolder/Racoons.png");
		student5Label = new JLabel();
		student5Label.setIcon(student5);
		student5Label.setBounds(980, 450, 50, 50);
		student5Label.setVisible(true);

		// ImageIcon img = new ImageIcon("startBackground.png");
		ImageIcon btnRythm = new ImageIcon("ButtonImageFolder/RythmButton.png");
		ImageIcon btnCording = new ImageIcon("ButtonImageFolder/CordingButton.png");
		ImageIcon btnTextQuiz = new ImageIcon("ButtonImageFolder/TextQuizButton.png");
		ImageIcon btnChange = new ImageIcon("ButtonImageFolder/ChangeButton.png");

		background.setBackground(new Color(233, 221, 198));
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

		// Vo 데이타를 배경패널에 입력
		background.add(sv.getConcentrationStu1());
		background.add(sv.getConcentrationStu2());
		background.add(sv.getConcentrationStu3());
		background.add(sv.getConcentrationStu4());
		background.add(sv.getConcentrationStu5());
		background.add(sv.setStress());
		background.add(sv.setAchievementLabel());
		background.add(sv.setAchivementCount());
		// sv.setConcentrationStu1().setValue(100); // 테스트 벨류셋
		// sv.setConcentrationStu3().setValue(100); // 테스트 벨류셋
		// sv.setConcentrationStu4().setValue(100); // 테스트 벨류셋

		// 리듬게임 실행
		rythmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				if (count != 6) {
					new Ex2(3, 0, 1, 20, 0).gameRun();
				}
				endGame();
			}
		});

		// 리듬게임 설명 말풍선
		rythmBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithN.setVisible(false);
				bubbleLabel1.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithN.setVisible(true);
				bubbleLabel1.setVisible(true);
			}

		});

		// 코딩게임 실행
		cordingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				if (count != 6) {
					new Main().main(null);
				}

				endGame();
			}
		});

		// 코딩게임 설명 말풍선
		cordingBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithQ.setVisible(false);
				bubbleLabel2.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithQ.setVisible(true);
				bubbleLabel2.setVisible(true);
			}

		});

		// 이론게임 실행
		textqBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				if (count != 6) {
					new MainFrame();
				}

				endGame();
			}
		});

		// 이론게임 설명 말풍선
		textqBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithD.setVisible(false);
				bubbleLabel3.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithD.setVisible(true);
				bubbleLabel3.setVisible(true);
			}

		});

		// 자리바꾸기
		changeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				if (count != 6) {
					Change c = new Change();
					int[] location = new int[5];
					location = c.changeLocationX();
					student1Label.setBounds(location[0], 450, 50, 50);
					student2Label.setBounds(location[1], 450, 50, 50);
					student3Label.setBounds(location[2], 450, 50, 50);
					student4Label.setBounds(location[3], 450, 50, 50);
					student5Label.setBounds(location[4], 450, 50, 50);
					sv.randomLocation(location);

				}
				endGame();

				// sv.stressV(100);

				// 피로도가 100이거나 집중도 0인 학생이 3명 이상일시 게임오버팝업창 띄움
				// if(sv.getStress()==100||overCnt>=3) {
				//
				// JOptionPane.showMessageDialog(null, "GameOver!");
				// background.setVisible(false);
				// }
			}
		});

		// 자리바꾸기 설명 말풍선
		changeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithS.setVisible(false);
				bubbleLabel4.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				capybaraLabelWithS.setVisible(true);
				bubbleLabel4.setVisible(true);
			}

		});

		// flag
		boolean[] flag = new boolean[5];
		for (int i = 0; i < flag.length; i++) {
			flag[i] = true;
		}

		frame.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				try (BufferedReader br = new BufferedReader(new FileReader("Sender.dat"))) {
					String[] tempStr = new String[7];
					String temp;
					int check = 0;
					int checkSum = 0;
					int[] valueArr = new int[7];
					while ((temp = br.readLine()) != null) {
						tempStr[check++] = temp;
					}
					for (int i = 0; i < 7; i++) {
						valueArr[i] = Integer.parseInt(tempStr[i]);
						checkSum += valueArr[i];
					}
					if (checkSum != 0) {
						sv.addValueAll(valueArr);
						background.validate();
						background.revalidate();
						background.repaint();
						try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sender.dat"))) {
							for (int i = 0; i < 7; i++) {
								bw.write("0");
								bw.newLine();
							}
						}

					}
					// 집중도가 100일때 over학생 수 카운트 ++
					if (sv.getConcentrationStu1().getValue() <= 0 && flag[0]) {
						overCnt++;
						background.remove(sv.getConcentrationStu1());
						student1Label.setIcon(new ImageIcon("AnimalFolder/LetterX.png"));
						flag[0] = false;
					}
					if (sv.getConcentrationStu2().getValue() <= 0 && flag[1]) {
						overCnt++;
						background.remove(sv.getConcentrationStu2());
						student2Label.setIcon(new ImageIcon("AnimalFolder/LetterX.png"));
						flag[1] = false;
					}
					if (sv.getConcentrationStu3().getValue() <= 0 && flag[2]) {
						overCnt++;
						background.remove(sv.getConcentrationStu3());
						student3Label.setIcon(new ImageIcon("AnimalFolder/LetterX.png"));
						flag[2] = false;
					}
					if (sv.getConcentrationStu4().getValue() <= 0 && flag[3]) {
						overCnt++;
						background.remove(sv.getConcentrationStu4());
						student4Label.setIcon(new ImageIcon("AnimalFolder/LetterX.png"));
						flag[3] = false;
					}
					if (sv.getConcentrationStu5().getValue() <= 0 && flag[4]) {
						overCnt++;
						background.remove(sv.getConcentrationStu5());
						student5Label.setIcon(new ImageIcon("AnimalFolder/LetterX.png"));
						flag[4] = false;
					}
					endGame();
				} catch (FileNotFoundException fnfe) {
					// TODO Auto-generated catch block
					fnfe.printStackTrace();
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
			}

		});

		// 백그라운드 배경패널에 버튼삽입
		background.add(rythmBtn);
		background.add(cordingBtn);
		background.add(textqBtn);
		background.add(changeBtn);
		background.add(startBtn);
		// 카피바라
		background.add(capybaraLabel);
		background.add(capybaraLabelWithQ);
		background.add(capybaraLabelWithN);
		background.add(capybaraLabelWithD);
		background.add(capybaraLabelWithS);

		// 말풍선
		background.add(bubbleLabel1);
		background.add(bubbleLabel2);
		background.add(bubbleLabel3);
		background.add(bubbleLabel4);

		// 학생
		background.add(student1Label);
		background.add(student2Label);
		background.add(student3Label);
		background.add(student4Label);
		background.add(student5Label);

		System.out.println("성취도:" + sv.setAchivementCount().getText());

		frame.add(background);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (startIdx == 1) {
			new GlobalEventThread().start();
		}

	}

	public void endGame() {
		if (count == 6) {
			count = 0;
			new DataIo().saveAchievement(new StudentVo().getAchievement());
			JOptionPane.showMessageDialog(null, "하루가 무사히 끝났습니다!");
			// 여기다가 점수판 실행시킬 것
			new DataIo().scoreboard();
		}
		if (overCnt >= 3 || sv.getStress() == 100) {
			overCnt = 0;
			JPanel gameOver = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(img.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			gameOver.setBackground(new Color(233, 221, 198));
			gameOver.setLayout(null);
			gameOver.setBounds(0, 0, 1220, 700);

			ImageIcon gameoverImg = new ImageIcon("Start/GameOver.png");
			JLabel overIcon = new JLabel();
			overIcon.setBounds(0, 0, 1220, 700);
			overIcon.setIcon(gameoverImg);
			gameOver.add(overIcon);
			frame.add(gameOver);
			background.setVisible(false);
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
