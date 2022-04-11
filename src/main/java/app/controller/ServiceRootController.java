package app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import app.ServicePath;

@RestController
public class ServiceRootController {

	@GetMapping(value = ServicePath.ROOT_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getServiceRoot() {
		JsonObject entry = new JsonObject();
		entry.addProperty("ApiRoot", ServicePath.API_ROOT);
		return entry.toString();
	}

	@GetMapping(value = ServicePath.API_ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getApiRoot() {
		JsonObject entry = new JsonObject();
		entry.addProperty("ApiEntry", ServicePath.API_ENTRY);
		return entry.toString();
	}

	@GetMapping(value = ServicePath.API_ENTRY, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getApiEntry() {
		JsonObject entry = new JsonObject();
		entry.addProperty("BookCollection", ServicePath.BOOK_COLLECTION);
		return entry.toString();
	}

}
