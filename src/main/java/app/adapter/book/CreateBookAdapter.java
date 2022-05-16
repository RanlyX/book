package app.adapter.book;

import org.springframework.stereotype.Component;

import app.adapter.RequestAdapter;
import app.input.book.CreateBookRequest;
import app.model.Book;

@Component
public class CreateBookAdapter implements RequestAdapter<Book, CreateBookRequest> {
	public Book convert(CreateBookRequest createBookRequest) {
		return new Book().setName(createBookRequest.getName().get()).setAuthor(createBookRequest.getAuthor().get())
				.setIsbn(createBookRequest.getIsbn().get()).setPublisher(createBookRequest.getPublisher().get())
				.setTranslator(createBookRequest.getTranslator().get()).setPrice(createBookRequest.getPrice().get())
				.setDateOfPublish(createBookRequest.getDateOfPublish().get());
	}
}
