package app.service;

import org.springframework.stereotype.Service;

import app.model.Author;
import app.model.render.AuthorRender;
import app.repository.AuthorRepository;

@Service
public class AuthorService {

	private final AuthorRepository authorRepository;
	private final AuthorRender authorRender;
	
	public AuthorService(AuthorRepository authorRepository, AuthorRender authorRender) {
		this.authorRepository = authorRepository;
		this.authorRender = authorRender;
	}
	
	public app.model.view.Author addAuthor(Author author) {
		Author dbAuthor = this.authorRepository.findByName(author.getName());
		if (dbAuthor != null)
			return this.authorRender.render(dbAuthor);
		return this.authorRender.render(this.authorRepository.save(author));
	}

}
