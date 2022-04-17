package app.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapter.book.CreateBookAdapter;
import app.adapter.book.UpdateBookAdapter;
import app.input.book.CreateBookRequest;
import app.input.book.UpdateBookRequest;
import app.model.Book;
import app.model.render.BookRender;
import app.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final BookRender bookRender;
	private final CreateBookAdapter createBookAdapter;
	private final UpdateBookAdapter updateBookAdapter;

	@Autowired
	public BookService(BookRepository bookRepository, BookRender bookRender, CreateBookAdapter createBookAdapter,
			UpdateBookAdapter updateBookAdapter) {
		this.bookRepository = bookRepository;
		this.bookRender = bookRender;
		this.createBookAdapter = createBookAdapter;
		this.updateBookAdapter = updateBookAdapter;
	}

	public app.model.view.Book addBook(CreateBookRequest createBookRequest) throws Exception {

		Book book = createBookAdapter.convert(createBookRequest);
		return this.bookRender.render(bookRepository.save(book));
	}

	public app.model.view.Book getBook(Long id)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, InstantiationException {
		return this.bookRender.render(bookRepository.getById(id));
	}

	public List<app.model.view.Book> getBooks()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException,
			SecurityException, NoSuchMethodException, InstantiationException {
		List<Book> books = bookRepository.findAll();
		List<app.model.view.Book> bookViews = new ArrayList<>();
		for (Book book : books) {
			bookViews.add(this.bookRender.render(book));
		}
		return bookViews;
	}

	public app.model.view.Book updateBook(Long id, UpdateBookRequest updateBookRequest) {
		Book book = bookRepository.getById(id);
		Book newBook = updateBookAdapter.convert(updateBookRequest);
		book.setAuthor(newBook.getAuthor()).setDateOfPublish(newBook.getDateOfPublish()).setIsbn(newBook.getIsbn())
				.setName(newBook.getName()).setPrice(newBook.getPrice()).setPublisher(newBook.getPublisher())
				.setTranslator(newBook.getTranslator());
		return this.bookRender.render(bookRepository.save(book));
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
