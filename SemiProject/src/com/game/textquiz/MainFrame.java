package com.game.textquiz;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;




public class MainFrame extends JFrame{
	
	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	static Timer timer;
	JProgressBar timeP;
	public static int time = 20;
	JPanel bar;
	JPanel barbase;
	JPanel base;
	public static boolean stop = false; // 타이머 스위치
	public static boolean wait = false;  // 타이머 일시정지
	QuizPanel qp = new QuizPanel(this);
	Timer tm = new Timer();
	
	
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
				stop=true;
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				stop=true;
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
        getContentPane().add(qp,"Center");

        
       
        
        tm.start();
        
        setVisible(true);
    }
	
	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
//					System.out.println(time);
					
					if (stop == true) {      //  true시 스레드 종료
						break;
						}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(wait == false){     //정답 확인 클릭시 타임감소 멈춤
				time--;				 // 다음패널로 넘어갈 때 다시 타임 감소
				}
				
				if (time == 0) {
					JLabel messageLabel = new JLabel("시간초과!!");
					messageLabel.setFont(f1);
					
					timeP.setValue(time);
					JOptionPane.showMessageDialog(null, messageLabel, "TimeOver",
							JOptionPane.INFORMATION_MESSAGE);
					nextPanel();
					
				
				}
				timeP.setValue(time);
			}
	
		}
	}

	
	
	public void nextPanel(){

		qp.pointBo = false;
		qp.changePanel();
		
	}

	
	}
