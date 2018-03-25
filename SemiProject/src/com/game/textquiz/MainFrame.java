package com.game.textquiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;




public class MainFrame extends JFrame{
	
	static Timer timer;
	JProgressBar timeP;
	public static int time = 20;
	JPanel bar;
	JPanel barbase;
	JPanel base;
	private boolean stop = false; // 타이머 스위치
	
	
	
	
	public MainFrame() {
		setTitle("Theory Quiz");
		setBounds(700, 350, 500, 400);
        getContentPane().setLayout(new BorderLayout());
        
      //프레임을 보더레이아웃으로 설정해서
      //  타이머 패널과 카드레이아웃 패널을 분리시킴
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				stop = true;
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				stop = true;
			}
		
		});
        
        
        bar = new JPanel();
    	bar.setLayout(null);
    	bar.setBounds(0, 0, 500, 20);
    	barbase = new JPanel();

    	bar.add(timeP = new JProgressBar());
    	timeP.setMinimum(0);
    	timeP.setMaximum(20);
    	timeP.setValue(time);
    	timeP.setForeground(Color.DARK_GRAY);
    	timeP.setBorderPainted(false);
    	timeP.setBounds(0, 0, 500, 20);
    	timeP.setBackground(new Color(233, 221, 198));
    	
    	getContentPane().add(bar);
        getContentPane().add(new QuizPanel(this),"Center");

        
       
        
        new Timer().start();
        
        setVisible(true);
    }
	
	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println(time);
					
					if (stop == true) {      //  true시 스레드 종료
						break;
						}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				
				
				if (time == 0) {
	
					timeP.setValue(time);
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					dispose();
					break;
				}
	
				timeP.setValue(time);
			}
	
		}
	}
	
	
}