package com.restapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private String book_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author book_author;
    private String book_genre;

    public Book(){

    }

    public Book(int book_id, String book_name, Author book_author, String book_genre) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_genre = book_genre;
    }


    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Author getBook_author() {
        return book_author;
    }

    public void setBook_author(Author book_author) {
        this.book_author = book_author;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_genre='" + book_genre + '\'' +
                '}';
    }
}
