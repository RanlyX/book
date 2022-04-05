package app.model.view;

import java.util.Date;

public class Book {

	private String name;
	private String author;
	private String translator;
	private String isbn;
	private String publisher;
	private Date dateOfPublish;
	private Double price;

	public Book() {
	}

	public Book(String name, String author, String translator, String isbn, String publisher, Date dateOfPublish,
			Double price) {
		this.name = name;
		this.translator = translator;
		this.isbn = isbn;
		this.publisher = publisher;
		this.dateOfPublish = dateOfPublish;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Book setName(String name) {
		this.name = name;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getTranslator() {
		return translator;
	}

	public Book setTranslator(String translator) {
		this.translator = translator;
		return this;
	}

	public String getIsbn() {
		return isbn;
	}

	public Book setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public String getPublisher() {
		return publisher;
	}

	public Book setPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	public Date getDateOfPublish() {
		return dateOfPublish;
	}

	public Book setDateOfPublish(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
		return this;
	}

	public Double getPrice() {
		return price;
	}

	public Book setPrice(Double price) {
		this.price = price;
		return this;
	}
}
