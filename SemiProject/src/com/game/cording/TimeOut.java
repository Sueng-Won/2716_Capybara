package com.game.cording;

import java.io.*;

public class TimeOut {
    public void TimeOut(){
        try (BufferedReader br = new BufferedReader(new FileReader("Sender.dat"))) {

            String[] tempStr = new String[7];
            String temp;
            int check = 0;
            int[] valueArr = new int[7];
            while ((temp = br.readLine()) != null) {
                tempStr[check++] = temp;
            }
            for (int i = 0; i < 7; i++) {
                valueArr[i] = Integer.parseInt(tempStr[i]);
            }
            valueArr[Main.count-1]+=-40;
            valueArr[5] += 10;
            valueArr[6] += 100;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Sender.dat"))) {
                for (int i = 0; i < 7; i++) {
                    bw.write(String.valueOf(valueArr[i]));
                    bw.newLine();
                }
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
