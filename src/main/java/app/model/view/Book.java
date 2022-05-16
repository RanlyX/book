package app.model.view;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Id", "Author", "DateOfPublish", "Isbn", "Name", "Price", "Publisher", "Translator" })
public class Book {

	public Book() {
	}

	public Book(Long id, String author, Date dateOfPublish, String isbn, String name, Double price, String publisher,
			String translator) {
		this.id = id;
		this.author = author;
		this.translator = translator;
		this.isbn = isbn;
		this.dateOfPublish = dateOfPublish;
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.publisher = publisher;
		this.translator = translator;
	}

	@JsonProperty("Author")
	private String author;

	public String getAuthor() {
		return author;
	}

	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}

	@JsonProperty("Id")
	private Long id;

	public Long getId() {
		return id;
	}

	public Book setId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("Name")
	private String name;

	public String getName() {
		return name;
	}

	public Book setName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("Translator")
	private String translator;

	public String getTranslator() {
		return translator;
	}

	public Book setTranslator(String translator) {
		this.translator = translator;
		return this;
	}

	@JsonProperty("Isbn")
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public Book setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	@JsonProperty("Publisher")
	private String publisher;

	public String getPublisher() {
		return publisher;
	}

	public Book setPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	@JsonProperty("DateOfPublish")
	private Date dateOfPublish;

	public Date getDateOfPublish() {
		return dateOfPublish;
	}

	public Book setDateOfPublish(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
		return this;
	}

	@JsonProperty("Price")
	private Double price;

	public Double getPrice() {
		return price;
	}

	public Book setPrice(Double price) {
		this.price = price;
		return this;
	}

}
