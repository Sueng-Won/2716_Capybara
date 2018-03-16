package practice3;

import java.util.HashMap;
import java.util.Scanner;

import practice2.Book;

public class TestBookManagerMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
		HashMap<String,Book> bMap = new HashMap<String,Book>();
		bMap.put("001", new Book("001",2,"잠을 자고싶어","닝겐1"));
		bMap.put("002",new Book("002",1,"잠을 너무 자고싶어","닝겐2"));
		bMap.put("003",new Book("003",4,"잠이 필요해","닝겐3"));
		bMap.put("004",new Book("004",3,"콜렉션을 죽입시다 콜렉션은 나의 원수","닝겐4"));
		
		BookManagerMap bm = new BookManagerMap(bMap);
		boolean flag = true;
		while (flag) {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println();
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			Scanner sc = new Scanner(System.in);
			System.out.print("=>");
			int inputNum = sc.nextInt();
			switch (inputNum) {
			case 1:
				bm.putBook(inputBook());
				break;
			case 2:
				bm.printBookMap(bm.sortedBookMap());
				break;
			case 3:
				System.out.print("삭제할 키 입력 : ");
				sc.nextLine();
				String key = sc.nextLine();
				bm.removeBook(key);
				break;
			case 4:
				System.out.print("도서명 입력 : ");
				sc.nextLine();
				String bTitle = sc.nextLine();
				bm.printBook(bm.searchBook(bTitle));
				break;
			case 5:
				bm.displayAll();
				break;
			case 6:
				System.out.println("프로그램 종료");
				flag = false;
				break;
			}
		}
	}

	public static Book inputBook() {
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		System.out.print("도서번호 입력(String) : ");
		String bNo = sc.next();
		b.setbNo(bNo);
		System.out.print("도서분류코드 입력(int) : ");
		int category = sc.nextInt();
		b.setCategory(category);
		System.out.print("책 제목 입력 : ");
		String title = sc.next();
		b.setTitle(title);
		sc.nextLine();
		System.out.print("저자 입력 : ");
		String author = sc.next();
		b.setAuthor(author);
		return b;
	}

}
