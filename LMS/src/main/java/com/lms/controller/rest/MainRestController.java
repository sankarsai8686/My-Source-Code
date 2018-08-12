package com.lms.controller.rest;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lms.models.Book;
import com.lms.services.LmsService;

@RestController
public class MainRestController {

	@Autowired
	private LmsService lmsService;
	
	
	
	
	@GetMapping(value="/findAllBooks")
	public Collection<Book> getAllBooks()
	{
		return lmsService.findAllBooks();
	}
	
	@GetMapping(value="/delete")
	public void deleteBook(@RequestParam long id)
	{
		lmsService.delete(id);
	}
	
	
	@GetMapping(value="/updateBookTest")
	public Optional<Book> init(@RequestParam long id)
	{
		return lmsService.findOne(id);
		
	}
	
}
