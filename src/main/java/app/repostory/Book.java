package app.repostory;

import java.util.Date;

public class Book {

	private Integer id;
	private String name;
	private Author author;
	private Translator translator;
	private String isbn;
	private Publisher publisher;
	private Date publishDate;
	private Double price;

	public Book() {
	}

	public Book(Integer id, String name, Author author, Translator translator, String isbn, Publisher publisher,
			Date publishDate, Double price) {
		this.id = id;
		this.name = name;
		this.translator = translator;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Translator getTranslator() {
		return translator;
	}

	public void setTranslator(Translator translator) {
		this.translator = translator;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}