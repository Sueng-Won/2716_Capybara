package com.semiproject.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//JFrame을 상속받음
public class ButtonEventBase extends JFrame {
	/**
	 * Yuventius Choi 18/03/09 14:20
	 * 버튼을 누름으로서 JLabel의 text를 바꿈
	 * 여러가지 응용이 가능해보임
	 */
	private static final long serialVersionUID = 1L;
	private boolean flag = false;

	/* 기본생성자 */
	public ButtonEventBase() {
		/* 프레임 기본설정 */
		setSize(600, 150); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 동작 설정
		setTitle("ButtonEventExample"); // 프레임 이름 설정

		/* 패널 객체 생성 */
		JPanel jpBase = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		// 크기 조정을 위한 빈 패널 객체 생성
		JPanel emptyJp1 = new JPanel();
		JPanel emptyJp2 = new JPanel();

		/* 패널내의 레이아웃 설정 */
		jpBase.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(3, 1)); // 3행 1열의 배치

		/* 패널 색상 설정 : 패널 각각의 배경색을 지정 */
		jp1.setBackground(Color.BLUE);
		jp2.setBackground(Color.CYAN);
		jp3.setBackground(Color.GREEN);

		/* 라벨 객체 생성 */
		JLabel jl = new JLabel("테스트용 라벨");
		jl.setHorizontalAlignment(SwingConstants.CENTER); // 라벨의 정렬설정
		jp1.add(jl); // 라벨을 하나의 패널에 추가

		/* 버튼 객체 생성 */
		JButton jb = new JButton("테스트용 버튼");
		jp2.add(jb); // 버튼을 하나의 패널에 추가

		/* 버튼 이벤트 생성 */
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = switchFlag(flag);
				if (flag) {
					jl.setText("버튼 눌러짐!");
				} else {
					jl.setText("테스트용 버튼");
				}
			}
		});

		/* 패널 안에 패널을 추가 */
		jpBase.add(emptyJp1, "West"); // 먼저쓰여진 패널이 우선권을 갖는다. jp1을 먼저 쓰면 나머지 빈 라벨의 공간이 최소화 된다.
		jpBase.add(emptyJp2, "East");
		jpBase.add(jp1, "Center");
		jp1.add(jp2);
		jp1.add(jp3);
		//안녕하세요

		/* 프레임 패널 관리 */
		emptyJp1.setPreferredSize(new Dimension(150, 300)); // 사이즈조정
		emptyJp2.setPreferredSize(new Dimension(150, 300));
		jpBase.setPreferredSize(new Dimension(300, 300));
		add(jpBase);
		setVisible(true);
	}
	public boolean switchFlag(boolean flag) { 
		return !flag;
	}
}
