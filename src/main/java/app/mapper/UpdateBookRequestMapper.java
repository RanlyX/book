package app.mapper;

import org.springframework.stereotype.Component;

import app.input.book.UpdateBookRequest;

@Component
public class UpdateBookRequestMapper implements RequestBodyMapperFactory<UpdateBookRequest> {
}
