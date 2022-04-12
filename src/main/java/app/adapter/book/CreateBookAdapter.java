package app.adapter.book;

import org.springframework.stereotype.Component;

import app.adapter.RequestAdapter;
import app.input.book.CreateBookRequest;
import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import app.model.Translator;

@Component
public class CreateBookAdapter implements RequestAdapter<Book, CreateBookRequest> {
	public Book convert(CreateBookRequest createBookRequest) {
		return new Book().setName(createBookRequest.getName().get())
				.setAuthor(new Author(createBookRequest.getAuthor().get())).setIsbn(createBookRequest.getIsbn().get())
				.setPublisher(new Publisher(createBookRequest.getPublisher().get()))
				.setTranslator(new Translator(createBookRequest.getTranslator().get()))
				.setPrice(createBookRequest.getPrice().get())
				.setDateOfPublish(createBookRequest.getDateOfPublish().get());
	}
}
