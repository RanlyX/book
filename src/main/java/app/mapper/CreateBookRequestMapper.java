package app.mapper;

import org.springframework.stereotype.Component;

import app.input.book.CreateBookRequest;

@Component
public class CreateBookRequestMapper implements RequestBodyMapperFactory<CreateBookRequest> {
}
