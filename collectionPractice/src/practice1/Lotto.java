package practice1;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lottoDisplay();
	}

	public static void lottoDisplay() {
		Set<Integer> s = new TreeSet<Integer>();
		int value = 0;
		for (int i = 0; i < 6; i++) {
			Random rand = new Random();
			value = rand.nextInt(45) + 1;
			if (s.contains(value)) {
				i--;
			} else {
				s.add(value);
			}
		}
		int[] lottoArr = new int[s.size()];

		Iterator<Integer> iter = s.iterator();
		for (int i = 0; i < s.size(); i++) {
			lottoArr[i] = iter.next();
			System.out.println((i + 1) + "번째 번호 : " + lottoArr[i]);
		}
	}
}
