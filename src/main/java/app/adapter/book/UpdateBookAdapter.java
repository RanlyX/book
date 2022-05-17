package app.adapter.book;

import org.springframework.stereotype.Component;

import app.adapter.RequestAdapter;
import app.input.book.UpdateBookRequest;
import app.model.Book;

@Component
public class UpdateBookAdapter implements RequestAdapter<Book, UpdateBookRequest> {
	public Book convert(UpdateBookRequest updateBookRequest) {
		return new Book().setName(updateBookRequest.getName().get()).setAuthor(updateBookRequest.getAuthor().get())
				.setIsbn(updateBookRequest.getIsbn().get()).setPublisher(updateBookRequest.getPublisher().get())
				.setTranslator(updateBookRequest.getTranslator().get()).setPrice(updateBookRequest.getPrice().get())
				.setDateOfPublish(updateBookRequest.getDateOfPublish().get());
	}
}