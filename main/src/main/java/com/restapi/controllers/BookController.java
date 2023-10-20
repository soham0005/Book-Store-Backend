package com.restapi.controllers;

import com.restapi.model.Book;
import com.restapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       return ResponseEntity.status(HttpStatus.CREATED).body(books);
    }


    @GetMapping("/api/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") int id){
        Book book = bookService.findById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

//    @GetMapping("/api/book/{book_genre}")
//    public ResponseEntity<Book> findByGenre(@PathVariable("book_genre") String book_genre){
//        Book book = bookService.findByGenre(book_genre);
//        if(book == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.of(Optional.of(book));
//    }

    @PostMapping("/api/books")
    public ResponseEntity<Optional<Book>> addBook(@RequestBody Book book){
        Book b = null;

        try{

            System.out.println("Book Controller");
            b = this.bookService.addBook(book);

            return ResponseEntity.ok(Optional.of(b));

        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") int id){
        try {
            this.bookService.deleteBookyId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/api/book/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id){
        try{
            this.bookService.updateBookById(book,id);
            return ResponseEntity.ok().body(book);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
