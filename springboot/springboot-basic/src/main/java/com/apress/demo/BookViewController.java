package com.apress.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookViewController {

	private final BookService bookService;

	public BookViewController(BookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping("/books.html")
	public String books(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "books/list";
	}
	@GetMapping("/index.html")
	public String index(Model model) {
		return "index";
	}
	@GetMapping(value = "/books.html", params = "isbn")
	public String get(@RequestParam("isbn") String isbn, Model model) {
		bookService.find(isbn).ifPresent(book -> model.addAttribute("book", book));
		return "books/details";
	}
}
