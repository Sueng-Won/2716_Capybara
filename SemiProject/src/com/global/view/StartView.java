package com.global.view;

import java.awt.Image;

import javax.swing.*;

public class StartView {
	int time = 20;
	int part = 1;
	JLabel timeLabel;
	JLabel partLabel;
	int startIdx = 0;
	
	public void gameView(int startIdx) {
		
		this.startIdx = startIdx;
		JFrame frame = new JFrame("카피바라 강사의 하루");
		frame.setBounds(50, 50, 1200, 750);
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
		background.setBounds(0, 50, 1200, 660);
		frame.add(background);

		timeLabel = new JLabel("00 : "+time);
		timeLabel.setBounds(1000,0,200,50);
		frame.add(timeLabel);
		partLabel = new JLabel(part+"교시");
		partLabel.setBounds(880,0,100,50);
		frame.add(partLabel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		if(startIdx == 1){
			new GlobalEventThread().start();
			new Timer().start();
		}

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
	
	class Timer extends Thread{//타이머
		@Override
		public void run(){
			while(true){
			try {
				Thread.sleep(1000);
				time--;
				if(time>9){
					timeLabel.setText("00 : "+time);
				}else if(time>0){
					timeLabel.setText("00 : 0"+time);
				}else{
					timeLabel.setText("00 : 0"+time);
					time = 20;
					if(part==3){	
						JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
						System.exit(0);
						break;
					}else{
						JOptionPane.showMessageDialog(null, part+"교시 완료!!");
						part++;
						partLabel.setText(part+"교시");
						timeLabel.setText("00 : "+time);
					}
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
}
