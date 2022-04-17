package app.validator;

import org.springframework.stereotype.Component;

import app.input.book.UpdateBookRequest;

@Component
public class UpdateBookRequestValidator implements InputFieldPropertyChecker<UpdateBookRequest> {

	@Override
	public Class<UpdateBookRequest> getGenericClass() {
		return UpdateBookRequest.class;
	}

}
