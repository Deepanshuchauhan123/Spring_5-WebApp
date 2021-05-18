package com.deepanshu.springwebproject.controller;

import com.deepanshu.springwebproject.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("allbooks", bookRepository.findAll());
        return "books/list";
    }
}
