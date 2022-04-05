package app.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.ServicePath;
import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import app.model.Translator;

@RestController
public class BookController {

	@GetMapping(value = ServicePath.BOOK_COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBook() {
		return new Book("Book Name", new Author("Author. Name."),
				new Translator("Translator. Name."), "ISBN-CODE-123-456-789",
				new Publisher("Publisher. Name."), new Date(), 100.0);
	}

}