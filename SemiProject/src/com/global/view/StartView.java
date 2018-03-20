package com.global.view;

import java.awt.Image;

import javax.swing.*;

public class StartView {

	public void gameView() {

		JFrame frame = new JFrame("카피바라 강사의 하루");
		frame.setBounds(50, 50, 1200, 700);
		frame.setLayout(null);
		// 파비콘 생성
		ImageIcon icon = new ImageIcon("thumbnail.png");
		frame.setIconImage(icon.getImage());
		// 게임 기본화면 구현

		// 학생 각 수치 구현

		// 먼저 마우스이벤트 통해 마우스 찍은부분 좌표 알아낸다음, 그 좌표를 setbounds에 넣어
		// 수치 그림 알맞게 삽입, 수치는 게임이나 이벤트 결과에 따라 조절. 수치 그림 10 단위로 쪼개어 캡쳐하여
		// 덮어쓰는식으로 사용....근데 사진위에 왜 덮어쓰기가 안될까
		// ImageIcon redImg = new ImageIcon("피로도_1.png");
		// JLabel redBar = new JLabel(redImg);
		// redBar.setBounds(30, 480, 700, 30);
		// frame.add(redBar);

		ImageIcon img = new ImageIcon("startBackground.png");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, 1200, 660);
		frame.add(background);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		new GlobalEventThread().start();
	}

	class GlobalEventThread extends Thread {
		@Override
		public void run() {
			//랜덤으로 숫자 받기
			int num = (int) (Math.random() * 10) + 1;
	    	//7일때 팝업창 띄우기
			if (num == 7) {
				int ratio = (int) (Math.random() * 40) + 10; // 10초에서 50초 사이 중 하나
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