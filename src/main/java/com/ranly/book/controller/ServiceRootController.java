package com.ranly.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class ServiceRootController {
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getEntry() {
		JsonObject entry = new JsonObject();
		entry.addProperty("Path", "/books");
		return entry.toString();
	}
}
