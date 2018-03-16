package practice2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookManager {
	private List<Book> bookList;

	public BookManager() {
		bookList = new ArrayList<Book>();
	}

	public BookManager(ArrayList<Book> l) {
		bookList = l;
	}

	public void addBook(Book book) {
		bookList.add(book);
	}

	public void deleteBook(int index) {
		bookList.remove(index);
	}

	public int searchBook(String bTitle) {
		int index = -1;
		for (Book b : bookList) {
			if (b.getTitle().equals(bTitle)) {
				index = bookList.indexOf(b);
			}
		}
		return index;
	}

	public void printBook(int index) {
		if (index == -1) {
			System.out.println("책이 없습니다.");
		} else {
			Book tempB = bookList.get(index);
			System.out.println(tempB);
		}
	}

	public void displayAll() {
		Iterator<Book> iter = bookList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public Book[] sortedBookList() {
		Scanner sc = new Scanner(System.in);
		AscCategory asc = new AscCategory();
		DescCategroy des = new DescCategroy();
		Book tempB;
		Book[] tempArr = bookList.toArray(new Book[bookList.size()]);
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

	public void printBookList(Book[] br) {
		for (Book b : br) {
			System.out.println(b);
		}
	}
}
