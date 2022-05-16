package app.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.model.Book;
import app.repository.BookRepository;

@Configuration
public class BookConfig {

	@Bean
	CommandLineRunner commandLineRunner(BookRepository bookRepository) {
		return args -> {
			List<Book> books = new ArrayList<>();
			Book myBook = new Book().setName("myBook").setDateOfPublish(new Date()).setIsbn("09321545764765")
					.setPrice(100.0).setAuthor("myAuthor").setPublisher("myPublisher").setTranslator("myTranslator");
			Book yourBook = new Book().setName("yourBook").setDateOfPublish(new Date()).setIsbn("06589347346")
					.setPrice(777.0).setAuthor("yourAuthor").setPublisher("yourPublisher")
					.setTranslator("yourTranslator");
			books.add(myBook);
			books.add(yourBook);
			bookRepository.saveAll(books);
		};
	}
}
