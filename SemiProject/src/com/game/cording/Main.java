package com.game.cording;

public class Main {

	public static void main(String[] args) {
	//	randomOutput();
		Quiz10 q10 = new Quiz10();
		q10.Quiz10();
	}

	public static void randomOutput() {
		int count = 0;
		int[] numArr = new int[5];

		if (count == 0) {
			for (int i = 0; i < numArr.length; i++) {
				numArr[i] = (int) (Math.random() * 10) + 1;
				for (int j = 0; j < i; j++) {
					if (numArr[i] == numArr[j]) {
						i--;
						break;
					}
				}
			}
		}

		if (count < 5) {
			switch (numArr[count++]) {

			case 1:
				Quiz1 q = new Quiz1();
				q.Quiz1();
				break;

			case 2:
				Quiz2 q2 = new Quiz2();
				q2.Quiz2();
				break;

			case 3:
				Quiz3 q3 = new Quiz3();
				q3.Quiz3();
				break;

			case 4:
				Quiz4 q4 = new Quiz4();
				q4.Quiz4();
				break;

			case 5:
				Quiz5 q5 = new Quiz5();
				q5.Quiz5();
				break;

			case 6:
				Quiz6 q6 = new Quiz6();
				q6.Quiz6();
				break;

			case 7:
				Quiz7 q7 = new Quiz7();
				q7.Quiz7();
				break;

			case 8:
				Quiz8 q8 = new Quiz8();
				q8.Quiz8();
				break;

			case 9:
				Quiz9 q9 = new Quiz9();
				q9.Quiz9();
				break;

			case 10:
				Quiz10 q10 = new Quiz10();
				q10.Quiz10();
				break;

			}
		}
	}
}
