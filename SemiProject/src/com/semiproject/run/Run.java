package com.semiproject.run;

import java.util.Scanner;

import com.semiproject.service.ButtonEventBase;
import com.semiproject.service.ImageSwitchByButton;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("스윙이 종료되면 자동으로 종료됩니다.");
		System.out.println("1. 버튼 클릭_라벨 스트링 변환 예제");
		System.out.println("2. 버튼 클릭_이미지 변환 예제");
		System.out.print("입력 => ");
		int inputNum = sc.nextInt();
		
		switch(inputNum) {
		case 1:
			ButtonEventBase beb = new ButtonEventBase();
			break;
		case 2:
			ImageSwitchByButton isbb = new ImageSwitchByButton();
			break;
		default : 
			System.out.println("종료");
		}
		
	}

}
