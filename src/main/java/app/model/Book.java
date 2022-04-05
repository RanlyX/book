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
@Table(name="book", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "isbn" })
})
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
	
	public Book(String name, Author author, Translator translator, String isbn, Publisher publisher, Date dateOfPublish, Double price) {
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
    
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	public Translator getTranslator() {
		return translator;
	}
	
	public void setTranslator(Translator translator) {
		this.translator = translator;
	}
	
	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	@Column(name = "publish_date")
	public Date getPublishDate() {
		return dateOfPublish;
	}
	
	public void setPublishDate(Date dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}
	
	@Column(name = "price")
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}