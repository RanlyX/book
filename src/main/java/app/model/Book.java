package app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book", uniqueConstraints = { @UniqueConstraint(columnNames = { "isbn" }) })
public class Book {

	private Long id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public Book setId(Long id) {
		this.id = id;
		return this;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public Book setName(String name) {
		this.name = name;
		return this;
	}

	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}

	@Column(name = "translator")
	public String getTranslator() {
		return translator;
	}

	public Book setTranslator(String translator) {
		this.translator = translator;
		return this;
	}

	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	public Book setIsbn(String isbn) {
		this.isbn = isbn;
		return this;
	}

	@Column(name = "publisher")
	public String getPublisher() {
		return publisher;
	}

	public Book setPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	@Column(name = "publish_date")
	public Date getDateOfPublish() {
		return dateOfPublish;
	}

	public Book setDateOfPublish(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
		return this;
	}

	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	public Book setPrice(Double price) {
		this.price = price;
		return this;
	}

}