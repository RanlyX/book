package app.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.ServicePath;
import app.input.book.CreateBookRequest;
import app.input.book.UpdateBookRequest;
import app.mapper.CreateBookRequestMapper;
import app.mapper.UpdateBookRequestMapper;
import app.service.BookService;
import app.validator.CreateBookRequestValidator;
import app.validator.UpdateBookRequestValidator;

@RestController
public class BookController {

	private final BookService bookService;
	private final CreateBookRequestMapper createBookRequestMapper;
	private final UpdateBookRequestMapper updateBookRequestMapper;
	private final CreateBookRequestValidator createBookRequestValidator;
	private final UpdateBookRequestValidator updateBookRequestValidator;

	@Autowired
	public BookController(BookService bookService, CreateBookRequestMapper createBookRequestMapper,
			UpdateBookRequestMapper updateBookRequestMapper, CreateBookRequestValidator createBookRequestValidator,
			UpdateBookRequestValidator updateBookRequestValidator) {
		this.bookService = bookService;
		this.createBookRequestMapper = createBookRequestMapper;
		this.updateBookRequestMapper = updateBookRequestMapper;
		this.createBookRequestValidator = createBookRequestValidator;
		this.updateBookRequestValidator = updateBookRequestValidator;
	}

	@GetMapping(value = ServicePath.BOOK_COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<app.model.view.Book> getBooks()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, InstantiationException {
		return this.bookService.getBooks();
	}

	@PostMapping(value = ServicePath.BOOK_COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<app.model.view.Book> createBook(@RequestBody
	// CreateBookRequest createBookRequest) throws Exception {
	public ResponseEntity<?> createBook(@RequestBody String requestBody) throws Exception {
		CreateBookRequest createBookRequest = (CreateBookRequest) createBookRequestMapper.getRequestObject(requestBody,
				CreateBookRequest.class);
		createBookRequestValidator.checkInputFieldProperty(createBookRequest);
		return new ResponseEntity<>(this.bookService.addBook(createBookRequest), HttpStatus.CREATED);
		// return new ResponseEntity<>("123", HttpStatus.OK);
	}

	@GetMapping(value = ServicePath.BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
	public app.model.view.Book getBook(@PathVariable Long bookId)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, InstantiationException {
		return this.bookService.getBook(bookId);
	}

	@PutMapping(value = ServicePath.BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateBook(@PathVariable Long bookId, @RequestBody String requestBody) throws Exception {
		UpdateBookRequest updateBookRequest = (UpdateBookRequest) updateBookRequestMapper.getRequestObject(requestBody,
				UpdateBookRequest.class);
		UpdateBookRequestValidator ubrValidator = new UpdateBookRequestValidator();
		updateBookRequestValidator.checkInputFieldProperty(updateBookRequest);
		this.bookService.updateBook(bookId, updateBookRequest);
	}

	@DeleteMapping(value = ServicePath.BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteBook(@PathVariable Long bookId) {
		this.bookService.deleteBook(bookId);
	}

}