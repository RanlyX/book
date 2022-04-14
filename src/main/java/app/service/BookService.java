package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapter.book.CreateBookAdapter;
import app.input.book.CreateBookRequest;
import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import app.model.Translator;
import app.model.render.BookRender;
import app.repository.AuthorRepository;
import app.repository.BookRepository;
import app.repository.PublisherRepository;
import app.repository.TranslatorRepository;
import app.validator.CreateBookRequestValidator;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final BookRender bookRender;
	private final AuthorRepository authorRepository;
	private final PublisherRepository publisherRepository;
	private final TranslatorRepository translatorRepository;
	private final CreateBookAdapter createBookAdapter;

	@Autowired
	public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
			PublisherRepository publisherRepository, TranslatorRepository translatorRepository, BookRender bookRender,
			CreateBookAdapter createBookAdapter) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
		this.translatorRepository = translatorRepository;
		this.bookRender = bookRender;
		this.createBookAdapter = createBookAdapter;
	}

	private Author addAuthor(Author author) {
		Author dbAuthor = this.authorRepository.findByName(author.getName());
		if (dbAuthor != null)
			return dbAuthor;
		return this.authorRepository.save(author);
	}

	private Publisher addPublisher(Publisher publisher) {
		Publisher dbPublisher = this.publisherRepository.findByName(publisher.getName());
		if (dbPublisher != null)
			return dbPublisher;
		return this.publisherRepository.save(publisher);
	}

	private Translator addTranslator(Translator translator) {
		Translator dbTranslator = this.translatorRepository.findByName(translator.getName());
		if (dbTranslator != null)
			return dbTranslator;
		return this.translatorRepository.save(translator);
	}

	public app.model.view.Book addBook(CreateBookRequest createBookRequest) throws Exception {
		CreateBookRequestValidator cbrValidator = new CreateBookRequestValidator();
		cbrValidator.checkInputFieldProperty(createBookRequest);
		Book book = createBookAdapter.convert(createBookRequest);
		Author author = this.addAuthor(new Author(book.getAuthor().getName()));
		Publisher publisher = this.addPublisher(new Publisher(book.getPublisher().getName()));
		Translator translator = this.addTranslator(new Translator(book.getTranslator().getName()));
		return this.bookRender.render(bookRepository.save(book.setAuthor(author).setPublisher(publisher).setTranslator(translator)));
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
