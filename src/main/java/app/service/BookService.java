package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Book;
import app.model.render.BookRender;
import app.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final BookRender bookRender;

	@Autowired
	public BookService(BookRepository bookRepository, BookRender bookRender) {
		this.bookRepository = bookRepository;
		this.bookRender = bookRender;
	}

	public Book getBook(Long id) {
		return bookRepository.getById(id);
	}

	public List<app.model.view.Book> getBooks() {
		List<Book> books = bookRepository.findAll();
		List<app.model.view.Book> bookViews = new ArrayList<>();
		for (Book book : books) {
			bookViews.add(this.bookRender.render(book));
		}
		return bookViews;
	}
}
