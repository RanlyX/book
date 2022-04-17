package app.exception;

import java.util.Arrays;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;

import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import app.message.MessageParamTypeException;
import app.message.MessageParametersLengthException;
import app.message.NotFoundExceptionMessage;
import app.model.render.MessageRender;

@ControllerAdvice
public class ApiExceptionHandler {

	private final MessageRender messageRender = new MessageRender();

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> toResponseEntity(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Object>("Internal Error\n" + e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ResponseBody
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ResponseEntity<Object> toResponseEntity(IllegalArgumentException e) {
//		return new ResponseEntity<Object>("Not found\n" + e.getMessage(), HttpStatus.NOT_FOUND);
//	}

//	@ResponseBody
//	@ExceptionHandler(EntityNotFoundException.class)
//	public ResponseEntity<Object> toResponseEntity(HttpServletRequest request, EntityNotFoundException e) throws MessageParametersLengthException, MessageParamTypeException {
//		app.model.view.Message message = messageRender.render(new NotFoundExceptionMessage(Arrays.asList(request.getRequestURL().toString())));
//		System.out.println(message);
//		return new ResponseEntity<Object>(message.toString() , HttpStatus.NOT_FOUND);
//	}

	// @ResponseBody
	// @ExceptionHandler(NoHandlerFoundException.class)
	// public ResponseEntity<Object> toResponseEntity(NoHandlerFoundException e) {
	// 	NotFoundExceptionMessage notFoundExceptionMessage =	new NotFoundExceptionMessage(Arrays.asList((String) originalMsgMap.get("path")));
	// 	return new ResponseEntity<Object>("Not found\n" + e.getMessage(), HttpStatus.NOT_FOUND);
	// }

	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> toResponseEntity(HttpMessageNotReadableException e) {
		if (e.getMostSpecificCause() instanceof JsonParseException) {
			JsonParseException ex = (JsonParseException) e.getMostSpecificCause();
			return new ResponseEntity<Object>("Malformed JSON\n" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
