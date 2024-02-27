package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Book;
import com.project.repository.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository br;

	@GetMapping("/")
	public String showForm(Model model, Book book) {
		model.addAttribute("bookData", book);
		
		return "index"; // file name
	}
	
	// save book to DB
	@PostMapping("/save")
	public String saveBook(@Validated @ModelAttribute("bookData") Book book, 
							BindingResult result, Model model) {
		
		// hasErrors()
		
		if(result.hasErrors()) {
			System.out.println("Data is not proper.");
			return "index";
		}
		
		br.save(book);
		
		model.addAttribute("msg", "Product added...");
		
		return "index";
	}
	
	// show book data form
	@GetMapping("/book")
	public String showBookForm() {
		return "book";
	}
	
	@GetMapping("/view")
	public String viewBook(@RequestParam("id") Integer id, Model model) {
		
		/*
		 * getById -- deprecated
		 */
		
//		Book book = br.getById(id);		
//		model.addAttribute("bookData", book);
		
		
		/*
		 * findById -- deprecated
		 */
		
//		optional --> check --> get --> store on respective object
		
		Optional<Book> opt = br.findById(id);
		
		if(opt.isPresent()) {
			Book book = opt.get();
			
			model.addAttribute("bookData", book);
			
		}else {
			model.addAttribute("bookData", "Not Found");
			
		}
		
		return "book";
	}
	
	
	// get all books
	@GetMapping("/all-books")
	public String getAllBooks(Model model) {
		
		List<Book> books = br.findAll();
		
		model.addAttribute("books", books);
		
		return "all-books";
	}
	
	
	// edit books
	@GetMapping("/edit-book/{id}")
	public String editBook(@PathVariable("id") Integer id, Model model) {
		
		Optional<Book> byId = br.findById(id);
		
		if(byId.isPresent()) {
			Book book = byId.get();
			
			model.addAttribute("bookData", book);
		}
		
		return "index";
	}
	
	@GetMapping("/delete-book/{id}")
	public String deleteBook(@PathVariable("id") Integer id, Model model) {
		
		br.deleteById(id);
		
		model.addAttribute("msg", "Product deleted...");
		
		return "redirect:/all-books";
	}
	
	/*
	 * validation
	 * Tomcat --> another server   jetty, netty
	 * Exception
	 * 
	 */
	
}
	