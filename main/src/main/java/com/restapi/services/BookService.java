package com.restapi.services;

import com.restapi.dao.BookRepository;
import com.restapi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

//    private static List<Book> list = new ArrayList<>();
//    static {
//        list.add(new Book(101, "It Starts with Us", "Collen Hover", "Romance"));
//        list.add(new Book(102, "It Ends with Us", "Collen Hover", "Romance"));
//        list.add(new Book(103, "404 Mystrious Deaths", "404 Writer", "Horror"));
//    }

    @Autowired
    private BookRepository bookRepository;









    public List<Book> getAllBooks() {

        List<Book> bookList = (List<Book>) this.bookRepository.findAll();
        return bookList;
    }

//    public Book findByGenre(String book_genre){
//        Book book = null;
//        try{
//            book = this.bookRepository.findByBook_Genre(book_genre);
//        }
//        catch (Exception exception){
//            exception.printStackTrace();
//        }
//        return book;
//    }

    public Book findById(int id) {
        Book book = null;
        try {
            book =  this.bookRepository.findById(id);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return  book;

    }

    public Book addBook(Book b) {
        return this.bookRepository.save(b);
    }

    public void deleteBookyId(int id) {

        this.bookRepository.deleteById(id);
        System.out.println("Book Deleted Successfully");

    }

    public void updateBookById(Book book1,int id){

        book1.setBook_id(id);
        this.bookRepository.save(book1);
    }
}
