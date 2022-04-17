package app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// public class CustomErrorController {

// }

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends BasicErrorController {

	@Value("${server.error.path:${error.path:/error}}")
	private String path;

	public CustomErrorController(ServerProperties serverProperties) {
		super(new DefaultErrorAttributes(), serverProperties.getError());
	}

	/**
	 * override default JSON response
	 */
	// @Override
	// public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

	// 	HttpStatus status = getStatus(request);
	// 	Map<String, Object> map = new HashMap<String, Object>(16);
	// 	Map<String, Object> originalMsgMap = getErrorAttributes(request,
	// 			getErrorAttributeOptions(request, MediaType.ALL));
	// 	String path = (String) originalMsgMap.get("path");
	// 	String error = (String) originalMsgMap.get("error");
	// 	String message = (String) originalMsgMap.get("message");
	// 	// StringJoiner joiner = new StringJoiner(",", "[", "]");
	// 	// joiner.add(path).add(error).add(message);
	// 	map.put("Path", path);
	// 	map.put("Error", error);
	// 	map.put("Message", message);
	// 	return new ResponseEntity<Map<String, Object>>(map, status);
	// }

	/**
	 * override default HTML response
	 */
	// @Override
	// public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
	// 	// 請求的狀態
	// 	HttpStatus status = getStatus(request);
	// 	response.setStatus(getStatus(request).value());
	// 	Map<String, Object> model = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML));
	// 	ModelAndView modelAndView = resolveErrorView(request, response, status, model);
	// 	// 指定自定義的檢視
	// 	return (modelAndView == null ? new ModelAndView("error", model) : modelAndView);
	// }
}