package app.model.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Id", "Books", "Name" })
public class Publisher {

	public Publisher() {
	}

	public Publisher(Long id, String name, List<Long> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	@JsonProperty("Id")
	private Long id;

	public Long getId() {
		return id;
	}

	public Publisher setId(Long id) {
		this.id = id;
		return this;
	}

	@JsonProperty("Name")
	private String name;

	public String getName() {
		return name;
	}

	public Publisher setName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("Books")
	private List<Long> books;

	public List<Long> getBooks() {
		return books;
	}

	public Publisher setBooks(List<Long> books) {
		this.books = books;
		return this;
	}

}
