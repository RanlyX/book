package app.model.render;

import org.springframework.stereotype.Component;

import app.model.Book;

@Component
public class BookRender implements ModelRender<app.model.view.Book, Book> {

	public app.model.view.Book render(Book book) {
		return new app.model.view.Book().setId(book.getId()).setAuthor(new AuthorRender().render(book.getAuthor()))
				.setIsbn(book.getIsbn()).setName(book.getName()).setPrice(book.getPrice())
				.setDateOfPublish(book.getDateOfPublish())
				.setPublisher(new PublisherRender().render(book.getPublisher()))
				.setTranslator(new TranslatorRender().render(book.getTranslator()));
	}

}
