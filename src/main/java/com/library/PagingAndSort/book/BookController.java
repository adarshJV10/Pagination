package com.library.PagingAndSort.book;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;


@RestController
public class BookController 
{
	@Autowired
	BookRepository bookrepository;
	
	
	@PostMapping("/addbook")
	public Book createBook(@RequestBody Book book)
	{
		return bookrepository.save(book);
	}
	
	@PostMapping("/addbooks")
	public List<Book> createBookList(@RequestBody List<Book> book)
	{
		return bookrepository.saveAll(book);
	}
	
	@GetMapping("/getbook")
	public ResponseEntity <List<Book>> getBookList()
	{
		return ResponseEntity.ok(bookrepository.findAll());
	}
	
	
	@GetMapping("bookById/{id}")
	public Book findProduct(@PathVariable Long id)
	{
		return bookrepository.findById(id).get();
	}
	
	
	//Pagination and sorting
	@GetMapping("/pagination")
	public List<Book> getProductPagination(@RequestParam int page, @RequestParam int size)
	{
//		'PageRequest' is a concrete implementation class of the 'Pageable' interface..
//		while you can't directly instantiate an interface, you can instantiate a concrete 
//		class that implements that interface. PageRequest.of(page, size) is a static factory 
//		method that returns an instance of PageRequest, which is a concrete implementation of the Pageable interface
		
		 Pageable pageable = PageRequest.of(page, size);
		 List<Book> list = bookrepository.findAll(pageable).getContent();
		 return list;
	}
	
	
	@GetMapping("/filter")
	public List<Book> getProductSort(@RequestParam int id)
	{
		return bookrepository.findById(id);
	}
	
}

