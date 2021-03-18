package model;

public abstract class Book {
	
	private String name;
	private String authorName;
	private String isbn;
	private String type;
	private int total;
	
	public Book() {}
	
	public Book(String name, String authorName, String isbn, String type,int total) {
		this.name = name;
		this.authorName = authorName;
		this.isbn = isbn;
		this.type = type;
		this.setTotal(total);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return getName()+","+getAuthorName()+","+getIsbn()+","+getType()+","+getTotal();
	}
	
	
	
	

}
