package Bean;

public class Book {
	private String bookname, author;
	private Integer price;
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}	
	
	@Override
	public boolean equals(Object o) {
		Book b=(Book) o;
		return this.bookname.equals(b.bookname) && this.author.equals(b.author);
	}
}
