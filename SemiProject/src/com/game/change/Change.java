package com.game.change;

import java.util.Random;

public class Change {
	int[] locationX = {20,260,500,740,980};
	
	Random rand = new Random();
	
	public int[] changeLocationX() {
		int[] index = new int[5];
		int[] locationXCopy = new int[5];
		int count = 0;
		for(int i = 0; i<index.length;i++) {
			index[i] = rand.nextInt(5);
			for(int j = 0; j<i;j++) {
				if(index[i] == index[j]) {
					i--;
				}
			}
		}
		for(int indexNum : index) {
			locationXCopy[count++] = locationX[indexNum];
		}
		return locationXCopy;
	}
}
