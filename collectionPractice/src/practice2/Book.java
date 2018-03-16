package practice2;

public class Book {
	private String bNo;
	private int category;
	private String title;
	private String author;
	
	public Book() {
		
	}

	public Book(String bNo, int category, String title, String author) {
		this.bNo = bNo;
		this.category = category;
		this.title = title;
		this.author = author;
	}

	public String getbNo() {
		return bNo;
	}

	public int getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "bNo : "+this.bNo+" category : "+this.category+" title : "+this.title+" author : "+this.author;
	}
}
