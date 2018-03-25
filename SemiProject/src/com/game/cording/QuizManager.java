package com.game.cording;

import javax.swing.JOptionPane;

public class QuizManager {
	public void QuizManager() {
		if (Main.count < 5) {
			switch (Main.rArr[Main.count++]) {
				case 1:
					Quiz1 q1 = new Quiz1();
					q1.quiz1();
					break;
				case 2:
					Quiz2 q2 = new Quiz2();
					q2.quiz2();
					break;
				case 3:
					Quiz3 q3 = new Quiz3();
					q3.quiz3();
					break;
				case 4:
					Quiz4 q4 = new Quiz4();
					q4.quiz4();
					break;
				case 5:
					Quiz5 q5 = new Quiz5();
					q5.quiz5();
					break;
				case 6:
					Quiz6 q6 = new Quiz6();
					q6.quiz6();
					break;
				case 7:
					Quiz7 q7 = new Quiz7();
					q7.quiz7();
					break;
				case 8:
					Quiz8 q8 = new Quiz8();
					q8.quiz8();
					break;
				case 9:
					Quiz9 q9 = new Quiz9();
					q9.quiz9();
					break;
				case 10:
					Quiz10 q10 = new Quiz10();
					q10.quiz10();
					break;
			}
		}
		else if(Main.count==5) {
			JOptionPane.showMessageDialog(null, "게임이 종료되었습니다.");
		}
	}
}
