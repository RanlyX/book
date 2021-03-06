package app.validator;

import org.springframework.stereotype.Component;

import app.input.book.CreateBookRequest;

@Component
public class CreateBookRequestValidator implements InputFieldPropertyChecker<CreateBookRequest> {

	@Override
	public Class<?> getGenericClass() {
		return CreateBookRequest.class;
	}

}
