package com.game.rhythm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Ex2 extends JFrame implements KeyListener {
	String sol = null; // 문제의 랜덤 값을 스트링으로 처리
	String[] images = { "up.PNG", "left.PNG", "down.PNG", "right.PNG" }; // 방향키 이미지 경로
	JLabel[] l_name = new JLabel[15]; // 문제를 저장할 배열
	static int life = 3; // 라이프
	JPanel jp; // 그리드레이아웃을 담을 패널
	JPanel base;//가장 아래 베이스 패널-보더레이아웃
	JPanel bar;//게임 화면 위에 위치-> 타이머,남은 생명 나타냄
	JPanel barbase; //그리드로 생명 줄어도 나머지 라벨 위치 이동 없게
	JPanel lifePanel;//생명 이미지 넣을 패널
	static int count = 0; // 입력 횟수
	static int count2 = 1; // 게임 반복 횟수
	static int time = 20; //게임 제한 초
	JLabel timeLabel;
	JLabel lifeLabel1, lifeLabel2, lifeLabel3;//생명 하트 1,2,3
	JProgressBar timeP;
	Image dieImage;
	JLabel[] lifeLabel = new JLabel[3];
	Timer timer = new Timer();
	
	public Ex2(int life, int count, int count2, int time){
		this.life = life;
		this.count = count;
		this.count2 = count2;
		this.time = time;
	}
	
	// 실행 메소드//
	public void gameRun() {

		setSize(700, 400);
		setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
		
		base = new JPanel(new BorderLayout());
		bar = new JPanel(new GridLayout(1,2,1,1));
		barbase = new  JPanel(new FlowLayout(FlowLayout.RIGHT));

		bar.add(timeP = new JProgressBar());
		timeP.setMinimum(0);
		timeP.setMaximum(80);
		timeP.setValue(time);
		timeP.setForeground(Color.DARK_GRAY);
		timeP.setBorderPainted(false);
		bar.add(lifePanel = new JPanel());
		barbase.add(bar);
		
		lifePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		Image lifeImage = new ImageIcon("lifeImage.PNG").getImage().getScaledInstance(20, 20, 0);
		dieImage = new ImageIcon("baseImg.PNG").getImage().getScaledInstance(20, 20, 0);

		
		for(int i = 0; i<life; i++){
			lifePanel.add(lifeLabel[i] = new JLabel());
			lifeLabel[i].setIcon(new ImageIcon(lifeImage));
		}

		jp = new JPanel();
		jp.setLayout(new GridLayout(3, 5, 10, 10));
		


		int num = 0;
		int ranNum = 0;
		String str = "";
		while (num < 15) {
			ranNum = (int) (Math.random() * 4);
			str += ranNum + "";
			jp.add(l_name[num] = new JLabel(new ImageIcon(images[ranNum])));
			l_name[num].addKeyListener(this);
			num++;
		}
		sol = str;
		
		base.add(jp, BorderLayout.CENTER);
		base.add(barbase, BorderLayout.NORTH);
		
		add(base);

		setVisible(true);
		for (int i = 0; i < l_name.length; i++) {
			l_name[i].requestFocus();
		}
		if(time==20){
				timer.start();
		}


		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

	}

	// 키보드 이벤트
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		char solNum = sol.charAt(count);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:

			if (solNum == '0') { // 맞을경우
				l_name[count].setIcon(new ImageIcon("Capybara.jpg"));
				count++;

				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 " + (3 - count2) + "회 입니다.");
					synchronized(timer){
						timer.notify();//새로운 턴 게임 시작할때 스레드 다시 시작
					}
					count = 0;
					count2++;
					if (count2 >= 4) {			//마지막 run을 실행 시키지 않음
						JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
//						System.exit(0);
						dispose();
					}else{
						gameRun();
						setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
						}	//게임횟수 초기화를 위한 구문

				}
			} else { // 틀릴경우
				life--;

				if(life==2){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}else if(life==1){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}
				setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]"); // title은 자동으로 바뀌지 않아서 다시 setTitle
				if (life == 0) { // 라이프가 0일 경우
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
					JOptionPane.showMessageDialog(null, "라이프를 모두 소진하셨습니다.");
//					System.exit(0); // 시스템 종료 -> ***이 부분은 상위 뷰와 연결될 때 수정해야함***
					dispose();
				}
			}

			break;
		case KeyEvent.VK_LEFT:

			if (solNum == '1') {
				l_name[count].setIcon(new ImageIcon("Capybara.jpg"));
				count++;

				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 " + (3 - count2) + "회 입니다.");
					synchronized(timer){
						timer.notify();
					}
					count = 0;
					count2++;
					if (count2 >= 4) {
						JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
//						System.exit(0);
						dispose();
					}else{
						gameRun();
						setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
						}

				}
			} else {
				life--;

				if(life==2){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}else if(life==1){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}
				setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");

				if (life == 0) {
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
					JOptionPane.showMessageDialog(null, "라이프를 모두 소진하셨습니다.");
//					System.exit(0);
					dispose();
				}
			}
			break;
		case KeyEvent.VK_DOWN:

			if (solNum == '2') {
				l_name[count].setIcon(new ImageIcon("Capybara.jpg"));
				count++;
				
				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 " + (3 - count2) + "회 입니다.");
					synchronized(timer){
						timer.notify();
					}
					count = 0;
					count2++;
					if (count2 >= 4) {
						JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
//						System.exit(0);
						dispose();
					}else{
						gameRun();
						setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
						}
				}
			} else {
				life--;

				if(life==2){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}else if(life==1){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}
				setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
				if (life == 0) {
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
					JOptionPane.showMessageDialog(null, "라이프를 모두 소진하셨습니다.");
//					System.exit(0);
					dispose();
				}
			}

			break;
		case KeyEvent.VK_RIGHT:

			if (solNum == '3') {
				l_name[count].setIcon(new ImageIcon("Capybara.jpg"));
				count++;

				if (count >= 15) {
					JOptionPane.showMessageDialog(null, "남은 횟수는 " + (3 - count2) + "회 입니다.");	
					synchronized(timer){
						timer.notify();
					}
					count = 0;
					count2++;
					if (count2 >= 4) {
						JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
//						System.exit(0);
						dispose();
					}else{
					gameRun();
					setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
					}

				}
			} else {
				life--;
				if(life==2){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}else if(life==1){
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
				}
				setTitle("리듬게임/ [남은 라이프 : " + life + "개] [게임횟수 : "+count2+"번]");
				if (life == 0) {
					lifeLabel[life].setIcon(new ImageIcon(dieImage));
					JOptionPane.showMessageDialog(null, "라이프를 모두 소진하셨습니다.");
					dispose();
				}
			}
			break;
		default:
			System.out.println("방향키를 입력하세요.");
		}

		System.out.println("키 입력 완료");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class Timer extends Thread{
		@Override
		public void run(){
			time = 80;
			while(true){
				try {
					if (count == 15 || life==0) {//게임 한턴 끝날때 
						synchronized(timer){
							timer.wait();//시간 멈춤=>JOption확인 누르는 시간동안
						}
					}
						Thread.sleep(250);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				time--;
				if(time==0){
					timeP.setValue(time);
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					dispose();
					break;
				}else if(count2 >= 4){
					break;
				}
				timeP.setValue(time);
			}

		}
	}

}
