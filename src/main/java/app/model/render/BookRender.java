package app.model.render;

import org.springframework.stereotype.Component;

import app.model.Book;

@Component
public class BookRender implements ModelRender<app.model.view.Book, Book> {

	public app.model.view.Book render(Book book) {
		return new app.model.view.Book().setAuthor(book.getAuthor().getName()).setIsbn(book.getIsbn())
				.setName(book.getName()).setPrice(book.getPrice()).setDateOfPublish(book.getDateOfPublish())
				.setPublisher(book.getPublisher().getName()).setTranslator(book.getTranslator().getName());
	}

}
