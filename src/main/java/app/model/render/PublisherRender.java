package app.model.render;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import app.model.Book;
import app.model.Publisher;

@Component
public class PublisherRender {
	public app.model.view.Publisher render(Publisher publisher) {
		Set<Book> books = publisher.getBooks();
		List<Long> bookIds = new ArrayList<>();
		if (books != null)
			for (Book book : books)
				bookIds.add(book.getId());
		return new app.model.view.Publisher().setId(publisher.getId()).setName(publisher.getName()).setBooks(bookIds);
	}
}
