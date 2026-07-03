package com.jpa.test.services;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.jpa.test.entities.Book;

@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12,"basic of java","qweqwer"));
		list.add(new Book(13,"basic of python","dfghj"));
		list.add(new Book(14,"basic of c++","qwerty"));

	}
	
	//get all books 
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get book by id 
	
	public Book getBookById(int id) {
		Book book= null;
		try {
			book = list.stream().filter(e->e.getId()==id).findFirst().get();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
	}
	
	
	//create a book
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//delete a book
	
	public void deleteBook(int id) {
		Book book = null;
		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		list.remove(book);
		System.out.println("Deleted successfully");
	}

	
	//update a book
	
	public void updateBook(Book book , int id) 
	{
		list = list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setDescription(book.getDescription());
				b.setId(book.getId());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
