package com.global.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverView {
	JPanel gameOver;
//	JFrame frame;

	public GameOverView() {
	}

	public GameOverView(JPanel gameOver) {

		this();
		this.gameOver = gameOver;
		
		gameOver = new JPanel() ;
		gameOver.setBackground(new Color(233, 221, 198));
		gameOver.setLayout(null);
		gameOver.setBounds(0, 0, 1200, 700);
		
		ImageIcon gameoverImg = new ImageIcon("gameover.png");
		JLabel overIcon = new JLabel();
		overIcon.setBounds(400, 400, 500, 300);
		overIcon.setIcon(gameoverImg);


	}

}
