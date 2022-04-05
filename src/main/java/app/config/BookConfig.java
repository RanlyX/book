package app.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import app.model.Translator;
import app.repository.AuthorRepository;
import app.repository.BookRepository;
import app.repository.PublisherRepository;
import app.repository.TranslatorRepository;

@Configuration
public class BookConfig {

	@Bean
	CommandLineRunner commandLineRunner(BookRepository bookRepository, AuthorRepository authorRepository,
			PublisherRepository publisherRepository, TranslatorRepository translatorRepository) {
		return args -> {
			List<Author> authors = new ArrayList<>();
			Author myAuthor = new Author("myAuthor");
			Author yourAuthor = new Author("yourAuthor");
			authors.add(myAuthor);
			authors.add(yourAuthor);
			authorRepository.saveAll(authors);

			List<Publisher> publishers = new ArrayList<>();
			Publisher myPublisher = new Publisher("myPublisher");
			Publisher yourPublisher = new Publisher("yourPublisher");
			publishers.add(myPublisher);
			publishers.add(yourPublisher);
			publisherRepository.saveAll(publishers);

			List<Translator> translators = new ArrayList<>();
			Translator myTranslator = new Translator("myTranslator");
			Translator yourTranslator = new Translator("yourTranslator");
			translators.add(myTranslator);
			translators.add(yourTranslator);
			translatorRepository.saveAll(translators);

			List<Book> books = new ArrayList<>();
			Book myBook = new Book().setName("myBook").setDateOfPublish(new Date()).setIsbn("09321545764765")
					.setPrice(100.0).setAuthor(myAuthor).setPublisher(myPublisher).setTranslator(myTranslator);
			Book yourBook = new Book().setName("yourBook").setDateOfPublish(new Date()).setIsbn("06589347346")
					.setPrice(777.0).setAuthor(yourAuthor).setPublisher(yourPublisher).setTranslator(yourTranslator);
			books.add(myBook);
			books.add(yourBook);
			bookRepository.saveAll(books);
		};
	}
}
