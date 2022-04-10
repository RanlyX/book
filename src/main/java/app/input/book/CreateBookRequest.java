package app.input.book;

import java.util.Date;
import java.util.Optional;

public class CreateBookRequest {

	private Optional<String> name;

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

	private Optional<String> author;

	public Optional<String> getAuthor() {
		return author;
	}

	public void setAuthor(Optional<String> author) {
		this.author = author;
	}

	private Optional<String> translator;

	public Optional<String> getTranslator() {
		return translator;
	}

	public void setTranslator(Optional<String> translator) {
		this.translator = translator;
	}

	private Optional<String> isbn;

	public Optional<String> getIsbn() {
		return isbn;
	}

	public void setIsbn(Optional<String> isbn) {
		this.isbn = isbn;
	}

	private Optional<String> publisher;

	public Optional<String> getPublisher() {
		return publisher;
	}

	public void setPublisher(Optional<String> publisher) {
		this.publisher = publisher;
	}

	private Optional<Date> dateOfPublish;

	public Optional<Date> getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(Optional<Date> dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

	private Optional<Double> price;

	public Optional<Double> getPrice() {
		return price;
	}

	public void setPrice(Optional<Double> price) {
		this.price = price;
	}

}
