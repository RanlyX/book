package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapter.book.CreateBookAdapter;
import app.input.book.CreateBookRequest;
import app.model.Book;
import app.model.render.BookRender;
import app.repository.BookRepository;
import app.validator.CreateBookRequestValidator;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final BookRender bookRender;
	private final CreateBookAdapter createBookAdapter;

	@Autowired
	public BookService(BookRepository bookRepository, BookRender bookRender, CreateBookAdapter createBookAdapter) {
		this.bookRepository = bookRepository;
		this.bookRender = bookRender;
		this.createBookAdapter = createBookAdapter;
	}

	public app.model.view.Book addBook(CreateBookRequest createBookRequest) throws Exception {
		CreateBookRequestValidator cbrValidator = new CreateBookRequestValidator();
		cbrValidator.checkInputFieldProperty(createBookRequest);
		Book book = createBookAdapter.convert(createBookRequest);
		return this.bookRender.render(bookRepository.save(book));
	}

	public app.model.view.Book getBook(Long id) {
		return this.bookRender.render(bookRepository.getById(id));
	}

	public List<app.model.view.Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		List<app.model.view.Book> bookViews = new ArrayList<>();
		for (Book book : books) {
			bookViews.add(this.bookRender.render(book));
		}
		return bookViews;
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
