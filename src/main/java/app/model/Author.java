package app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "author", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Author {

	private Long id;
	private String name;
	private Set<Book> books;

	public Author() {
	}

	public Author(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public Author setId(Long id) {
		this.id = id;
		return this;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public Author setName(String name) {
		this.name = name;
		return this;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	public Set<Book> getBooks() {
		return books;
	}

	public Author setBooks(Set<Book> books) {
		this.books = books;
		return this;
	}
}