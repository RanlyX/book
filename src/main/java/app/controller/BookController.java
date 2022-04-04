package app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@RequestMapping(method = RequestMethod.GET, value = "/book")
	public String getBook() {
		return "Book";
	}

}