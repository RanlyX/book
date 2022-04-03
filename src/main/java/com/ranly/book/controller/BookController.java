package com.ranly.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public String getBooks() {
        return "Books";
    }
}