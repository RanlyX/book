package app.input.book;

import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import app.property.DtoProperty;
import app.property.DtoProperty.CheckRange;
import app.property.DtoProperty.Type;

public class UpdateBookRequest {

	@JsonProperty("Author")
	@DtoProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER)
	private Optional<String> author;

	@JsonProperty("DateOfPublish")
	@DtoProperty(type = Type.DATE)
	private Optional<Date> dateOfPublish;

	@JsonProperty("Isbn")
	@DtoProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER)
	private Optional<String> isbn;

	@JsonProperty("Name")
	@DtoProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER)
	private Optional<String> name;

	@JsonProperty("Price")
	@DtoProperty(type = Type.DOUBLE, min = Double.MIN_VALUE, max = Double.MAX_VALUE, checkRange = CheckRange.BOTH)
	private Optional<Double> price;

	@JsonProperty("Publisher")
	@DtoProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER)
	private Optional<String> publisher;

	@JsonProperty("Translator")
	@DtoProperty(type = Type.STRING, min = 1, checkRange = CheckRange.LOWER)
	private Optional<String> translator;

	public UpdateBookRequest() {
	}

	public UpdateBookRequest(UpdateBookRequest updateBookRequest) {
		this.author = updateBookRequest.author;
		this.dateOfPublish = updateBookRequest.dateOfPublish;
		this.isbn = updateBookRequest.isbn;
		this.name = updateBookRequest.name;
		this.price = updateBookRequest.price;
		this.publisher = updateBookRequest.publisher;
		this.translator = updateBookRequest.translator;
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
