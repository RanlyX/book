package app.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.ServicePath;
import app.repostory.Author;
import app.repostory.Book;
import app.repostory.Publisher;
import app.repostory.Translator;

@RestController
public class BookController {

	@GetMapping(value = ServicePath.BOOK_COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBook() {
		return new Book(1, "Book Name", new Author(1, "Author. Name.", null),
				new Translator(1, "Translator. Name.", null), "ISBN-CODE-123-456-789",
				new Publisher(1, "Publisher. Name.", null), new Date(), 100.0);
	}

}