package com.global.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.global.view.StartView;

public class LoginView {
	public void mainLogin() {
//		JPanel panel = new JPanel();
		
		JFrame frame = new JFrame("사용자 이름 입력창");
		Container c = frame.getContentPane();
		
		frame.setBounds(600, 300, 300, 300);
		c.setBackground(new Color(233, 221, 198));
		frame.setLayout(null);
//		frame.add(panel);
		
		JLabel nameLabel = new JLabel("이름 입력");
		nameLabel.setBounds(40, 70, 70, 100);
		frame.add(nameLabel);

		TextField userName = new TextField(10);
		userName.setBounds(115, 105, 130, 30);
		frame.add(userName);

		JButton startBtn = new JButton("게임 시작");
		startBtn.setBounds(95, 180, 100, 30);
		frame.add(startBtn);

		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				UserInfo info = new UserInfo();
				String name = userName.getText();
				// 버튼 클릭시 팝업창 뜨게 하기
				if (e.getSource() == startBtn) {
					if (name ==null || name.trim().length() == 0) {
						//이름 공백일 시 뜨는 팝업창
						//trim() : 문자 양 옆의 공백 제거 
						JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
					} else {
						//올바르게 이름 입력시 뜨는 팝업창
						JOptionPane.showMessageDialog(null, name + "님 게임을 시작하겠습니다.");
						//이름 입력시 사용자 정보파일에 이름 입력
//						info.inputUser(name);
						//실행창에 사용자 이름 출력
						//System.out.println(name);
						// 팝업창 닫을시 이름 입력창도 닫기
						frame.setVisible(false);
						// 게임창으로 넘어가기
						StartView sv = new StartView();
						sv.gameView(1);

					}
				}	
			}
		});

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
