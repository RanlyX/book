package app.model.render;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import app.model.Author;
import app.model.Book;

@Component
public class AuthorRender implements ModelRender<app.model.view.Author, Author> {
	public app.model.view.Author render(Author author) {
		Set<Book> books = author.getBooks();
		List<Long> bookIds = new ArrayList<>();
		if (books != null)
			for (Book book : books)
				bookIds.add(book.getId());
		return new app.model.view.Author().setId(author.getId()).setName(author.getName()).setBooks(bookIds);
	}
}
