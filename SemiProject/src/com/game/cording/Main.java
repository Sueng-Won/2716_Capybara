package com.game.cording;

public class Main {
	public static int[] rArr;
	public static int count = 0;
	public static void main(String[] args) {
		if (count == 0){
			randomOutPut();
		}
		QuizManager quizManager = new QuizManager();
		quizManager.QuizManager();

	}
	public static void randomOutPut(){
		rArr = new int[5];
		for (int i = 0; i < rArr.length; i++) {
			rArr[i] = (int)(Math.random() * 10) + 1;
			for (int j = 0; j < i; j++) {
				if (rArr[i] == rArr[j]){
					i--;
					break;
				}
			}
		}
	}
}
