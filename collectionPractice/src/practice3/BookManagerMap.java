package practice3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import practice2.AscCategory;
import practice2.Book;
import practice2.DescCategroy;

public class BookManagerMap {
	private HashMap<String, Book> booksMap;

	public BookManagerMap() {
		booksMap = new HashMap<String, Book>();
	}

	public BookManagerMap(HashMap<String, Book> hm) {
		booksMap = hm;
	}

	public void putBook(Book book) {
		booksMap.put(book.getbNo(), book);
	}

	public void removeBook(String key) {
		booksMap.remove(key);
	}

	public String searchBook(String bTitle) {
		String str = null;
		Set<Entry<String, Book>> set = booksMap.entrySet();
		Iterator<Entry<String, Book>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Book> entry = (Map.Entry<String, Book>) iter.next();
			String key = (String) entry.getKey();
			String value = ((Book) entry.getValue()).getTitle();
			if (value.equals(bTitle)) {
				str = key;
			}
		}
		return str;
	}

	public void displayAll() {
		Set<String> set = booksMap.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public Book[] sortedBookMap() {
		Scanner sc = new Scanner(System.in);
		Book[] tempArr = new Book[booksMap.size()];
		AscCategory asc = new AscCategory();
		DescCategroy des = new DescCategroy();
		Book tempB;
		int count = 0;
		Set<Entry<String, Book>> set = booksMap.entrySet();
		Iterator<Entry<String, Book>> iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Book> entry = (Map.Entry<String, Book>) iter.next();
			tempArr[count++] = entry.getValue();
		}
		System.out.println("1. 오름차순");
		System.out.println("2. 내림차순");
		System.out.println("기본값은 오름차순으로 출력됩니다.");
		System.out.print("입력 =>");
		int inputNum = sc.nextInt();
		if (inputNum == 2) {
			for (int i = 0; i < tempArr.length; i++) {
				for (int j = i + 1; i < tempArr.length; j++) {
					if (des.compare(tempArr[i], tempArr[j]) > 0) {
						tempB = tempArr[i];
						tempArr[i] = tempArr[j];
						tempArr[j] = tempB;
					}
				}
			}
		} else {
			for (int i = 0; i < tempArr.length; i++) {
				for (int j = i + 1; j < tempArr.length; j++) {
					if (asc.compare(tempArr[i], tempArr[j]) > 0) {
						tempB = tempArr[i];
						tempArr[i] = tempArr[j];
						tempArr[j] = tempB;
					}
				}
			}
		}
		return tempArr;
	}
	
	public void printBookMap(Book[] br) {
		for(Book b : br) {
			System.out.println(b);
		}
	}
	
	public void printBook(String key) {
		System.out.println(booksMap.get(key));
	}
}
