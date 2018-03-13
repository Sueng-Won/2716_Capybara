package com.semiproject.service;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageSwitchByButton extends JFrame {
	private boolean flag = false;

	/* 이미지경로 저장을 위한 필드 생성 */
	private String path1 = "images_1.jpg";
	private String path2 = "images_2.jpg";

	/* 기본 생성자 */
	public ImageSwitchByButton() {
		/* 프레임 기본설정 */
		setSize(1000, 1000); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 동작 설정
		setTitle("ImageSwitchExample"); // 프레임 이름 설정

		/* 패널 객체 생성 */
		JPanel jpBase = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		// 크기 조정을 위한 빈 패널 객체 생성
		JPanel emptyJp1 = new JPanel();
		JPanel emptyJp2 = new JPanel();
		
		/* 패널내의 레이아웃 설정 */
		jpBase.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2, 1)); // 2행 1열의 배치
		
		//이미지 지정을 위한 라벨 객체 생성 및 할당
		JLabel jl1 = new JLabel(new ImageIcon(path1));
		JLabel jl2 = new JLabel(new ImageIcon(path2));
		jp1.add(jl1);		//이미지 1 추가
		/* 버튼 생성 및 할당 */
		JButton jb = new JButton("이미지 변환!");
		jp2.add(jb);
		
		/* 버튼 이벤트 생성 */
		jb.addActionListener(new ActionListener() {
			//이미지 경로 변경 -> 안됨
			//라벨 자체 변경 - > 안됨
			//라벨 제거 -> 안됨
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = switchFlag(flag);
//				jp1.removeAll();
				//dddddd
				jp1.add(jl2);
				jp2.add(jb);
				jp1.repaint();
				jp1.revalidate();
			}
		});
		
		/* 패널 안에 패널을 추가 */
		jpBase.add(emptyJp1, "West"); // 먼저쓰여진 패널이 우선권을 갖는다. jp1을 먼저 쓰면 나머지 빈 라벨의 공간이 최소화 된다.
		jpBase.add(emptyJp2, "East");
		jpBase.add(jp1, "Center");
		jp1.add(jp2);
		
		/* 프레임 패널 관리 */
		emptyJp1.setPreferredSize(new Dimension(250, 1000)); // 사이즈조정
		emptyJp2.setPreferredSize(new Dimension(250, 1000));
		jpBase.setPreferredSize(new Dimension(500, 1000));
		add(jpBase);
		setVisible(true);
	}
	
	public boolean switchFlag(boolean flag) {
		return !flag;
	}
}
