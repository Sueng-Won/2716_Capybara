package com.game.textquiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Quiz {

	Font f1 = new Font("맑은 고딕", Font.BOLD, 13);
	private String labelStr;
	private String areaStr;
	private String example1;
	private String example2;
	private String example3;
	private String example4;
	private int answer;
	private int areaNum;
	JFrame frame;
	JButton Btn = new JButton("정답 확인");
	JRadioButton check1;
	JRadioButton check2;
	JRadioButton check3;
	JRadioButton check4;
	int[] numArr = new int[5];
	public int count = 0;
	static Timer timer;
	JProgressBar timeP;
	static int time = 20;
	JPanel bar;
	JPanel barbase;
	JPanel base;
	boolean stop = false;

	public void quizMethod1() {
		this.labelStr = "다음 중 기본형(primitive type)이 아닌 것은?";
		// this.areaStr = " ";
		this.example1 = "1. int";
		this.example2 = "2. Byte";
		this.example3 = "3. double";
		this.example4 = "4. boolean";
		this.answer = 2;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod2() {
		this.labelStr = "다음 중 메소드 오버로딩에 대한 설명으로 틀린 것은?";
		// this.areaStr = " ";
		this.example1 = "1. 메소드의 이름이 같아야 한다.";
		this.example2 = "2. 리턴타입은 상관 없다.";
		this.example3 = "3. 매개변수의 개수나 타입이 같아야 한다.";
		this.example4 = "4. 동일 클래스 내에서 발생한다.";
		this.answer = 3;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod3() {
		this.labelStr = "타입 캐스팅의 widening conversion 순서가 아닌 것은?";
		// this.areaStr = " ";
		this.example1 = "1. byte -> short";
		this.example2 = "2. double -> float";
		this.example3 = "3. char -> int";
		this.example4 = "4. short -> int";
		this.answer = 2;
		this.areaNum = 0;
		stop = false;
		time = 20;

		quizDisplay();

	}

	public void quizMethod4() {
		this.labelStr = "다음 괄호 안에 들어갈 명칭으로 알맞은 것은?";
		this.areaStr = "  사용할 클래스가 속한 패키지를 지정하는데 사용.\n" + "  (  )문을 사용하면 클래스를 사용할 때 패키지명을 생략.\n"
				+ "  java.lang 패키지의 클래스는 JVM이 자동으로 (  )함.\n" + "  사용자가 (  )할 필요없음.(String, Object, System…) ";
		this.example1 = "1. interface";
		this.example2 = "2. abstract";
		this.example3 = "3. extends";
		this.example4 = "4. import";
		this.answer = 4;
		this.areaNum = 1;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod5() {
		this.labelStr = "다음은 자바의 예외 처리에 대한 설명이다. 틀린 것은?";
		// this.areaStr = " ";
		this.example1 = "1. 모든 메소드 마다 예외의 유형을 정의하여야 한다.";
		this.example2 = "2. finally문은 생략 가능하다.";
		this.example3 = "3. try~catch~finally 문에 여러 개의 catch문이 올 수 있다.";
		this.example4 = "4. 지정하지 않은 예외는 디폴트 예외 처리기가 처리한다.";
		this.answer = 1;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod6() {
		this.labelStr = "다음 중 초기화에 대한 설명으로 옳지 않은 것은?";
		// this.areaStr = " ";
		this.example1 = "1. String 멤버변수는 “”로 자동 초기화된다.";
		this.example2 = "2. 지역변수는 반드시 초기화해야 한다.";
		this.example3 = "생성자보다 초기화 블럭이 먼저 수행된다.";
		this.example4 = "인스턴스변수보다 클래스변수가 먼저 초기화된다.";
		this.answer = 1;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod7() {
		this.labelStr = "다음 중 지역변수에 대한 설명으로 옳지 않은 것은?";
		// this.areaStr = " ";
		this.example1 = "1. 스택(stack)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.";
		this.example2 = "2. 지역변수가 선언된 메소드가 종료되면 지역변수도 함께 소멸된다.";
		this.example3 = "3. 메소드의 매개변수로 선언된 변수도 지역변수이다.";
		this.example4 = "4. 자동 초기화되므로 별도의 초기화가 필요없다.";
		this.answer = 4;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod8() {
		this.labelStr = "자바의 상속 특징 중에서 틀린 것은?";
		// this.areaStr = " ";
		this.example1 = "1. 클래스의 다중 상속을 지원하지 않는다.";
		this.example2 = "2. 상속의 횟수에 제한이 없다.";
		this.example3 = "3. 모든 클래스의 최상위 슈퍼 클래스는 java.lang.System 클래스이다.";
		this.example4 = "4. 상속을 표현하는 키워드는 extends이다.";
		this.answer = 3;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod9() {
		this.labelStr = "다음 중 인터페이스에 대한 설명으로 옳지 않은 것은?";
		// this.areaStr = " ";
		this.example1 = "1. 표준화를 가능하게 해준다.";
		this.example2 = "2. 서로 관계없는 클래스들에게 관계를 맺어줄수 있다.";
		this.example3 = "3. 패키지간의 연결을 도와준다.";
		this.example4 = "4. 다중상속을 가능하게 해준다.";
		this.answer = 3;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizMethod10() {
		this.labelStr = "0으로 나눌 때 발생하는 에러를 처리하는 예외 클래스는?";
		// this.areaStr = " ";
		this.example1 = "1. ArithmeticException";
		this.example2 = "2. ClassCastException";
		this.example3 = "3. NullPointerException";
		this.example4 = "4. NumberFormatException";
		this.answer = 1;
		this.areaNum = 0;
		stop = false;
		time = 20;
		quizDisplay();

	}

	public void quizDisplay() {

		frame = new JFrame("Quiz");
		frame.setBounds(500, 300, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		JLabel qLabel = new JLabel();
		qLabel.setText(labelStr);
		if (areaNum == 1) {
			qLabel.setBounds(30, 10, 350, 50);
		} else {
			qLabel.setBounds(30, 70, 350, 50);
		}

		if (areaNum == 1) {
			JTextArea textArea = new JTextArea(30, 50);
			textArea.setText(areaStr);
			textArea.setEditable(false);
			textArea.setBounds(30, 65, 300, 70);
			frame.add(textArea);
		}

		check1 = new JRadioButton(example1);
		check1.setBounds(30, 160, 450, 30);

		check2 = new JRadioButton(example2);
		check2.setBounds(30, 190, 450, 30);

		check3 = new JRadioButton(example3);
		check3.setBounds(30, 220, 450, 30);

		check4 = new JRadioButton(example4);
		check4.setBounds(30, 250, 400, 30);

		Btn.setBounds(100, 300, 100, 30);

		qLabel.setFont(f1);
		check1.setFont(f1);
		check2.setFont(f1);
		check3.setFont(f1);
		check4.setFont(f1);
		Btn.setFont(f1);

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(check1);
		btnGroup.add(check2);
		btnGroup.add(check3);
		btnGroup.add(check4);

		frame.add(qLabel);

		bar = new JPanel();
		bar.setLayout(null);
		bar.setBounds(0, 0, 500, 25);

		bar.add(timeP = new JProgressBar());
		timeP.setMinimum(0);
		timeP.setMaximum(20);
		timeP.setValue(time);
		timeP.setForeground(Color.DARK_GRAY);
		timeP.setBorderPainted(false);
		timeP.setBounds(0, 0, 500, 25);

		// if (time == 60) {
		// new Timer().start();
		// }

		frame.add(check1);
		frame.add(check2);
		frame.add(check3);
		frame.add(check4);
		frame.add(Btn);
		frame.add(bar);

		frame.setVisible(true);

		Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int answerMatch = 0;
				JLabel messageLabel1 = new JLabel("정답입니다.");
				JLabel messageLabel2 = new JLabel("틀렸습니다.");
				messageLabel1.setFont(f1);
				messageLabel2.setFont(f1);

				if (check1.isSelected()) {

					answerMatch = 1;

					if (answerMatch == answer) {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);
					}

					frame.setVisible(false);

					randomOutput();

				} else if (check2.isSelected()) {

					answerMatch = 2;

					if (answerMatch == answer) {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);

					}

					frame.setVisible(false);

					randomOutput();

				} else if (check3.isSelected()) {

					answerMatch = 3;

					if (answerMatch == answer) {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);
					}

					frame.setVisible(false);

					randomOutput();

				} else if (check4.isSelected()) {

					answerMatch = 4;

					if (answerMatch == answer) {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel1, "AnswerMessage",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						stop = true;
						JOptionPane.showMessageDialog(null, messageLabel2, "AnswerMessage", JOptionPane.ERROR_MESSAGE);
					}

					frame.setVisible(false);

					randomOutput();

				}
			}
		});

	}

	public void randomOutput() {

		new Timer().start();
		// if(count==0){
		// new Timer().start();
		for (int i = 0; i < numArr.length; i++) {

			numArr[i] = (int) (Math.random() * 10) + 1;

			for (int j = 0; j < i; j++) {

				if (numArr[i] == numArr[j]) {
					i--;
					break;
				}

			}

			// }
		}

		if (count < 5) {
			switch (numArr[count++]) {

			case 1:
				quizMethod1();
				break;

			case 2:
				quizMethod2();
				break;

			case 3:
				quizMethod3();
				break;

			case 4:
				quizMethod4();
				break;

			case 5:
				quizMethod5();
				break;

			case 6:
				quizMethod6();
				break;

			case 7:
				quizMethod7();
				break;

			case 8:
				quizMethod8();
				break;

			case 9:
				quizMethod9();
				break;

			case 10:
				quizMethod10();
				break;

			}
		}
	}

	class Timer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				if (stop == true) {
					break;
				}
				if (time == 0) {

					timeP.setValue(time);
					JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
					frame.dispose();
					break;
				}

				timeP.setValue(time);
			}

		}
	}

}