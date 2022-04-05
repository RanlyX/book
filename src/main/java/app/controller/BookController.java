package app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.ServicePath;
import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import app.model.Translator;
import app.service.BookService;

@RestController
public class BookController {

	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(value = ServicePath.BOOK_COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBook() {
		return this.bookService.getBook();
	}

}