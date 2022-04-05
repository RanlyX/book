package app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "book", uniqueConstraints = { @UniqueConstraint(columnNames = { "isbn" }) })
public class Book {
	private Long id;
	private String name;
	private Author author;
	private Translator translator;
	private String isbn;
	private Publisher publisher;
	private Date dateOfPublish;
	private Double price;

	public Book() {
	}

	public Book(String name, Author author, Translator translator, String isbn, Publisher publisher, Date dateOfPublish,
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

	@OneToOne(fetch = FetchType.LAZY)
	public Author getAuthor() {
		return author;
	}

	public Book setAuthor(Author author) {
		this.author = author;
		return this;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Translator getTranslator() {
		return translator;
	}

	public Book setTranslator(Translator translator) {
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

	@OneToOne(fetch = FetchType.LAZY)
	public Publisher getPublisher() {
		return publisher;
	}

	public Book setPublisher(Publisher publisher) {
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