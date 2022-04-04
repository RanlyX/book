package app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class ServiceRootController {
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getServiceRoot() {
		JsonObject entry = new JsonObject();
		entry.addProperty("Path", "/api/v1");
		return entry.toString();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/v1")
	public String getApiEntry() {
		JsonObject entry = new JsonObject();
		entry.addProperty("Path", "/api/v1/book");
		return entry.toString();
	}
}
