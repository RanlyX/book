package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.ServicePath;
import app.service.BookService;

@RestController
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = ServicePath.BOOK_COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<app.model.view.Book> getBooks() {
		return this.bookService.getBooks();
	}

}