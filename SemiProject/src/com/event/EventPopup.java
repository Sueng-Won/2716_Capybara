package com.event;

import javax.swing.JOptionPane;

public class EventPopup {
	
	public void popupMessage() {
		int ratio = (int) (Math.random() * 20) + 1;
		
		if (ratio % 4 == 0) {
			JOptionPane.showMessageDialog(null, "훈련보상비 지급일!");
		}
	}
}