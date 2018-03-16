package practice2;

import java.util.Comparator;

public class AscCategory implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		// TODO Auto-generated method stub
		String b1Name = String.valueOf(b1.getCategory());
		String b2Name = String.valueOf(b2.getCategory());
		return b1Name.compareTo(b2Name);
	}

}
