package app.model.render;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import app.model.Book;
import app.model.Translator;

@Component
public class TranslatorRender {
	public app.model.view.Translator render(Translator translator) {
		Set<Book> books = translator.getBooks();
		List<Long> bookIds = new ArrayList<>();
		if (books != null)
			for (Book book : books)
				bookIds.add(book.getId());
		return new app.model.view.Translator().setId(translator.getId()).setName(translator.getName())
				.setBooks(bookIds);
	}
}
