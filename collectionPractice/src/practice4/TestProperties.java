//package practice4;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Properties;
//
//public class TestProperties {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	}
//	public Student[] readFile() {
//		Properties prop = new Properties();
//		ArrayList<Double> score = new ArrayList<Double>();
//		try(FileReader fr = new FileReader("score.txt");
//				BufferedReader br = new BufferedReader(fr)){
//			while(br.readLine()!=null) {
//				String str = br.readLine();
//				String[] temp = str.split(", ");
//				for(int i = 0 ;i<temp.length;i++) {
//					
//				}
//			}
//		}catch(FileNotFoundException fnfe) {
//			fnfe.printStackTrace();
//		}catch(IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}
//}
