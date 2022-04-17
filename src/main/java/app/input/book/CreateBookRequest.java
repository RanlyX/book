package app.input.book;

import java.util.Date;
import java.util.Optional;


import com.fasterxml.jackson.annotation.JsonProperty;

import app.property.InputFieldProperty;
import app.property.InputFieldProperty.CheckRange;
import app.property.InputFieldProperty.Type;

public class CreateBookRequest {

	@JsonProperty("Author")
	@InputFieldProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER, required = true)
	private Optional<String> author;

	@JsonProperty("DateOfPublish")
	@InputFieldProperty(type = Type.DATE, required = true)
	private Optional<Date> dateOfPublish;

	@JsonProperty("Isbn")
	@InputFieldProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER, required = true)
	private Optional<String> isbn;

	@JsonProperty("Name")
	@InputFieldProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER, required = true)
	private Optional<String> name;

	@JsonProperty("Price")
	@InputFieldProperty(type = Type.DOUBLE, min = Double.MIN_VALUE, max = Double.MAX_VALUE, checkRange = CheckRange.BOTH, required = false)
	private Optional<Double> price;

	@JsonProperty("Publisher")
	@InputFieldProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER, required = true)
	private Optional<String> publisher;

	@JsonProperty("Translator")
	@InputFieldProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER, required = false)
	private Optional<String> translator;

	public CreateBookRequest() {
	}

	public CreateBookRequest(CreateBookRequest createBookRequest) {
		this.author = createBookRequest.author;
		this.dateOfPublish = createBookRequest.dateOfPublish;
		this.isbn = createBookRequest.isbn;
		this.name = createBookRequest.name;
		this.price = createBookRequest.price;
		this.publisher = createBookRequest.publisher;
		this.translator = createBookRequest.translator;
	}

	public Optional<String> getAuthor() {
		return author;
	}

	public void setAuthor(Optional<String> author) {
		this.author = author;
	}

	public Optional<Date> getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(Optional<Date> dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

	public Optional<String> getIsbn() {
		return isbn;
	}

	public void setIsbn(Optional<String> isbn) {
		this.isbn = isbn;
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

	public Optional<Double> getPrice() {
		return price;
	}

	public void setPrice(Optional<Double> price) {
		this.price = price;
	}

	public Optional<String> getPublisher() {
		return publisher;
	}

	public void setPublisher(Optional<String> publisher) {
		this.publisher = publisher;
	}

	public Optional<String> getTranslator() {
		return translator;
	}

	public void setTranslator(Optional<String> translator) {
		this.translator = translator;
	}

}
