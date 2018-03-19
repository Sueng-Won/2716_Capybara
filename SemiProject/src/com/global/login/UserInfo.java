package com.global.login;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserInfo {
	public void inputUser(String name) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("userInfo.dat", true));			
				) {

			bw.write(name);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
