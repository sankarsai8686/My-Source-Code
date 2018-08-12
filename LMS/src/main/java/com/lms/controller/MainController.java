package com.lms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.services.LmsService;

@Controller
public class MainController 
{
	@Autowired
	private LmsService lmsService;
	
	@GetMapping(value="/")
	public String init(HttpServletRequest req)
	{
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	@GetMapping(value="/updateBook")
	public String init(@RequestParam long id, HttpServletRequest req)
	{
		System.out.println("updateBook id = "+id);
		Optional<Book> optionalBook = lmsService.findOne(id);
		if (optionalBook.isPresent()){
			System.out.println("isPresent");
		    Book book_result = optionalBook.get();
		    req.setAttribute("book", book_result);
		   // processing with foo ...
		}
		else{
		   // alternative processing....
			System.out.println("no data");
			req.setAttribute("book", "");
		}
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder binder)
	{
		System.out.println("InitBinder");
		try
		{
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
			binder.registerCustomEditor(Date.class, "purchaseDate",new CustomDateEditor(sd, false));
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
		}
		catch (Exception e) {
			System.out.println("some Exception : "+e.getClass());
		}
	}
	
	
	@PostMapping(value="/saveBook")
	public void save(@ModelAttribute Book book,HttpServletRequest req,BindingResult bindingresult,HttpServletResponse res) throws IOException
	{
		System.out.println("saveBook");
		lmsService.save(book);
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		res.sendRedirect("/");
	}
	
	@GetMapping("/newBook")
	public String newBook(HttpServletRequest req,HttpServletResponse res)
	{
		System.out.println("newBook");
		req.setAttribute("mode", "BOOK_NEW");
		return "index";
	}
	
	@GetMapping("/deleteBook")
	public void deleteBook(@RequestParam long id,HttpServletResponse res) throws IOException
	{
		lmsService.delete(id);
		res.sendRedirect("/");
	}
}
