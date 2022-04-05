package app.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import app.model.Translator;

@Service
public class BookService {

	public Book getBook() {
		return new Book("Book Name", new Author("Author. Name."),
				new Translator("Translator. Name."), "ISBN-CODE-123-456-789",
				new Publisher("Publisher. Name."), new Date(), 100.0);
	}
}
