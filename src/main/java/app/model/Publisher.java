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
@Table(name = "publisher", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Publisher {
	private Long id;
	private String name;
	private Set<Book> books;

	public Publisher() {
	}

	public Publisher(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public Publisher setId(Long id) {
		this.id = id;
		return this;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public Publisher setName(String name) {
		this.name = name;
		return this;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "translator")
	public Set<Book> getBooks() {
		return books;
	}

	public Publisher setBooks(Set<Book> books) {
		this.books = books;
		return this;
	}
}